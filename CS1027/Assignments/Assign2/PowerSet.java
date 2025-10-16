public class PowerSet<T> {
    // Instance variable
    private Set<T>[] set;

    // Constructor
    public PowerSet(T[] elements) {
        // Finding length
        int length = elements.length;
        // Calculating number sets
        int numSets = (int) Math.pow(2, length);
        // Creating set
        set = (Set<T>[]) new Set[numSets];
        
        
        for (int i = 0; i < numSets; i++) {
            // Creating binary of string
            String binary = Integer.toBinaryString(i);
            set[i] = new Set<T>();
            
            for (int j = 0; j < length; j++) {
                // Checking if equal to one
                if (("0".repeat(length - binary.length()) + binary).charAt(j) == '1') {
                    // adding the elements to set
                    set[i].add(elements[j]);
                }
            }
        }
    }

    // returning length of set
    public int getLength() {
        return set.length;
    }
    
    // retrning the set
    public Set<T> getSet(int num) {
        return set[num];
    }
}
