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

public class PlayerTests {
	Person player;
	@Before
	public void setUp() throws Exception {
		player = new Player();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_blackjack_adds_ace_diamons_and_jack_clubs_should_return_true() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.ACE, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.CLUBS));
		player.setHand(hand);
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, player.blackjack());
	}
	@Test
	public void test_blackjack_adds_7_diamons_and_jack_clubs_should_return_false() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SEVEN, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.CLUBS));
		player.setHand(hand);
		boolean expectedOutcome = false;
		assertEquals(expectedOutcome, player.blackjack());
	}
	@Test
	public void test_bust_adds_jack_diamons_and_7_clubs_and_3_spades_should_return_false() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SEVEN, Suit.CLUBS));
		player.setHand(hand);
		player.hit(
				new CardImpl(Rank.THREE, Suit.SPADES));
		boolean expectedOutcome = false;
		assertEquals(expectedOutcome, player.bust());
	}
	@Test
	public void test_bust_adds_jack_diamons_and_7_clubs_and_8_spades_should_return_true() {
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SEVEN, Suit.CLUBS));
		player.setHand(hand);
		player.hit(
				new CardImpl(Rank.EIGHT, Suit.SPADES));

		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, player.bust());
	}
	@Test
	public void test_hit_adds_card_should_return_3(){
		Hand hand = new HandImpl();
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.JACK, Suit.DIAMONDS));
		hand.addCardAndChangeHandtoHardIfNeeded(
				new CardImpl(Rank.SEVEN, Suit.CLUBS));
		player.setHand(hand);
		player.hit(new CardImpl(Rank.ACE, Suit.SPADES));
		int expectedOutcome = 3;
		assertEquals(expectedOutcome,
				player.getHand().getCardsInHand().size());
	}
	@Test
	public void test_stand_should_return_2() {
		List<Card> cards = new ArrayList<>();
		cards.add(new CardImpl(Rank.ACE, Suit.DIAMONDS));
		cards.add(new CardImpl(Rank.JACK, Suit.CLUBS));
		player.setHand(new HandImpl(cards));
		player.stand();
		int expectedOutcome = 2;
		assertEquals(expectedOutcome,
				player.getHand().getCardsInHand().size());
	}
	@Test
	public void test_placeWager_has_wallet_1000_places_wager_200_should_return_true(){
		player.setWallet(1000);
		double wager = 200;
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome,
				((Player)player).placeWager(wager));
	}
	@Test
	public void test_placeWager_has_wallet_200_places_wager_300_should_return_false(){
		player.setWallet(200);
		double wager = 300;
		boolean expectedOutcome = false;
		assertEquals(expectedOutcome,
				((Player)player).placeWager(wager));
	}
}
