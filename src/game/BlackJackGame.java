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
	 * @param dealer
	 *            the dealer to set
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
	 * @param player
	 *            the player to set
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
	 * @param deck
	 *            the deck to set
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
	 * @param minBet
	 *            the minBet to set
	 */
	public void setMinBet(double minBet) {
		this.minBet = minBet;
	}

	public static void main(String[] args) {
		BlackJackGame blackJackGame = new BlackJackGame(args);
		blackJackGame.start();
	}

	public BlackJackGame() {
		dealer = new Dealer("Dealer", 1000000);
		player = new Player("Player", 1000);
		deck = new DeckImpl();
		minBet = 50;
	}

	public BlackJackGame(String[] args) {
		this();
		if (args.length == 3) {
			minBet = Double.parseDouble(args[0]);
			player.setName(args[1]);
			player.setWallet(Double.parseDouble(args[2]));
		}

	}

	public void start() {
		welcomePlayer();
		playerPlacesWager();
		dealPlayerAndDealer();
		endGameIfEitherGotBlackjack();
		playerTurn();
		dealerTurn();
	}

	public void welcomePlayer() {
		System.out.println("Welcome to SD Blackjack:");
		System.out.println("************************");
		// do {
		// player.setWallet(InputHelper.getDouble(
		// "Minimum bet on this table is " + minBet + ". Enter the total value
		// of your chips (0 to exit): "));
		// if (player.getWallet() <= 0) {
		// System.out.println("Please visit us again, " + player.getName() +
		// "!");
		// System.exit(0);
		// }
		// } while (player.getWallet() < minBet);
	}

	public void playerPlacesWager() {
		do {
			((Player) player).placeWager(InputHelper
					.getDouble("Minimum bet is $" + minBet + ". How much would you like to bet (0 to exit)? "));
			if (((Player) player).getWager() <= 0) {
				System.out.println("Please visit us again!");
				System.exit(0);
			}
		} while (((Player) player).getWager() < minBet);
	}

	public void dealPlayerAndDealer() {
		deal(player, Facing.UP);
		displayTable();

		deal(dealer, Facing.DOWN);
		displayTable();

		deal(player, Facing.UP);
		displayTable();

		deal(dealer, Facing.UP);
		displayTable();

	}

	public void displayTable() {
		try {
			System.out.println(dealer.getHand().display(dealer.getName()));
			Thread.sleep(100);
			System.out.println(player.getHand().display(player.getName()));
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void deal(Person person, Facing facing) {
		person.hit(deck.dealCard(facing));

	}

	public void endGameIfEitherGotBlackjack() {
		if (oneOrBothGotBlackJack()) {
			System.exit(0);
		}
	}

	public boolean oneOrBothGotBlackJack(){
		if (player.blackjack() && !dealer.blackjack()) {
			System.out.println("BLACKJACK!!!! You win!");
			player.setWallet(player.getWallet() + ((Player) player).getWager() * 1.5);
			return true;
		}
		if (dealer.blackjack() && !player.blackjack()) {
			System.out.println("The house wins!");
			player.setWallet(player.getWallet() - ((Player) player).getWager());
			dealer.setWallet(dealer.getWallet() + ((Player) player).getWager());
			return true;
		}
		if (dealer.blackjack() && player.blackjack()) {
			System.out.println("It's a TIE!");
			player.setWallet(player.getWallet() + ((Player) player).getWager());
			return true;
		}
		return false;
	}

	public void playerTurn() {
		String playerDecision;
		do {
			do {
				playerDecision = (InputHelper.getString("Hit or Stand? (Enter H or S) ")).toUpperCase();
			} while (!playerDecision.equals("H") && !playerDecision.equals("S"));

			if (playerDecision.equals("H")) {
				deal(player, Facing.UP);
				displayTable();
				if (player.bust()) {
					System.out.println("BUST!! Good luck next time!");
					System.exit(0);
				}
			}

		} while (!playerDecision.equals("S"));
	}

	public void dealerTurn() {
		System.out.println("Dealer's turn");
		dealer.getHand().revealFaceDownCards();
		displayTable();
	}

}
