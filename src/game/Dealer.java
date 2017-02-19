package game;

public class Dealer extends PersonImpl {

	public Dealer(String name, double wallet) {
		super(name, wallet);
		// TODO Auto-generated constructor stub
	}

	public String getDealerAction() {
		String dealerAction = "";
		if (mustHit()){
			dealerAction = "H";
		} else if (mustStand()){
			dealerAction = "S";
		}
		return dealerAction;
	}
	public boolean mustHit() {
		if (getHand().getTotal() <= 16){
			return true;
		}
		return false;
	}

	public boolean mustStand() {
		if (getHand().getTotal() >= 17 && getHand().getTotal() <= 21){
			return true;
		}
		return false;
	}
}
