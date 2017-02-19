package game;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.CardImpl;
import cards.Facing;
import cards.Rank;
import cards.Suit;

public class BlackJackGameTests {
	BlackJackGame blackJackGame;
	@Before
	public void setUp() throws Exception {
		blackJackGame = new BlackJackGame();
	}

	@After
	public void tearDown() throws Exception {
		blackJackGame =null;
	}

	@Test
	public void test_deal_passes_player_should_show_player_with_1_card() {
		blackJackGame.deal(blackJackGame.getPlayer(), Facing.UP);
		int expectedOutcome = 1;
		assertEquals(expectedOutcome,
				blackJackGame.getPlayer().getHand().getCardsInHand().size());
	}

	@Test
	public void test_oneOrBothGotBlackJack_passes_blackjack_to_player_should_return_true() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.CLUBS));
		blackJackGame.getPlayer().setHand(hand);
		Hand otherHand = new HandImpl();
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SEVEN, Suit.SPADES));
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.DIAMONDS));
		blackJackGame.getDealer().setHand(otherHand);
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, blackJackGame.oneOrBothGotBlackJack());
	}
	@Test
	public void test_oneOrBothGotBlackJack_passes_blackjack_to_dealer_should_return_true() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SEVEN, Suit.CLUBS));
		blackJackGame.getPlayer().setHand(hand);
		Hand otherHand = new HandImpl();
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.SPADES));
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.DIAMONDS));
		blackJackGame.getDealer().setHand(otherHand);
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, blackJackGame.oneOrBothGotBlackJack());
	}
	@Test
	public void test_oneOrBothGotBlackJack_passes_blackjack_to_both_should_return_true() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.CLUBS));
		blackJackGame.getPlayer().setHand(hand);
		Hand otherHand = new HandImpl();
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.SPADES));
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.DIAMONDS));
		blackJackGame.getDealer().setHand(otherHand);
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, blackJackGame.oneOrBothGotBlackJack());
	}

}
