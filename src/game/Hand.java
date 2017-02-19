package game;


import java.util.List;

import cards.Card;

public interface Hand {
	void addCard(Card card);
	List<Card> getCardsInHand();
	int getTotalOfHand();
	String display(String personName);
}
