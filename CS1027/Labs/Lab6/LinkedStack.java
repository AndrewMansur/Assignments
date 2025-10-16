public class LinkedStack<T> implements StackADT<T> {

	private LinearNode<T> top;
	
	public LinkedStack() {
		top = null;
	}
	
	public void push(T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		newNode.setNext(top);
		top = newNode;
	}

	public T pop() {
		if (isEmpty()) throw new EmptyCollectionException("Empty stack");
		T result = top.getElement();
		top = top.getNext();
		return result;
	}

	public T peek() {
		if (isEmpty()) throw new EmptyCollectionException("Empty stack");
		return top.getElement();
	}

	public int size() {
		int count = 0;
		LinearNode<T> current = top;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public String toString() {
		String s = "Stack: ";
		LinearNode<T> current = top;
		while (current != null) {
			s += current.getElement() + " ";
			current = current.getNext();
		}
		return s;
	}

}
