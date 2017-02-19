package game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Card;
import cards.CardImpl;
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
		hand.addCard(card);
		int expectedOutcome = 1;
		assertEquals(expectedOutcome, hand.getCardsInHand().size());
	}
	@Test
	public void test_addCard_should_increase_cards_by_2() {
		Card card1 = new CardImpl(Rank.ACE, Suit.CLUBS);
		Card card2 = new CardImpl(Rank.EIGHT, Suit.CLUBS);
		hand.addCard(card1);
		hand.addCard(card2);
		int expectedOutcome = 2;
		assertEquals(expectedOutcome, hand.getCardsInHand().size());
	}
	@Test
	public void test_getTotalOfHand_adds_2_and_8_should_return_10() {
		Card card1 = new CardImpl(Rank.TWO, Suit.CLUBS);
		Card card2 = new CardImpl(Rank.EIGHT, Suit.DIAMONDS);
		hand.addCard(card1);
		hand.addCard(card2);
		int expectedOutcome = 10;
		assertEquals(expectedOutcome, hand.getTotalOfHand());
	}
	@Test
	public void test_getCardsInHand_adds_2_clubs_and_8_diamonds_should_return_both() {
		Card card1 = new CardImpl(Rank.TWO, Suit.CLUBS);
		Card card2 = new CardImpl(Rank.EIGHT, Suit.DIAMONDS);
		hand.addCard(card1);
		hand.addCard(card2);
		List<Card> expectedOutcome = new ArrayList<>();
		expectedOutcome.add(0, card1);
		expectedOutcome.add(0, card2);
		assertEquals(expectedOutcome, hand.getCardsInHand());
	}

}
