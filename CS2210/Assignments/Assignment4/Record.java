// represents the records to be stored in the nodes of the binary search tree.
public class Record {
    
    // Instance variables
    private Key theKey;  
    private String data;  

    // Constructor
    public Record(Key k, String theData) {

        this.theKey = k;
        this.data = theData;
    }

    // Returns the key
    public Key getKey() {
        return this.theKey;
    }

    // Returns the data
    public String getDataItem() {
        return this.data;
    }

}
