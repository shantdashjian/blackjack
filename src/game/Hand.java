package game;


import java.util.List;

import cards.Card;

public interface Hand extends Comparable<Hand>{
	void addCardAndChangeHandtoHardIfNeeded(Card card);
	List<Card> getCards();
	Integer getTotal();
	String display(String personName);
	void revealFaceDownCards();
}
