public class DLPriorityQueue<T> implements PriorityQueueADT<T>{
    // Instance variables
    private DLinkedNode<T> front;
    private DLinkedNode<T> rear;
    private int count;

    // Constructor
    public DLPriorityQueue(){
        front = null;
        rear = null;
        count = 0;
    }

    // Method for adding nodes
    public void add(T dataItem, double priority) {
        // Creating the new node to add
        DLinkedNode<T> nodeAdded = new DLinkedNode<>(dataItem, priority);

        // Checking if the list is empty
        if (count == 0) {
            front = nodeAdded;
            rear = nodeAdded;

        // Checking if the front node is null and seeing if the order of priorities is correct    
        } else if (front == null || priority < front.getPriority()) {
            nodeAdded.setNext(front);
            if (front != null) {
                front.setPrev(nodeAdded);
            }
            front = nodeAdded;
        }
        
        // Checking if the last node has smaller priority than the added node
        else if (priority > rear.getPriority()) {
            nodeAdded.setPrev(rear);
            rear.setNext(nodeAdded);
            rear = nodeAdded;
        } 
        
        // If the node is in the middle of the list
        else {
            // Setting a temperary node to iterate through
            DLinkedNode<T> currentNode = front.getNext();

            // Iterating through the nodes if in correct priority order
            while (currentNode != null && priority > currentNode.getPriority()) {
                currentNode = currentNode.getNext();
            }
            nodeAdded.setPrev(currentNode.getPrev());
            nodeAdded.setNext(currentNode);
            currentNode.getPrev().setNext(nodeAdded);
            currentNode.setPrev(nodeAdded);
        }
        // Incrementing the number of nodes in list
        count += 1;
    }

    // Removing then readding the node to adjust for priority
    public void updatePriority (T dataItem, double newPriority) throws InvalidElementException{
        DLinkedNode<T> currentNode = front;
        boolean isFound = false;
        
            // iterating until the node is located and removing the node
            while (currentNode != null && isFound == false) {
                // Checking if we located the node
                if (currentNode.getDataItem().equals(dataItem)) {
                    // If it is at the front
                    if (currentNode.getPrev() == null){
                        front = currentNode.getNext();
                    }

                    // if it is at the back
                    if (currentNode.getNext() == null){
                        rear = currentNode.getPrev();
                    }

                    // Changing the next pointer of the previous node
                    if (currentNode.getPrev() != null){
                        currentNode.getPrev().setNext(currentNode.getNext());
                    }

                    // Changing the previous pointer of the next node
                    if (currentNode.getNext() != null){
                        currentNode.getNext().setPrev(currentNode.getPrev());
                    }

                    isFound = true;
                }

                // Getting the next node
                currentNode = currentNode.getNext();
        }
        // If the node isnt in the list
        if (isFound == false){
            throw new InvalidElementException("DataItem not found");
        }
        // Reading the node to the list so it gets sorted
        add(dataItem, newPriority);
       
    }

    // Removing the node with the least priority (front node)
    public T removeMin() throws EmptyPriorityQueueException{
        DLinkedNode<T> currentNode = front;

        // Checking if the list is empty
        if (currentNode == null){
            throw new EmptyPriorityQueueException("It is empty");
        }

        else{
            // Changing the front to the next node after front
            front = currentNode.getNext();
            count-=1;
            return currentNode.getDataItem();
        }
    }

    // Check if the list is empty
    public boolean isEmpty() {
        if (count == 0){
            return true;
        }
        return false;
    }

    // Returning the length of the list
    public int size() {
        return count;
    }

    // Changing the list to a string representation
    public String toString() {
        String string = "";
        DLinkedNode<T> currentNode = front;
        while (currentNode != null) {
            string = string + currentNode.getDataItem();
            currentNode = currentNode.getNext();
        }
        return string;
    }

    // Returns the rear node
    public DLinkedNode<T> getRear(){
        return rear;
    }
    
}
