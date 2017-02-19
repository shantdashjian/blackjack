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
		List<Card> cards = new ArrayList<>();
		cards.add(new CardImpl(Rank.ACE, Suit.DIAMONDS));
		cards.add(new CardImpl(Rank.TEN, Suit.CLUBS));
		blackJackGame.getPlayer().setHand(new HandImpl(cards));
		List<Card> otherCards = new ArrayList<>();
		otherCards.add(new CardImpl(Rank.EIGHT, Suit.DIAMONDS));
		otherCards.add(new CardImpl(Rank.TEN, Suit.CLUBS));
		blackJackGame.getDealer().setHand(new HandImpl(otherCards));
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, blackJackGame.oneOrBothGotBlackJack());
	}
	@Test
	public void test_oneOrBothGotBlackJack_passes_blackjack_to_dealer_should_return_true() {
		List<Card> cards = new ArrayList<>();
		cards.add(new CardImpl(Rank.ACE, Suit.DIAMONDS));
		cards.add(new CardImpl(Rank.FOUR, Suit.CLUBS));
		blackJackGame.getPlayer().setHand(new HandImpl(cards));
		List<Card> otherCards = new ArrayList<>();
		otherCards.add(new CardImpl(Rank.ACE, Suit.DIAMONDS));
		otherCards.add(new CardImpl(Rank.JACK, Suit.CLUBS));
		blackJackGame.getDealer().setHand(new HandImpl(otherCards));
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, blackJackGame.oneOrBothGotBlackJack());
	}
	@Test
	public void test_oneOrBothGotBlackJack_passes_blackjack_to_both_should_return_true() {
		List<Card> cards = new ArrayList<>();
		cards.add(new CardImpl(Rank.ACE, Suit.DIAMONDS));
		cards.add(new CardImpl(Rank.TEN, Suit.CLUBS));
		blackJackGame.getPlayer().setHand(new HandImpl(cards));
		List<Card> otherCards = new ArrayList<>();
		otherCards.add(new CardImpl(Rank.ACE, Suit.CLUBS));
		otherCards.add(new CardImpl(Rank.TEN, Suit.DIAMONDS));
		blackJackGame.getDealer().setHand(new HandImpl(otherCards));
		boolean expectedOutcome = true;
		assertEquals(expectedOutcome, blackJackGame.oneOrBothGotBlackJack());
	}

}
