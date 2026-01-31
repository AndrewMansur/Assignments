import grpc
import sys
import time
import random
from datetime import datetime
sys.path.append('./generated')
import calculator_pb2
import calculator_pb2_grpc


# Configuration Constants
DEFAULT_TIMEOUT = 2  # seconds - timeout for each RPC call
MAX_RETRIES = 3      # maximum number of retry attempts (for divide method only)


def create_client_stub(address='localhost:50051'):
    """
    Create and return a Calculator stub.

    Args:
        address: Server address (default: 'localhost:50051')

    Returns:
        calculator_pb2_grpc.CalculatorStub: The gRPC stub
    """

    channel = grpc.insecure_channel(address)

    stub = calculator_pb2_grpc.CalculatorStub(channel)

    return stub
    

def add(stub, a, b):
    """
    Add two numbers.
    Note: No retry logic needed - fail immediately on errors.

    Args:
        stub: The gRPC stub
        a: First operand
        b: Second operand

    Returns:
        Result: The operation result
    """
    request = calculator_pb2.BinaryOperation(a=float(a), b=float(b))
    try:
        response = stub.Add(request, timeout=DEFAULT_TIMEOUT)
        return response.value
    except grpc.RpcError as e:
        if e.code() == grpc.StatusCode.DEADLINE_EXCEEDED:
            print(f"TIMEOUT in add({a}, {b}): {DEFAULT_TIMEOUT}s exceeded")
            # logger.warning(f"Timeout in add({a},{b})")  # alternative
        raise  # let caller handle or fail test

def subtract(stub, a, b):
    """
    Subtract two numbers.
    Note: No retry logic needed - fail immediately on errors.
    """
    request = calculator_pb2.BinaryOperation(a=float(a), b=float(b))
    try:
        response = stub.Subtract(request, timeout=DEFAULT_TIMEOUT)
        return response.value
    except grpc.RpcError as e:
        if e.code() == grpc.StatusCode.DEADLINE_EXCEEDED:
            print(f"TIMEOUT in subtract({a}, {b}): {DEFAULT_TIMEOUT}s exceeded")
        raise

def multiply(stub, a, b):
    """
    Multiply two numbers.
    Note: No retry logic needed - fail immediately on errors.
    """
    request = calculator_pb2.BinaryOperation(a=float(a), b=float(b))
    try:
        response = stub.Multiply(request, timeout=DEFAULT_TIMEOUT)
        return response.value
    except grpc.RpcError as e:
        if e.code() == grpc.StatusCode.DEADLINE_EXCEEDED:
            print(f"TIMEOUT in multiply({a}, {b}): {DEFAULT_TIMEOUT}s exceeded")
        raise

def divide(stub, a, b):
    """
    Divide two numbers.

    Args:
        stub: The gRPC stub
        a: First operand
        b: Second operand (divisor)

    Returns:
        float: The operation result, OR one of these error strings:
        - "INVALID_ARGUMENT" if b=0 (division by zero)
        - "SERVER_UNAVAILABLE" if server unavailable after all retries
        - "TIMEOUT_EXCEEDED" if request times out after all retries

    Note:
        For Part 2, this method should include retry logic with exponential backoff.
        Other methods (add, subtract, multiply) should NOT have retry logic.
        Do NOT retry on INVALID_ARGUMENT (division by zero) - return immediately.
    """
    if b == 0.0:
        return "INVALID_ARGUMENT"   # immediate return - no retry, as required

    request = calculator_pb2.BinaryOperation(a=float(a), b=float(b))

    # Retry only these two status codes
    retryable_codes = {
        grpc.StatusCode.UNAVAILABLE,
        grpc.StatusCode.DEADLINE_EXCEEDED
    }

    for attempt in range(MAX_RETRIES + 1):  
        try:
            response = stub.Divide(
                request,
                timeout=DEFAULT_TIMEOUT
            )
            # success, return the float
            return response.value   

        except grpc.RpcError as e:
            code = e.code()

            if code == grpc.StatusCode.INVALID_ARGUMENT:
                # Shouldn't normally reach here (we checked b==0), but handle anyway
                return "INVALID_ARGUMENT"

            if code not in retryable_codes:
                # Any other error 
                raise  

            # If this was the last attempt, return specific error string
            if attempt == MAX_RETRIES:
                if code == grpc.StatusCode.UNAVAILABLE:
                    return "SERVER_UNAVAILABLE"
                if code == grpc.StatusCode.DEADLINE_EXCEEDED:
                    return "TIMEOUT_EXCEEDED"


            backoff = (2 ** attempt) + random.uniform(0, 1)
            timestamp = datetime.now().strftime("%H:%M:%S.%f")[:-3]
            print(f"[{timestamp}] Retry {attempt + 1}/{MAX_RETRIES} for divide({a}, {b}) "
                  f"after {code.name} - waiting {backoff:.2f}s")
            time.sleep(backoff)

def main():
    """Main function to test the calculator."""
    stub = create_client_stub()

    print("=== Testing Calculator Operations ===\n")

    # Test add
    try:
        result = add(stub, 10, 5)
        print(f"add(10, 5) = {result}")
    except grpc.RpcError as e:
        print(f"add(10, 5) FAILED: {e.code().name}")

    # Test subtract
    try:
        result = subtract(stub, 10, 5)
        print(f"subtract(10, 5) = {result}")
    except grpc.RpcError as e:
        print(f"subtract(10, 5) FAILED: {e.code().name}")

    # Test multiply
    try:
        result = multiply(stub, 10, 5)
        print(f"multiply(10, 5) = {result}")
    except grpc.RpcError as e:
        print(f"multiply(10, 5) FAILED: {e.code().name}")

    # Test divide 
    result = divide(stub, 10, 5)
    print(f"divide(10, 5) = {result}")

    # Test divide by zero 
    result = divide(stub, 10, 0)
    print(f"divide(10, 0) = {result}")

if __name__ == '__main__':
    main()