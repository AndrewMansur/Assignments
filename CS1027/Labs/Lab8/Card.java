
public class Card implements Comparable<Card>{
	
	private String suit; // S (spade), H (heart), D (diamond), or C (club)
	private String rank; // A (ace), 2, 3, ..., 10, J (jack), Q (queen), or K (king)

public Card (String suit, String rank) {
	this.suit = suit;
	this.rank = rank;
}

public String getSuit () {
	return suit;
}

public String getRank () {
	return rank;
}

public void setSuit (String suit) {
	this.suit = suit;
}

public void setRank (String rank) {
	this.rank = rank;
}

public String toString () {
	return rank + " of " + suit;
}

public boolean equals(Card other) {
	return this.rank.equals(other.rank) && this.suit.equals(other.suit);
}

private int getSuitValue() {
	switch(suit) {
		case "D":
			return 1;
		case "C":
			return 2;
		case "H":
			return 3;
		case "S":
			return 4;
		default:
			return -1; // Should not occur
	}
}

private int getRankValue() {
	switch(rank) {
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		case "10":
			return 10;
		case "J":
			return 11;
		case "Q":
			return 11;
		case "K":
			return 11;
		case "A":
			return 12;
		default:
			return -1; // Should not occur
	}
}

public int compareTo(Card other) {
	if (this.equals(other)) {
		return 0;
	} else if (this.getRankValue() != other.getRankValue()) {
		return Integer.compare(this.getRankValue(), other.getRankValue());
	} else {
		return Integer.compare(this.getSuitValue(), other.getSuitValue());
	}
}
}