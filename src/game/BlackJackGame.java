package game;

import cards.Deck;
import cards.DeckImpl;
import cards.Facing;
/**
 * <h1>BlackjackGame</h1>
 * <br>
 * This is the driver class of the game. It includes the main() method that
 * 	instantiates an object of type BlackjackGame and then calls its play() method.
 * <br>
 * @author Shaun Dashjian
 * @version 1.0
 *
 */
public class BlackjackGame {
	/**
	 * constants
	 */
	public static final int LONG_DELAY = 2000;
	public static final int SHORT_DELAY = 1;
	/**
	 * fields
	 */
	private Person dealer;
	private Person player;
	private Deck deck;
	private double minBet;
	/**
	 * main() is called first to instantiate an object of type BlackjackGame and
	 * then call its play() method
	 * @param args
	 */
	public static void main(String[] args) {
		BlackjackGame blackJackGame = new BlackjackGame(args);
		blackJackGame.play();
	}
	/**
	 * This starts the game. It calls other methods to:
	 * <ul>
	 * 	<li>welcome the player
	 * 	<li>start with empty hands
	 * 	<li>have player place her wager
	 * 	<li>deal the player then the dealer
	 * 	<li>have the player then the dealer take their turn playing
	 * 	<li>repeat while player wants to play again
	 * 	<li>end the game
	 * </ul>
	 */
	public void play() {
		welcomePlayer();
		do {
			startWithEmptyHands();
			playerPlacesWager();
			dealPlayerAndDealer();
			playerAndDealerEachTakeTheirTurn();
		} while (playerWantsToPlayAgain());
		endGame();
	}

	public void welcomePlayer() {
		System.out.println("***************************");
		System.out.println("* Welcome to SD Blackjack *");
		System.out.println("***************************");
	}
	public void startWithEmptyHands() {
		player.setHand(new HandImpl());
		dealer.setHand(new HandImpl());
	}
	public void playerPlacesWager() {
		do {
			if (!((Player) player).placeWager(Helper.getDouble(
					"Minimum bet is $" + Helper.toMoney(minBet) + ".\nHow much would you like to bet (0 to exit)? "))) {
				System.out.println("You have a total of $" + Helper.toMoney(player.getWallet())
				+ " in your wallet. Place a wager within your funds. ");
				continue;
			}
			;

			if (((Player) player).getWager() <= 0) {
				System.out.println("Please visit us again!");
				System.exit(0);
			}
		} while (((Player) player).getWager() < minBet);
	}
	public void playerAndDealerEachTakeTheirTurn() {
		while (true) {
			if (oneOrBothGotBlackJack()) {
				break;
			}
			if (playerTakesTurnThenBusts()) {
				break;
			}
			if (dealerTakesTurnThenBusts()) {
				break;
			}
			compareHandsAndDeclareResult();
			break;
		}
		displayWalletAtTheEnd();
	}
	public boolean playerWantsToPlayAgain() {
		String playAgain = "N";
		if (player.getWallet() >= minBet) {
			playAgain = Helper.getString("Play again (Y/N)? ").toUpperCase();

		} else {
			System.out.println("You do not have sufficient funds to continue playing." + " The house always wins!!");
		}
		return playAgain.equals("Y");
	}
	public void endGame() {
		System.out.println("Cheers!");
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
			Thread.sleep(SHORT_DELAY);
			System.out.println(player.getHand().display(player.getName()));
			displayWalletAndWager();
			System.out.println();
			Thread.sleep(LONG_DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public void displayWalletAndWager() {
		System.out.println("Wallet= $" + Helper.toMoney(player.getWallet()) + "   Wager= $"
				+ Helper.toMoney(((Player) player).getWager()));
	}
	public void displayWalletAtTheEnd() {
		System.out.println("Wallet= $" + Helper.toMoney(player.getWallet()));
	}
	public void deal(Person person, Facing facing) {
		person.hit(deck.dealCard(facing));

	}
	public boolean oneOrBothGotBlackJack() {
		if (player.blackjack() && !dealer.blackjack()) {
			System.out.println("BLACKJACK!!!! You win!");
			player.setWallet(player.getWallet() + ((Player) player).getWager() * 2.5);
			return true;
		}
		if (dealer.blackjack() && !player.blackjack()) {
			System.out.println("The house wins!");
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
	public boolean playerTakesTurnThenBusts() {
		String playerDecision;
		do {
			do {
				playerDecision = (Helper.getString("Hit or Stand? (Enter H or S) ")).toUpperCase();
			} while (!playerDecision.equals("H") && !playerDecision.equals("S"));

			if (playerDecision.equals("H")) {
				deal(player, Facing.UP);
				displayTable();
				if (player.bust()) {
					System.out.println("BUST!! Good luck next time!");
					dealer.setWallet(dealer.getWallet() + ((Player) player).getWager());
					return true;
				}
			}

		} while (!playerDecision.equals("S") && player.getHand().getTotal() < 21);
		return false;
	}
	public boolean dealerTakesTurnThenBusts() {
		try {
			System.out.println("Dealer's turn");
			System.out.println("*************");
			Thread.sleep(LONG_DELAY);

			dealer.getHand().revealFaceDownCards();
			displayTable();
			String dealerAction = "";
			do {
				do {
					dealerAction = ((Dealer) dealer).getDealerAction();
				} while (!dealerAction.equals("H") && !dealerAction.equals("S"));

				if (dealerAction.equals("H")) {
					deal(dealer, Facing.UP);
					displayTable();
					if (dealer.bust()) {
						System.out.println("Dealer busts! You WIN!!");
						player.setWallet(player.getWallet() + ((Player) player).getWager() * 2);
						return true;
					}
				}

			} while (!dealerAction.equals("S"));
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;

		}

	}
	private void compareHandsAndDeclareResult() {
		switch (player.getHand().compareTo(dealer.getHand())) {
		case 1:
			System.out.println("You WIN!!");
			player.setWallet(player.getWallet() + ((Player) player).getWager() * 2);
			break;
		case -1:
			System.out.println("The house wins!");
			dealer.setWallet(dealer.getWallet() + ((Player) player).getWager());
			break;
		case 0:
			System.out.println("It's a TIE!");
			player.setWallet(player.getWallet() + ((Player) player).getWager());
			break;
		default:
			break;
		}

	}

	/**
	 * Constructors, getters & setters
	 */
	public BlackjackGame() {
		dealer = new Dealer("Dealer", 1000000);
		player = new Player("Player", 1000);
		deck = new DeckImpl();
		minBet = 50.00;
	}
	public BlackjackGame(String[] args) {
		this();
		if (args.length == 2) {
			minBet = Double.parseDouble(args[0]);
			player.setWallet(Double.parseDouble(args[1]));
		}

	}
	public Person getDealer() {
		return dealer;
	}
	public void setDealer(Person dealer) {
		this.dealer = dealer;
	}
	public Person getPlayer() {
		return player;
	}
	public void setPlayer(Person player) {
		this.player = player;
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public double getMinBet() {
		return minBet;
	}
	public void setMinBet(double minBet) {
		this.minBet = minBet;
	}

}
