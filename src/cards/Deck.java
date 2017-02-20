package cards;

import java.util.List;
/**
 * <h1>Deck</h1>
 * <br>
 * This interface provides methods for a deck of cards
 *
 * @author Shaun Dashjian
 * @version 1.0
 * @year 2017
 */
public interface Deck {
	void shuffle();
	Card dealCard(Facing facing);
	List<Card> getCardsLeft();
}
