public class yeah {
    public static void main(String[] args) {
        DLPriorityQueue<String> queue = new DLPriorityQueue<>();

        queue.add("apple", 1.0);

        System.out.println(queue.toString());

        
        //queue.updatePriority("apple",0.2);
        queue.removeMin();
        System.out.println(queue.toString());
    }
}
