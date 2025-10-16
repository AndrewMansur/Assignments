
public class BuildDoubleLinkedList {
	
	private DoubleLinkedNode<Character> front, rear;
	private static char[] letters = new char[] {'K', 'T', 'E', 'N', 'P', 'A', 'L'};

	public BuildDoubleLinkedList () {
		build();
	}
	
	

	public void remove (Character elem) {
		
		DoubleLinkedNode<Character> curr = front;

		while (curr != null) {
			if (curr.getElement().equals(elem)) {
				// Found the node to remove
	
				// Removing the front node
				if (curr == front) {
					front = curr.getNext();
					if (front != null) {
						front.setPrevious(null);
					} else {
						rear = null; 
					}
				}

				else if (curr == rear) {
					rear = curr.getPrevious();
					rear.setNext(null);
				}

				else {
					curr.getPrevious().setNext(curr.getNext());
					curr.getNext().setPrevious(curr.getPrevious());
				}
	
				return;
			}
	
			curr = curr.getNext();
		}
		
	}
	
	
	private void build () {
		DoubleLinkedNode<Character> pnode, node;
		
		node = new DoubleLinkedNode<Character>(letters[0]);
		pnode = front = node;
		for (int i = 1; i < 7; i++) {
			node = new DoubleLinkedNode<Character>(letters[i]);
			pnode.setNext(node);
			node.setPrevious(pnode);
			pnode = node;
		}
		rear = node;
	}
	
	public DoubleLinkedNode<Character> getFront () {
		return front;
	}
	
	public DoubleLinkedNode<Character> getRear () {
		return rear;
	}
	
	public void printF (DoubleLinkedNode<Character> node) {
		System.out.print("Forward:  ");
		DoubleLinkedNode<Character> curr = front;
		while (curr != null) {
			System.out.print(curr.getElement() + " ");
			curr = curr.getNext();
		}
		System.out.print("\n");
	}
	
	public void printR (DoubleLinkedNode<Character> node) {
		System.out.print("Reverse:  ");
		DoubleLinkedNode<Character> curr = rear;
		while (curr != null) {
			System.out.print(curr.getElement() + " ");
			curr = curr.getPrevious();
		}
		System.out.print("\n");
	}
	
	
	
	public static void main (String[] args) {
		BuildDoubleLinkedList dll = new BuildDoubleLinkedList();

		System.out.println("Original List:");
		dll.printF(dll.getFront());
		dll.printR(dll.getRear());
		System.out.println("***");
		
		System.out.println("Removing an internal node:");
		dll.remove('N');
		dll.printF(dll.getFront());
		dll.printR(dll.getRear());
		System.out.println("***");
		
		System.out.println("Removing the front node:");
		dll.remove('K');
		dll.printF(dll.getFront());
		dll.printR(dll.getRear());
		System.out.println("***");
		
		System.out.println("Removing the rear node:");
		dll.remove('L');
		dll.printF(dll.getFront());
		dll.printR(dll.getRear());
		System.out.println("***");
		
		System.out.println("Trying to remove a non-existent node:");
		dll.remove('X');
		dll.printF(dll.getFront());
		dll.printR(dll.getRear());
		System.out.println("***");
	}

}
