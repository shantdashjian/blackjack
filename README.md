# blackjack
A Java program to play a Blackjack game

## In this document:
1. [How to Download, Compile, and Run the Program](#how-to-download-compile-and-run-the-program)
2. [How to Play](#how-to-play)
3. [Class Structure Overview](#class-structure-overview)
4. [Unit Test Suite](#unit-test-suite)


## How to Download, Compile, and Run the Program
1. Download **blackjack** from *GitHub*. This will download the .zip file
2. Unzip the file. This creates a folder **backjack-master**, inside of which there are a number of .java files under the [src folder](src)
3. In Terminal, navigate to **src**
4. Compile the program:

    ```
    $ javac game/BlackjackGame.java
    ```
5. Run the program with default minumum bet = $50.00 and default player wallet amount = $1000.00:

    ```
    $ java game/BlackjackGame
    ```
5. Run the program passing two arguments for minumum bet and player wallet amount:

    ```
    $ java game/BlackjackGame 100 2000
    ```

## How to Play
1. User is welcomed to SD Blackjack
2. User is asked to place a wager equal to or more than the minimum bet
3. Cards are dealt for both player and dealer
4. If either gets a Blackjack, the game is over. Player received 1.5 times her wager if she wins and loses her wager if the dealer gets a blackjack 
5. If not, player is asked to hit or stand
6. If player's total exceeds 21, she busts, i.e. she loses her wager
7. After player plays her turn, it's the dealer's turn
8. Dealer must hit if his total was <= 16
9. Dealer must stand if his total is >= 17 and <= 21
10. If dealer exceeds 21, he busts and player wins as much as his wager
11. If not, both hands are compared and the highest hand wins the game
12. If hands totals are equal, it's a tie
13. Player is offered to play again as long as she has enough money in her wallet for the minimum bet

## Class Structure Overview
- The **BlackjackGame** class is the game driver. Its main() method instantiates an object of type BlackjackGame and calls its play() method to start the game
- The **Person** interface declares methods for persons participating in the game
- The **PersonImpl** abstract class implements the **Person** interface
- Both the **Player** and **Dealer** classes extend the **PersonImpl** class and provide fields and methods for player and dealer functionality
- Both **Player** and **Dealer** have a **Hand**, which is an interface that declares methods for a hand of cards
- The **HandImpl** class implements the **Hand** interface
- The **Deck** interface declares methods for a playing card deck. This is implemented by the **DeckImpl** class and has a list of 52 cards.
- The **Card** interface declares methods for a playing card
- The **CardImpl** implements the **Card** interface. It has a rank, suit, value, and a facing field 
- **Rank**, **Suit**, and **Facing** are enumerators that provide values for each playing card
- The **CardGraphics** and **Helper** interfaces provide static fields and methods for card display and game input/output functionality, respectively

## Unit Test Suite
The core functionality of the project has been developed using TDD. All JUnit tests are included in the [test folder](test)and they cover the core functionality of the following classes:
- HandImpl
- DeckImpl
- Player
- Dealer
- BlackjackGame
