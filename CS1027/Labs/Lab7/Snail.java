
public class Snail {
	
	public static char icon = '@';
	private int position;
	private QueueADT<Integer> movePattern;
	
	public Snail (int[] pattern) {
		position = 0;
		movePattern = new LinkedQueue<Integer>();
		for (int i = 0; i < pattern.length; i++) {
			movePattern.enqueue(pattern[i]);
		}
	}
	public void move () {
		int step =  movePattern.dequeue();
		movePattern.enqueue(step);
		position += step;
		if (position > SnailRace.raceLength){
			position = SnailRace.raceLength;
		}

	}
	
	public int getPosition () {
		return position;
	}
	
	public void display () {
		int dashesBefore = getPosition();
		int dashesAfter = SnailRace.raceLength - position;

		for (int i = 0; i < dashesBefore; i++) {
			System.out.print("-");
		}

		System.out.print("@");

		for (int i = 0; i < dashesAfter; i++) {
			System.out.print("-");
		}

		System.out.print("\n");
	}

}
