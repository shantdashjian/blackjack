package game;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.CardGraphics;
import cards.Suit;

public class HandImpl implements Hand {
	List<Card> cards;

	public HandImpl() {
		cards = new ArrayList<>();
	}

	public HandImpl(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public void addCard(Card card) {
		cards.add(0, card);
	}

	@Override
	public List<Card> getCardsInHand() {
		return cards;
	}

	@Override
	public int getTotalOfHand() {
		int total = 0;
		for (Card card : cards) {
			total += card.getValue();
		}
		if (total > 21 & softHand()) {
			total -= 10;
			changeHandToHard();
		}
		return total;
	}

	public void changeHandToHard() {
		for (Card card : cards) {
			if (card.isAnAce() && card.getValue() == 11) {
				card.setValue(1);
			}
		}

	}

	public boolean softHand() {
		for (Card card : cards) {
			if (card.isAnAce() && card.getValue() == 11) {
				return true;
			}
		}
		return false;
	}

	public String toASCII(Suit suit) {
		String suitSymbol = "";
		switch (suit) {
		case SPADES:
			suitSymbol = "\u2660";
			break;
		case DIAMONDS:
			suitSymbol = "\u2666";
			break;
		case CLUBS:
			suitSymbol = "\u2663";
			break;
		case HEARTS:
			suitSymbol = "\u2664";
			break;
		}
		return suitSymbol;
	}

	@Override
	public String display(String personName) {
		int rows = CardGraphics.cardTemplates[0].length;
		StringBuilder handStringBuilder = new StringBuilder();
		handStringBuilder.append(personName + "'s hand: \n");

		for (int row = 0; row < rows; row++) {
			for (Card card : cards) {
				if (card.faceUp()) {

					String rowString = CardGraphics.cardTemplates[card.getRank().ordinal()][row].replaceAll("X",
							toASCII(card.getSuit()));

					handStringBuilder.append(rowString);

				} else {
					handStringBuilder.append(CardGraphics.cardTemplates[CardGraphics.cardTemplates.length - 1][row]);
				}
				handStringBuilder.append("   ");
			}
			handStringBuilder.append("\n");
		}
		return handStringBuilder.toString();
	}

	@Override
	public void revealFaceDownCards() {
		for (Card card : cards) {
			card.reveal();
		}

	}
}
