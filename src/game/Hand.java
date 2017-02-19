package game;


import java.util.List;

import cards.Card;

public interface Hand extends Comparable<Hand>{
	void addCardAndChangeHandtoHardIfNeeded(Card card);
	List<Card> getCardsInHand();
	int getTotalOfHand();
	String display(String personName);
	void revealFaceDownCards();
}
