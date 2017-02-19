package game;

import cards.Deck;
import cards.DeckImpl;
import cards.Facing;

public class BlackJackGame {
	private Person dealer;
	private Person player;
	private Deck deck;
	private double minBet;

	/**
	 * @return the dealer
	 */
	public Person getDealer() {
		return dealer;
	}

	/**
	 * @param dealer the dealer to set
	 */
	public void setDealer(Person dealer) {
		this.dealer = dealer;
	}

	/**
	 * @return the player
	 */
	public Person getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Person player) {
		this.player = player;
	}

	/**
	 * @return the deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @param deck the deck to set
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	/**
	 * @return the minBet
	 */
	public double getMinBet() {
		return minBet;
	}

	/**
	 * @param minBet the minBet to set
	 */
	public void setMinBet(double minBet) {
		this.minBet = minBet;
	}

	public static void main(String[] args) {
		BlackJackGame blackJackGame = new BlackJackGame(args);
		blackJackGame.start();
	}

	public BlackJackGame(){
		dealer = new Dealer("Jim", 1000000);
		player = new Player();
		deck = new DeckImpl();
		minBet = 200;
	}
	public BlackJackGame(String[] args){
		this();
		if (args.length == 3) {
			String dealerName = args[0];
			double dealerWallet =Double.parseDouble(args[1]);
			dealer.setName(dealerName);
			dealer.setWallet(dealerWallet);
			minBet = Double.parseDouble(args[2]);
		}

	}
	public void start() {
		welcomePlayerAndCollectInformation();
		playerPlacesWager();
		dealPlayerAndDealer();
		playerTurn();
		dealerTurn();

	}

	public void dealerTurn() {
		// TODO Auto-generated method stub

	}

	public void playerTurn() {
		// TODO Auto-generated method stub

	}

	public void dealPlayerAndDealer() {
		deal(player, Facing.UP);
		dealer.getHand().display(dealer.getName());
		player.getHand().display(player.getName());
		deal(dealer, Facing.DOWN);
		dealer.getHand().display(dealer.getName());
		player.getHand().display(player.getName());
		deal(player, Facing.UP);
		dealer.getHand().display(dealer.getName());
		player.getHand().display(player.getName());
		deal(dealer, Facing.UP);
		dealer.getHand().display(dealer.getName());
		player.getHand().display(player.getName());

	}

	public void playerPlacesWager() {
		do {
			((Player)player).placeWager(InputHelper.getDouble(
					"Minimum bet is " + minBet +
					". How much would you like to bet (0 to exit)?"));
			if (((Player)player).getWager() <= 0) {
				System.out.println("Please visit us again, " + player.getName() + "!");
				System.exit(0);
			}
		} while (((Player)player).getWager() < minBet);
	}

	public void welcomePlayerAndCollectInformation() {
		System.out.println("Welcome to SD Blackjack:");
		System.out.println("************************");
		player.setName(InputHelper.getString("What is your name? "));
		System.out.println("Welcome, " + player.getName());
		do {
			player.setWallet(InputHelper.getDouble(
					"Minimum bet on this table is " + minBet +
					". Enter the total value of your chips (0 to exit): "));
			if (player.getWallet() <= 0) {
				System.out.println("Please visit us again, " + player.getName() + "!");
				System.exit(0);
			}
		} while (player.getWallet() < minBet);
	}
	public void deal(Person person, Facing facing){
		player.hit(deck.dealCard(facing));

	}

}
