package game;

public class Dealer extends PersonImpl {

	public Dealer(String name, double wallet) {
		super(name, wallet);
		// TODO Auto-generated constructor stub
	}

	/**
	 * returns the dealer's action (hit/stand) depending on their hand
	 *
	 * @return dealer action
	 */
	public String getDealerAction() {
		String dealerAction = "";
		if (mustHit()) {
			dealerAction = "H";
		} else if (mustStand()) {
			dealerAction = "S";
		}
		return dealerAction;
	}
	/**
	 * returns true if the dealer must hit (i.e. hand total <= 16)
	 * @return must hit
	 */
	public boolean mustHit() {
		if (getHand().getTotal() <= 16) {
			return true;
		}
		return false;
	}
	/**
	 * returns true if the dealer must stand (ie. hand total >= 17)
	 * @return must stand
	 */
	public boolean mustStand() {
		if (getHand().getTotal() >= 17 && getHand().getTotal() <= 21) {
			return true;
		}
		return false;
	}
}
