package cards;
/**
 * <h1>CardGraphics</h1>
 * <br>
 * This interface provides card display-related constants and methods
 * <br>
 * @author Shaun Dashjian
 * @version 1.0
 * @year 2017
 */
public interface CardGraphics {
	/**
	 * Those are the templates for each rank in a deck
	 * X in the template will be replaced by with the specific suit symbol
	 */
	public static String[][] cardTemplates = {
			   {" --------- ",
				"| 2       |",
				"|    X    |",
				"|         |",
				"|         |",
				"|         |",
				"|         |",
				"|         |",
				"|    X    |",
				"|       2 |",
				" --------- "},
			   {" --------- ",
				"| 3       |",
				"|    X    |",
				"|         |",
				"|         |",
				"|    X    |",
				"|         |",
				"|         |",
				"|    X    |",
		  	    "|       3 |",
				" --------- "},
			   {" --------- ",
				"| 4       |",
				"|  X   X  |",
				"|         |",
				"|         |",
				"|         |",
				"|         |",
				"|         |",
				"|  X   X  |",
			    "|       4 |",
			    " --------- "},
			   {" --------- ",
			    "| 5       |",
			   	"|  X   X  |",
			   	"|         |",
			   	"|         |",
			   	"|    X    |",
			   	"|         |",
			   	"|         |",
			   	"|  X   X  |",
			    "|       5 |",
			    " --------- "},
			   {" --------- ",
			    "| 6       |",
				"|  X   X  |",
				"|         |",
			    "|         |",
			    "|  X   X  |",
			    "|         |",
			    "|         |",
			    "|  X   X  |",
			    "|       6 |",
			    " --------- "},
			   {" --------- ",
			    "| 7       |",
				"|  X   X  |",
				"|    X    |",
				"|         |",
				"|  X   X  |",
				"|         |",
				"|         |",
				"|  X   X  |",
			    "|       7 |",
			    " --------- "},
			   {" --------- ",
			    "| 8       |",
				"|  X   X  |",
				"|    X    |",
				"|         |",
				"|  X   X  |",
				"|         |",
				"|    X    |",
				"|  X   X  |",
			    "|       8 |",
			    " --------- "},
			   {" --------- ",
			    "| 9       |",
				"|  X   X  |",
				"|         |",
				"|  X   X  |",
				"|    X    |",
				"|  X   X  |",
				"|         |",
				"|  X   X  |",
			    "|       9 |",
			    " --------- "},
			   {" --------- ",
			    "|10       |",
				"|  X   X  |",
				"|    X    |",
				"|  X   X  |",
				"|         |",
				"|  X   X  |",
				"|    X    |",
				"|  X   X  |",
			    "|       10|",
			    " --------- "},
			   {" -------- ",
			    "| J       |",
			    "|  X      |",
			    "|         |",
			    "|         |",
			    "|         |",
			    "|         |",
			    "|         |",
			    "|      X  |",
			    "|       J |",
			    " --------- "},
			   {" --------- ",
			    "| Q       |",
				"|  X      |",
				"|         |",
				"|         |",
				"|         |",
				"|         |",
				"|         |",
				"|      X  |",
				"|       Q |",
				" --------- "},
			   {" --------- ",
				"| K       |",
				"|  X      |",
				"|         |",
				"|         |",
				"|         |",
				"|         |",
				"|         |",
				"|      X  |",
				"|       K |",
				" --------- "},
			   {" --------- ",
				"| A       |",
				"|         |",
				"|         |",
				"|         |",
				"|    X    |",
				"|         |",
				"|         |",
				"|         |",
				"|       A |",
				" --------- "},
			   {" --------- ",
				"|*********|",
				"|*********|",
				"|*********|",
				"|*********|",
				"|*********|",
				"|*********|",
				"|*********|",
				"|*********|",
				"|*********|",
				" --------- "}
			};
	/**
	 * returns the unicode for each suit
	 * @param suit
	 * @return unicode for the card suit symbol
	 */
	public static String toUnicode(Suit suit) {
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
			suitSymbol = "\u2665";
			break;
		}
		return suitSymbol;
	}
}