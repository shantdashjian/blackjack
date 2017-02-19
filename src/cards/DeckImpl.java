package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckImpl implements Deck {
	private List<Card> cards;
	private int numDealt;

	public DeckImpl() {
		this.cards = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new CardImpl(rank, suit));
			}
		}
		this.numDealt = 0;
		shuffle();
	}

	@Override
	public void shuffle() {
		Collections.shuffle(cards);
	}

	@Override
	public Card dealCard(Facing facing) {
		Card card = cards.remove(0);
		card.setFace(facing);
		return card;
	}

	@Override
	public List<Card> getCardsLeft() {
		return cards;
	}


}
