package game;

public class Player extends PersonImpl {

	private double wager;


	public Player(){
		super();
	}
	public Player(String name, double wallet) {
		super(name, wallet);
		// TODO Auto-generated constructor stub
	}
	public boolean placeWager(double wager) {
		if (wager <= getWallet()) {
			this.wager = wager;
			setWallet(getWallet() - wager);
			return true;
		}
		return false;

	}
	public double getWager() {
		return wager;
	}

}
