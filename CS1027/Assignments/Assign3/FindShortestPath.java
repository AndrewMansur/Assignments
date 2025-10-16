public class FindShortestPath {
    // helper method to find the path length
    private static int pathLength(Hexagon exitChamber) {
        int length = 0;
        Hexagon chamber = exitChamber;
        while (chamber != null) {
            length++;
            chamber = chamber.getPredecessor();
        }
        return length;
    }
    // helper method to check if a chamber has next to a dragon chamber
    private static boolean adjacentDrag(Hexagon chamber) {
        // Iterating through adjacent chambers
        for (int i = 0; i < 6; i++) {
            Hexagon neighbour = chamber.getNeighbour(i);
            if (neighbour != null && neighbour.isDragon()) {
                return true;
            }
        }
        return false;
    }

    // Main method
    public static void main(String[] args) {
    try {
        // Checking if user gave input file
        if (args.length < 1) {
            //throw new Exception("No input file specified");
        }

        // Initializing variables
        String dungeonFileName = "dungeon6.txt";
        Dungeon dungeon = new Dungeon(dungeonFileName);
        Hexagon startChamber = dungeon.getStart();
        DLPriorityQueue<Hexagon> queue = new DLPriorityQueue<>();
        boolean isExit = false;

        // Adding the start chamber to priority queue and marking it enqueued
        queue.add(startChamber, 0);
        startChamber.markEnqueued();
        

        // While the priority queue is not empty and the exit has not been found
        while (!queue.isEmpty() && isExit == false) {
            Hexagon chamber = queue.removeMin();
            chamber.markDequeued();    
            
            // Checking if the current chamber has a dragon in it or if any of the neighbouring chambers has a dragon
            if (chamber.isDragon() || adjacentDrag(chamber)) {
            }

            // Checking if the current chamber is the exit, then the algorithm exits the loop
            if (chamber.isExit()) {
                isExit = true;
            }
            else {
                // iterating through neighboring chambers
                for (int i = 0; i < 6; i++) {
                    Hexagon neighbour = chamber.getNeighbour(i);

                    // Check if the neighbor is valid, not a wall and not dequeued
                    if (neighbour != null && !neighbour.isWall() && !neighbour.isDragon() && !adjacentDrag(neighbour)) {
                        int D = chamber.getDistanceToStart() + 1;

                        // update the neighbor's distance and predecessor if a shorter path is found
                        if (D < neighbour.getDistanceToStart()) {
                            neighbour.setPredecessor(chamber);
                            neighbour.setDistanceToStart(D);
                            
                            // Update the neighbors priority if its already enqueued
                            if (neighbour.isMarkedEnqueued()) {
                                queue.updatePriority(neighbour, D + neighbour.getDistanceToExit(dungeon));

                            } 
                            // Adding the neighbor to the queue with priority equal to D (distance)
                            else {
                                queue.add(neighbour, D + neighbour.getDistanceToExit(dungeon));
                                neighbour.markEnqueued();
                            }
                        }
                    }
                }
            }
        }

        // Printing the final result of path length
        if (isExit) {
            int pathLength = pathLength(dungeon.getExit());
            System.out.println("Path of length " + pathLength + " found");
        } 
        // If the path isnt possible
        else {
            System.out.println("No path found");
        }
        
    } 

    // Catching errors
    catch (InvalidDungeonCharacterException e) {
        System.out.println("Invalid dungeon character: " + e.getMessage());
    }  

    catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
}
