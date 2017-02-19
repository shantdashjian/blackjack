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
		cards.add(card);
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
		return total;
	}


	public String toASCII(Suit suit) {
		String suitSymbol ="";
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
		System.out.println(personName + "'s hand:");
		int rows = CardGraphics.cardTemplates[0].length;
		StringBuilder handStringBuilder = new StringBuilder();
		for (int row = 0; row < rows; row++){
			for (Card card: cards) {
				if (card.faceUp()){
					handStringBuilder.append(CardGraphics.cardTemplates
						[card.getRank().ordinal()][row].replaceAll("X", toASCII(card.getSuit())));
				} else{
					handStringBuilder.append(CardGraphics.cardTemplates
						[CardGraphics.cardTemplates.length-1][row]);
				}
				handStringBuilder.append("  ");
			}
			handStringBuilder.append("\n");
		}
		return handStringBuilder.toString();
	}
}
