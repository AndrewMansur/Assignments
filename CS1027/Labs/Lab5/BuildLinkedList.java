public class BuildLinkedList {

    private static void printList(LinearNode<Integer> front) {
        LinearNode<Integer> current = front;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

    public static void main(String[] args) {

        int n = 20; 



        LinearNode<Integer> front = null; 
        LinearNode<Integer> intNode;

        for (int i = n; i >= 1; i--) {
 
            intNode = new LinearNode<Integer>(new Integer(i));

            intNode.setNext(front);
            front = intNode;
        }

        printList(front);
    }

}