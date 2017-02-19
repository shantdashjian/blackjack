package game;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Facing;

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

}
