import java.util.Scanner;
import java.util.Random;

public class CoinFlipGame {

    private int userWins = 0; // Tracks Player 1's wins
    private int computerWins = 0; // Tracks Computer's wins

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean gameRunning = true;

        System.out.println("Welcome to Coin Flip! Would you like to flip the coin or guess the outcome? Enter 'F' or 'G' for Flipper or Guesser, respectively");

        while (gameRunning) {
            String choice = scanner.nextLine().trim().toUpperCase();

            if (!choice.equals("F") && !choice.equals("G")) {
                System.out.println("Invalid character! Enter 'F' or 'G'");
                continue;
            }

            System.out.println((choice.equals("G") ? "Guesser" : "Flipper") + ", enter best out of value (must be an odd integer)");

            int bestOf;
            while (true) {
                try {
                    bestOf = Integer.parseInt(scanner.nextLine().trim());
                    if (bestOf > 0 && bestOf % 2 != 0) {
                        break;
                    }
                    System.out.println("Invalid best of value! Please enter an odd integer!");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid best of value! Please enter an odd integer!");
                }
            }

            userWins = 0; // Reset wins for a new game
            computerWins = 0; // Reset wins for a new game
            int rounds = 0;

            System.out.println("The game has started! Press enter to continue!");
            scanner.nextLine();

            while (userWins < (bestOf / 2 + 1) && computerWins < (bestOf / 2 + 1)) {
                rounds++;

                if (rounds > 1) {
                    System.out.println("Round " + rounds + " has begun");
                }

                if (choice.equals("G")) {
                    System.out.println("Time to guess! Enter 'H' or 'T' to guess heads or tails, respectively");
                    String guess;
                    while (true) {
                        guess = scanner.nextLine().trim().toUpperCase();
                        if (guess.equals("H") || guess.equals("T")) {
                            break;
                        }
                        System.out.println("Invalid guess! Please enter 'H' or 'T'!");
                    }

                    boolean coinFlip = random.nextBoolean(); // true = heads, false = tails
                    String result = coinFlip ? "heads" : "tails";

                    if ((guess.equals("H") && coinFlip) || (guess.equals("T") && !coinFlip)) {
                        System.out.println("The computer is flipping a coin...\nThe coin landed on " + result + ", you win the round!");
                        userWins++;
                    } else {
                        System.out.println("The computer is flipping a coin...\nThe coin landed on " + result + ", the Computer wins the round!");
                        computerWins++;
                    }
                } else { // Flipper mode
                    String computerGuess = random.nextBoolean() ? "H" : "T";
                    System.out.println("Computer is guessing outcome...\nComputer guessed " + (computerGuess.equals("H") ? "heads" : "tails"));
                    System.out.println("Time to flip the coin! Press enter to flip the coin");
                    scanner.nextLine();

                    boolean coinFlip = random.nextBoolean(); // true = heads, false = tails
                    String result = coinFlip ? "heads" : "tails";

                    if ((computerGuess.equals("H") && coinFlip) || (computerGuess.equals("T") && !coinFlip)) {
                        System.out.println("The coin landed on " + result + ", the Computer wins the round!");
                        computerWins++;
                    } else {
                        System.out.println("The coin landed on " + result + ", you win the round!");
                        userWins++;
                    }
                }

                System.out.println("Scoreboard: You - " + userWins + ", Computer - " + computerWins);
                if (userWins < (bestOf / 2 + 1) && computerWins < (bestOf / 2 + 1)) {
                    System.out.println("Next round! Press enter to continue to next round!");
                    scanner.nextLine();
                }
            }

            System.out.println("Game is over. " + (userWins > computerWins ? "Congratulations, you win!!" : "Computer wins!!") + " Enter '1' to exit game");
            while (true) {
                String exitChoice = scanner.nextLine().trim();
                if (exitChoice.equals("1")) {
                    gameRunning = false;
                    break;
                }
                System.out.println("Invalid entry! Enter '1' to exit game");
            }
        }

        System.out.println("Thanks for playing Coin Flip!");
        scanner.close();

        // Display final wins and losses
        System.out.println("Final Results:");
        System.out.println("Player Wins: " + player1Wins());
        System.out.println("Player Losses: " + player1Loss());
        System.out.println("Computer Wins: " + computerWins());
        System.out.println("Computer Losses: " + computerLoss());
    }

    // New methods to get wins and losses
    public int player1Wins() {
        return userWins;
    }

    public int player1Loss() {
        return computerWins;
    }

    public int computerWins() {
        return computerWins;
    }

    public int computerLoss() {
        return userWins;
    }

    public static void main(String[] args) {
        CoinFlipGame game = new CoinFlipGame();
        game.start(); // Start the game using the start() method
    }
}
