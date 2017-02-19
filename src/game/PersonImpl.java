package game;

import cards.Card;

public abstract class PersonImpl implements Person {
	private String name;
	private double wallet;
	private Hand hand;

	/**
	 *
	 */
	public PersonImpl() {
		super();
		this.wallet = 0;
		this.hand = new HandImpl();
	}

	/**
	 * @param name
	 * @param wallet
	 * @param bet
	 * @param hand
	 */
	public PersonImpl(String name, double wallet) {
		this();
		this.name = name;
		this.wallet = wallet;

	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the wallet
	 */
	@Override
	public double getWallet() {
		return wallet;
	}

	/**
	 * @param wallet
	 *            the wallet to set
	 */
	@Override
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}




	/**
	 * @return the hand
	 */
	@Override
	public Hand getHand() {
		return hand;
	}

	/**
	 * @param hand
	 *            the hand to set
	 */
	@Override
	public void setHand(Hand hand) {
		this.hand = hand;
	}

	@Override
	public void hit(Card card) {
		hand.addCard(card);
	}

	@Override
	public void stand() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean blackjack() {
		if (hand.getTotalOfHand() == 21) {
			return true;
		}
		return false;
	}

	@Override
	public boolean bust() {
if (hand.getTotalOfHand() > 21) {
	return true;
}
return false;
	}

}
