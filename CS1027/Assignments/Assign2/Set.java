public class Set<T> {
    // Instance variable
    private LinearNode<T> setStart; 

    // Constructor
    public Set() {
        setStart = null;
    }

    // Add method
    public void add(T element) {
        LinearNode<T> newNode = new LinearNode<T>(element);
        // Checking if node is null
        if (setStart == null) { 
            setStart = newNode;
        } 
        else { 
            LinearNode<T> current = setStart;
            // Running until out of nodes
            while (current.getNext() != null) {

                // changing the current node to the next node
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // Get length metho
    public int getLength(){
        int counter = 0;
        // Creating temp node
        LinearNode<T> currentNode = setStart;
        // Running until out of nodes
        while (currentNode != null){
            // Adds plus one until out of nodes
            counter += 1;
            currentNode = currentNode.getNext();
        }

        return counter;
    }

    // Get element method
    public T getElement(int i){
        int counter = 0;
        // Setting temp node
        LinearNode<T> currentNode = setStart;

        if(i >= getLength() || i < 0){
            //throwing exception if out of index
            throw new IndexOutOfBoundsException("Out of range");
        }

        while (counter != i){
            // running until found correct index 
            counter += 1;
            currentNode = currentNode.getNext();
        }

        return currentNode.getElement();
    }

    // Contains method
    public boolean contains(T element){
        // Setting temp node variable
        LinearNode<T> currentNode = setStart;

        // Running for length iterations
        for (int i = 0; i < getLength(); i++) {
            
            // Checking if the current node is equal to the paramater
            if (currentNode.getElement().equals(element)) {
                return true;
            }

            // Setting current node to the next node in list
            currentNode = currentNode.getNext();
        }
        return false;
    }

    // To string method
    public String toString(){
        // Setting temp node variable
        LinearNode<T> currentNode = setStart;
        String string = "";

        // Running for length iterations
        for (int i = 0; i < getLength(); i++) {
            // Concatenating the element
            string += currentNode.getElement() + " ";
            // Setting current node to the next node in list
            currentNode = currentNode.getNext();
        }

        return string;
    }
}