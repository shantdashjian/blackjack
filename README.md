# backjack
A Java program to play Blackjack

## To download and compile the program:
1. Download **backjack** from *GitHub*. This will download the .zip file
2. Unzip the file. This creates a folder **backjack-master**, inside of which there are a number of .java files under **src/project**
3. In Terminal, navigate to **src**
4. Compile the program:
    ```
    $ javac game/BlackjackGame.java
    ```
5. Run the program:
    ```
    $ java game/BlackjackGame
    ```

## The program interaction is as follows:
1. User is welcomed to SD Blackjack
2. User is asked to place a wager equal to or more than the minimum bet
3. Cards are dealt for both player and dealer
4. If either gets a Blackjack, the game is over
5. If not, player is asked to Hit or Stand
6. If player's total exceeds 21, she busts.
7. After player plays her turn, it's dealer's turn
8. Dealer must Hit if his total <= 16
9. Dealer must Stand if his total is >= 17 and <= 21
10. If dealer exceeds 21, he busts
11. If not, both hands are compared and the highest hand wins the game
12. If hands are equal, it's a tie
