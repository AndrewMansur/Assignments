public class Vector extends Matrix{
    // Constructor
    public Vector (int c){
        super(1, c);
    }
    // Second constructor
    public Vector(int c, double[] linArr) {
        super(1, c, linArr);
    }
    // get element of vector method
    public double getElement(int c) {
        return super.getElement(0, c);
    }
}