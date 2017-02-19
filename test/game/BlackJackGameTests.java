package game;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.CardImpl;
import cards.Facing;
import cards.Rank;
import cards.Suit;

public class BlackjackGameTests {
	BlackjackGame blackjackGameackGame;
	@Before
	public void setUp() throws Exception {
		blackjackGameackGame = new BlackjackGame();
	}

	@After
	public void tearDown() throws Exception {
		blackjackGameackGame =null;
	}

	@Test
	public void test_deal_passes_player_should_show_player_with_1_card() {
		blackjackGameackGame.deal(blackjackGameackGame.getPlayer(), Facing.UP);
		int expectedOutcome = 1;
		assertEquals(expectedOutcome,
				blackjackGameackGame.getPlayer().getHand().getCardsInHand().size());
	}

	@Test
	public void test_oneOrBothGotBlackJack_passes_blackjack_to_player_should_return_true() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.CLUBS));
		blackjackGameackGame.getPlayer().setHand(hand);
		Hand otherHand = new HandImpl();
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SEVEN, Suit.SPADES));
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.DIAMONDS));
		blackjackGameackGame.getDealer().setHand(otherHand);
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, blackjackGameackGame.oneOrBothGotBlackJack());
	}
	@Test
	public void test_oneOrBothGotBlackJack_passes_blackjack_to_dealer_should_return_true() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SEVEN, Suit.CLUBS));
		blackjackGameackGame.getPlayer().setHand(hand);
		Hand otherHand = new HandImpl();
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.SPADES));
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.DIAMONDS));
		blackjackGameackGame.getDealer().setHand(otherHand);
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, blackjackGameackGame.oneOrBothGotBlackJack());
	}
	@Test
	public void test_oneOrBothGotBlackJack_passes_blackjack_to_both_should_return_true() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.CLUBS));
		blackjackGameackGame.getPlayer().setHand(hand);
		Hand otherHand = new HandImpl();
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.SPADES));
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.DIAMONDS));
		blackjackGameackGame.getDealer().setHand(otherHand);
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, blackjackGameackGame.oneOrBothGotBlackJack());
	}

}
