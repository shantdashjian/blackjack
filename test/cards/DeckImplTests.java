package cards;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeckImplTests {
	private Deck deck;
	@Before
	public void setUp() throws Exception {
		deck = new DeckImpl();
	}

	@After
	public void tearDown() throws Exception {
		deck = null;
	}

	@Test
	public void test_dealCard_should_return_a_card() {
		Card expectedOutcome = new CardImpl(Rank.ACE, Suit.CLUBS);
		assertEquals(expectedOutcome.getClass(), deck.dealCard(Facing.UP).getClass());
	}


}
