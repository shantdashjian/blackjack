package game;

import cards.Card;

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
