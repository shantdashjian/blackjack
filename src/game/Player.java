package game;

public class Player extends PersonImpl {
	/**
	 * fields
	 */
	private double wager;

	public Player(){
		super();
	}
	public Player(String name, double wallet) {
		super(name, wallet);
	}
	/**
	 * returns true if the players placed her wager successfully
	 * @param wager
	 * @return placed wager
	 */
	public boolean placeWager(double wager) {
		if (wager <= getWallet()) {
			this.wager = wager;
			setWallet(getWallet() - wager);
			return true;
		}
		return false;

	}
	/**
	 * returns wager placed
	 * @return wager placed
	 */
	public double getWager() {
		return wager;
	}

}
