package game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Card;
import cards.CardImpl;
import cards.Facing;
import cards.Rank;
import cards.Suit;

public class HandImplTests {
	Hand hand;

	@Before
	public void setUp() throws Exception {
		hand = new HandImpl();
	}

	@After
	public void tearDown() throws Exception {
		hand = null;
	}

	@Test
	public void test_addCard_should_increase_cards_by_1() {
		Card card = new CardImpl(Rank.ACE, Suit.CLUBS);
		hand.addCardAndChangeHandtoHardIfNeeded(card);
		int expectedOutcome = 1;
		assertEquals(expectedOutcome, hand.getCardsInHand().size());
	}
	@Test
	public void test_addCard_should_increase_cards_by_2() {
		Card card1 = new CardImpl(Rank.ACE, Suit.CLUBS);
		Card card2 = new CardImpl(Rank.EIGHT, Suit.CLUBS);
		hand.addCardAndChangeHandtoHardIfNeeded(card1);
		hand.addCardAndChangeHandtoHardIfNeeded(card2);
		int expectedOutcome = 2;
		assertEquals(expectedOutcome, hand.getCardsInHand().size());
	}
	@Test
	public void test_getTotalOfHand_adds_2_and_8_should_return_10() {
		Card card1 = new CardImpl(Rank.TWO, Suit.CLUBS);
		Card card2 = new CardImpl(Rank.EIGHT, Suit.DIAMONDS);
		hand.addCardAndChangeHandtoHardIfNeeded(card1);
		hand.addCardAndChangeHandtoHardIfNeeded(card2);
		int expectedOutcome = 10;
		assertEquals(expectedOutcome, hand.getTotalOfHand());
	}
	@Test
	public void test_getCardsInHand_adds_2_clubs_and_8_diamonds_should_return_both() {
		Card card1 = new CardImpl(Rank.TWO, Suit.CLUBS);
		Card card2 = new CardImpl(Rank.EIGHT, Suit.DIAMONDS);
		hand.addCardAndChangeHandtoHardIfNeeded(card1);
		hand.addCardAndChangeHandtoHardIfNeeded(card2);
		List<Card> expectedOutcome = new ArrayList<>();
		expectedOutcome.add(0, card1);
		expectedOutcome.add(0, card2);
		assertEquals(expectedOutcome, hand.getCardsInHand());
	}
	@Test
	public void test_revealFaceDownCards_should_show_all_cards_face_up(){
		Card card1 = new CardImpl(Rank.TWO, Suit.CLUBS);
		card1.setFace(Facing.DOWN);
		Card card2 = new CardImpl(Rank.EIGHT, Suit.DIAMONDS);
		hand.addCardAndChangeHandtoHardIfNeeded(card1);
		hand.addCardAndChangeHandtoHardIfNeeded(card2);
		hand.revealFaceDownCards();
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome,hand.getCardsInHand().get(0).faceUp());
	}
	@Test
	public void test_compareTo_give_player_stronger_hand_should_return_1(){
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.EIGHT, Suit.CLUBS));
		Hand otherHand = new HandImpl();
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.NINE, Suit.SPADES));
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.THREE, Suit.DIAMONDS));
		int expectedOutcome = 1;
		assertEquals(expectedOutcome, hand.compareTo(otherHand));
	}

	@Test
	public void test_compareTo_give_dealer_stronger_hand_should_return_neg_1(){
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SIX, Suit.CLUBS));
		Hand otherHand = new HandImpl();
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.NINE, Suit.SPADES));
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.DIAMONDS));
		int expectedOutcome = -1;
		assertEquals(expectedOutcome, hand.compareTo(otherHand));
	}
	@Test
	public void test_compareTo_give_equal_hands_should_return_0(){
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SIX, Suit.CLUBS));
		Hand otherHand = new HandImpl();
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.SPADES));
		otherHand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SEVEN, Suit.DIAMONDS));
		int expectedOutcome = 0;
		assertEquals(expectedOutcome, hand.compareTo(otherHand));
	}
}
