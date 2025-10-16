
public class ClassB {

	private static int counter = 0; // can make static

	public ClassB() {
		counter = 1;
	}

	public static void incCounter() { // can make static
		++counter;
	}

	public int getCounter() {
		return counter;
	}

	public static void main(String[] args) {
		int i;

		i = counter; 
		incCounter();
		System.out.println("i = " + i + " counter = " + counter);
	}

}
