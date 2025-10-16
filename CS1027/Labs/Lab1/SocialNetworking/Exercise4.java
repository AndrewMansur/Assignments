package SocialNetworking;

import java.util.Random; // Java library with code to generate random numbers

public class Exercise4 {
	/* Random number generator */
	private static Random generator = new Random(2);

	/* This method returns a random value between 0 and 9 */
	public static int foo() {
		return generator.nextInt(10);
	}

	/* This method prints a sequence of random bits */
	public static void main(String[] args) {
		int bit;
		int limit = foo(); // Number of random bits

		// Generate the specified number of random bits and print them
		for (int i = 0; i < limit; ++i) {
			if (foo() < 5)
				bit = 0;
			else
				bit = 1;
			System.out.print(bit);
		}

		// Print and end-of-line
		System.out.println();
	}
}