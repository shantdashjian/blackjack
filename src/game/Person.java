package game;

import cards.Card;
/**
 * <h1>Person</h1>
 * <br>
 * This interface provides methods for a person participating in a card game
 *
 * @author Shaun Dashjian
 * @version 1.0
 * @year 2017
 */
public interface Person {
	void hit(Card card);
	void stand();
	boolean blackjack();
	boolean bust();
	void setHand(Hand hand);
	Hand getHand();
	void setWallet(double amount);
	void setName(String name);
	String getName();
	double getWallet();
}
