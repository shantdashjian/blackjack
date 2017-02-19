package cards;

import java.util.List;

public interface Deck {
	void shuffle();
	Card dealCard(Facing facing);
	List<Card> getCardsLeft();
}
