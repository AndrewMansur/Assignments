import grpc
from concurrent import futures
import argparse
import time
import sys
sys.path.append('./generated')
import calculator_pb2
import calculator_pb2_grpc

class CalculatorServicer(calculator_pb2_grpc.CalculatorServicer):
    def __init__(self, fail=False, wait=False):
        """
        Args:
            fail: If True, server will crash on every request
            wait: If True, server will wait 10 seconds on every request
        """
        self.fail = fail
        self.wait = wait

    def Add(self, request, context):
        """Add two numbers and return the result.

        Args:
            request: BinaryOperation with fields a and b
            context: gRPC service context
        """
        if self.fail:
            context.abort(grpc.StatusCode.UNAVAILABLE, "Simulated server crash")

        if self.wait:
            time.sleep(10)  # Wait 10 seconds 
        result = request.a + request.b
        return calculator_pb2.Result(value=result)

    def Subtract(self, request, context):
        """Subtract two numbers and return the result.

        Args:
            request: BinaryOperation with fields a and b
            context: gRPC service context
        """
        if self.fail:
            context.abort(grpc.StatusCode.UNAVAILABLE, "Simulated server crash")
        if self.wait:
            time.sleep(10)

        result = request.a - request.b
        return calculator_pb2.Result(value=result)

    def Multiply(self, request, context):
        """Multiply two numbers and return the result.

        Args:
            request: BinaryOperation with fields a and b
            context: gRPC service context
        """
        if self.fail:
            context.abort(grpc.StatusCode.UNAVAILABLE, "Simulated server crash")
        if self.wait:
            time.sleep(10)

        result = request.a * request.b
        return calculator_pb2.Result(value=result)

    def Divide(self, request, context):
        """Divide two numbers and return the result. Aborts with INVALID_ARGUMENT if divisor is zero.

        Args:
            request: BinaryOperation with fields a and b
            context: gRPC service context
        """
        if self.fail:
            context.abort(grpc.StatusCode.UNAVAILABLE, "Simulated server crash")
        if self.wait:
            time.sleep(10)

        if request.b == 0.0:  
            context.abort(grpc.StatusCode.INVALID_ARGUMENT, "Division by zero")

        result = request.a / request.b
        return calculator_pb2.Result(value=result)

def serve(fail=False, wait=False):
    """Start the gRPC server."""
    # This is the correct line
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    
    calculator_pb2_grpc.add_CalculatorServicer_to_server(
        CalculatorServicer(fail=fail, wait=wait),
        server
    )
    
    server.add_insecure_port('[::]:50051')

    print(f"Server starting on port 50051...")
    if fail:
        print("⚠️  Server will CRASH on every request")
    if wait:
        print("⏱️  Server will WAIT 10 seconds on every request")
    
    server.start()
    server.wait_for_termination()

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Calculator Server')
    parser.add_argument('--fail', action='store_true',
                        help='Server crashes on every request')
    parser.add_argument('--wait', action='store_true',
                        help='Server waits 10 seconds on every request')
    args = parser.parse_args()

    serve(fail=args.fail, wait=args.wait)