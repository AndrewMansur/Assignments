public class Matrix{
    // Declaring instance variables
    private int numRows;
    private int numCols;
    private double[][] data;

    // Creating method 1
    public Matrix (int r, int c){
        numRows = r;
        numCols = c;
        data = new double[r][c];
    }

    // Creating method 2
    public Matrix (int r, int c, double[] linArr){
        int index = 0;
        numRows = r;
        numCols = c;
        data = new double[r][c];

        // mapping data to linArr
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                data[i][j] = linArr[index++];     
            }
        }  
    }

    // Number of rows getter
    public int getNumRows(){
        return this.numRows;
    }

    // Number of columns getter
    public int getNumCols(){
        return this.numCols;
    }
    
    // Data getter
    public double[][] getData(){
        return this.data;
    }

    // Get a element getter
    public double getElement(int r, int c){
        return this.data[r][c];
    }

    // Element in data setter
    public void setElement(int r, int c, double value){
        this.data[r][c] = value;
    }

    // Transpose method
    public  void transpose(){
        // Creating a new list
        double[][] transposed = new double[this.numCols][this.numRows];

        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numCols; j++) {
                transposed[j][i] = this.data[i][j];
            }
        }

        // Variable swapping
        this.numRows = this.numCols;
        this.numCols = this.data.length;
        this.data = transposed;
    }

    // Multiply by scaler method
    public Matrix multiply (double scalar){
        // Creating new matrix object
        Matrix newMatrix = new Matrix(numRows, numCols);

        // Iterating through the data and multiplying it by the scaler
        for (int i = 0; i < numRows; i++) { 
            for (int j = 0; j < numCols; j++) {
                newMatrix.data[i][j] = data[i][j] * scalar;
            }
        }
        return newMatrix;
    }

    // Multiply by matrix method
    public Matrix multiply (Matrix other){
        // Checking if the matrix is square
        if (numCols != other.getNumRows()){
            return null;
        }
        else{
            // Creating new matrix method
            Matrix newMatrix = new Matrix(numRows, other.getNumCols());

            // Iterating and multiplying the matrix by the other matrix
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    for (int k = 0; k < numCols; k++) {
                        newMatrix.data[i][j] += data[i][k] * other.data[k][j];
                    }
                }
            }
            return newMatrix;
        }
    }

    // toString method
    public String toString() {
        // Checking if the matrix is empty
        if (data.length == 0) {
            return "Empty matrix";
        }
        StringBuilder sb = new StringBuilder();
        //Iterating and formating the string
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                sb.append(String.format("%8.3f", data[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

