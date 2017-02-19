package game;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.CardImpl;
import cards.Rank;
import cards.Suit;

public class DealerTests {
	Person dealer;
	@Before
	public void setUp() throws Exception {
		dealer = new Dealer("Dealer", 1000000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_mustHit_adds_nine_diamons_and_seven_clubs_should_return_true() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.NINE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SEVEN, Suit.CLUBS));
		dealer.setHand(hand);
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, ((Dealer) dealer).mustHit());
	}
	@Test
	public void test_mustHit_adds_nine_diamons_and_ace_clubs_should_return_false() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.NINE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.CLUBS));
		dealer.setHand(hand);
		boolean expectedOutcome = false;
		assertEquals(expectedOutcome, ((Dealer) dealer).mustHit());
	}

	@Test
	public void test_mustStand_adds_nine_diamons_and_seven_clubs_should_return_false() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.NINE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SEVEN, Suit.CLUBS));
		dealer.setHand(hand);
		boolean expectedOutcome = false;
		assertEquals(expectedOutcome, ((Dealer) dealer).mustStand());
	}

	@Test
	public void test_mustStand_adds_nine_diamons_and_ace_clubs_should_return_true() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.NINE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.CLUBS));
		dealer.setHand(hand);
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, ((Dealer) dealer).mustStand());
	}

}
