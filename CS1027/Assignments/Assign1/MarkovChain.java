public class MarkovChain {
    // Instance variables
    private Vector stateVector;
    private Matrix transitionMatrix;

    // Constructor
    public MarkovChain (Vector sVector, Matrix tMatrix){
        this.stateVector = sVector;
        this.transitionMatrix = tMatrix;
    }

    public boolean isValid (){
        double sumVal = 0.0;
        // Checking conditions
        if (this.transitionMatrix.getNumCols() != this.transitionMatrix.getNumRows() || this.transitionMatrix.getNumCols() != this.stateVector.getNumCols()){  
            return false;
        }
        
        // Iterating and adding the elements to sumVal
        for (int i=0; i < this.stateVector.getNumCols(); i++){
            sumVal += this.stateVector.getElement(i);
        }

        // Checking if sumval is equal to 1
        if (sumVal < 0.99 || sumVal > 1.01){
            return false;
        }

        // Ressetting sumval
        sumVal = 0.0;
        
        // Iteratinf andd adding the elements of the transition matrix to sumval
        for (int i = 0; i < this.transitionMatrix.getNumRows(); i++) {
            
            for (int j = 0; j < this.transitionMatrix.getNumCols(); j++) {
                sumVal += this.transitionMatrix.getElement(i, j);
            }

            // Checking if sumval is equal to 1
            if (sumVal < 0.99 || sumVal > 1.01){
                return false;
            } 
            sumVal = 0.0;
        }

        return true;
    }

    
    public Matrix computeProbabilityMatrix (int numSteps){
        // Checking if the matrix is alid
        if (isValid() == false){
            return null;
        }
        
        // Multiplying transition matrix
        Matrix result = this.transitionMatrix;
        for (int i = 1; i < numSteps; i++) {
          result = result.multiply(this.transitionMatrix);
        }
    
        return stateVector.multiply(result);
    }  
}

