package cards;

public interface Card {
	int getValue();
	boolean faceUp();
	boolean faceDown();
	void setFace(Facing facing);
	Rank getRank();
	Suit getSuit();
}
