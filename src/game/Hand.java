package game;

import java.util.List;

import cards.Card;
/**
 * <h1>Hand</h1>
 * <br>
 * This interface provides methods for playing card hand
 * @author Shaun Dashjian
 * @version 1.0
 * @year 2017
 */
public interface Hand extends Comparable<Hand>{
	/**
	 * adds card to hand and changes hand to hard (i.e. Ace=1) if total > 21
	 * @param card
	 */
	void addCardAndChangeHandtoHardIfNeeded(Card card);
	List<Card> getCards();
	Integer getTotal();
	/**
	 * returns a string to display for the person's hand
	 * @param personName
	 * @return hand to be displayed
	 */
	String display(String personName);
	/**
	 * reveals all cards facing DOWN
	 */
	void revealFaceDownCards();
}
