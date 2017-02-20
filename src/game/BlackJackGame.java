package game;

import cards.Deck;
import cards.DeckImpl;
import cards.Facing;

public class BlackjackGame {
	public static final int LONG_DELAY = 3000;
	public static final int SHORT_DELAY = 1;
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
		BlackjackGame blackJackGame = new BlackjackGame(args);
		blackJackGame.start();
	}

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

	public void start() {
		welcomePlayer();
		String playAgain;
		do {
			playAgain = "N";
			startWithEmptyHands();

			playerPlacesWager();
			dealPlayerAndDealer();
			while (true) {
				if (oneOrBothGotBlackJack()) {
					break;
				}
				if (playerTurnThenBust()) {
					break;
				}
				if (dealerTurnThenBust()) {
					break;
				}
				compareHandsAndDeclareResult();
				break;

			}
			displayWallet();
			if (player.getWallet() >= minBet) {
				playAgain = Helper.getString("Play again (Y/N)? ").toUpperCase();
			} else {
				System.out.println("You do not have sufficient funds to continue playing."
						+ " The house always wins!!");
			}

		} while (playAgain.equals("Y"));
		System.out.println("Cheers!");
	}


	public void welcomePlayer() {
		System.out.println("***************************");
		System.out.println("* Welcome to SD Blackjack *");
		System.out.println("***************************");
	}
	public void startWithEmptyHands(){
		player.setHand(new HandImpl());
		dealer.setHand(new HandImpl());
	}

	public void playerPlacesWager() {
		do {
			if (!((Player) player).placeWager(Helper.getDouble(
					"Minimum bet is $" + Helper.toMoney(minBet) +
					".\nHow much would you like to bet (0 to exit)? ")) ){
				System.out.println("You have a total of $" + Helper.toMoney(player.getWallet())
					+ " in your wallet. Place a wager within your funds. ");
				continue;
			};

			if (((Player) player).getWager() <= 0) {
				System.out.println("Please visit us again!");
				System.exit(0);
			}
		} while (((Player) player).getWager() < minBet );
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
	public void displayWallet() {
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

	public boolean playerTurnThenBust() {
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

	public boolean dealerTurnThenBust() {
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
			// TODO Auto-generated catch block
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
}
