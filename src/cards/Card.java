package cards;
/**
 * <h1>Card</h1>
 * <br>
 * This interface defines methods for a playing card
 * <br>
 * @author Shaun Dashjian
 * @version 1.0
 *
 */
public interface Card {
	int getValue();
	boolean faceUp();
	boolean faceDown();
	void setFace(Facing facing);
	Rank getRank();
	Suit getSuit();
	boolean isAnAce();
	void setValue(int i);
	void reveal();
}
