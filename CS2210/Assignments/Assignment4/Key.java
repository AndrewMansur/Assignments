public class Key {
    
    // Instance Variables
    private String label;  
    private int type;  


    // Constructor 
    public Key(String theLabel, int theType) {
        this.label = theLabel.toLowerCase();  
        this.type = theType;
    }

    // Returns the String stored in instance variable label
    public String getLabel() {
        return this.label;
    }

    // Returns the value of instance variable type
    public int getType() {
        return this.type;
    }

    // Compares the current key object and object K
    public int compareTo(Key k) {

        if (this.label.equals(k.getLabel())) { 

            if (this.getType() == k.getType()) {
                return 0;  
            }
            if (this.getType() < k.getType()) {
                return -1; 
            }
            return 1;  
        }

        if (this.label.compareTo(k.getLabel()) < 0) {  
            return -1;  
        }
        return 1; 
    }


}
