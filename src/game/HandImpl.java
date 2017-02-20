package game;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.CardGraphics;

public class HandImpl implements Hand {
	private List<Card> cards;

	public HandImpl() {
		cards = new ArrayList<>();
	}

	public HandImpl(List<Card> cards) {
		this();
		this.cards = cards;
	}

	@Override
	public void addCardAndChangeHandtoHardIfNeeded(Card card) {
		cards.add(0, card);
		if (getTotal() > 21 & softHand()) {
			changeHandToHard();
		}
	}

	@Override
	public List<Card> getCards() {
		return cards;
	}

	@Override
	public Integer getTotal() {
		Integer total = 0;
		for (Card card : cards) {
			total += card.getValue();
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

	/**
	 * returns true if there is an Ace counted as 11
	 * @return ace counts as 11
	 */
	public boolean softHand() {
		for (Card card : cards) {
			if (card.isAnAce() && card.getValue() == 11) {
				return true;
			}
		}
		return false;
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
							CardGraphics.toUnicode(card.getSuit()));

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

	@Override
	public int compareTo(Hand otherHand) {
		return this.getTotal().compareTo(otherHand.getTotal());
	}
}
