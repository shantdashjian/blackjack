package cards;

public class CardImpl implements Card {
	private Rank rank;
	private Suit suit;
	private int value;
	private Facing facing;

	/**
	 * @return the rank
	 */
	@Override
	public Rank getRank() {
		return rank;
	}

	/**
	 * @return the suit
	 */
	@Override
	public Suit getSuit() {
		return suit;
	}

	/**
	 * @return the value
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	public CardImpl(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		this.facing = Facing.UP;
		switch (rank) {
		case JACK:
		case QUEEN:
		case KING:
			value = 10;
			break;
		case ACE:
			value = 11;
			break;
		default:
			value = rank.ordinal() + 2;
		}

	}

	@Override
	public String toString() {
		return (rank + " of " + suit).toLowerCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((suit == null) ? 0 : facing.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CardImpl other = (CardImpl) obj;
		if (rank != other.rank) {
			return false;
		}
		if (suit != other.suit) {
			return false;
		}
		if (facing != other.facing) {
			return false;
		}
		return true;
	}

	@Override
	public boolean faceUp() {
		return (facing == facing.UP);
	}

	@Override
	public boolean faceDown() {
		return (facing == facing.DOWN);
	}

	@Override
	public void setFace(Facing facing) {
		this.facing = facing;

	}






}
