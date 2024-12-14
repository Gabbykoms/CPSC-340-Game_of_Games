import java.util.Scanner;
import java.util.Random;

public class CoinFlipGameTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean gameRunning = true;
        boolean testMode = false; // Enable or disable test mode

        System.out.println("Welcome to Coin Flip! Would you like to flip the coin or guess the outcome? Enter 'F' or 'G' for Flipper or Guesser, respectively");
        System.out.println("Enter 'TEST' to enable Test Mode!");

        // Enable test mode if user types "TEST"
        String initialInput = scanner.nextLine().trim().toUpperCase();
        if (initialInput.equals("TEST")) {
            testMode = true;
            System.out.println("Test Mode enabled! Debug information will be displayed.");
        } else {
            System.out.println("Test Mode disabled.");
        }

        while (gameRunning) {
            System.out.println("Enter 'F' or 'G' for Flipper or Guesser");
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

            int userWins = 0, computerWins = 0, rounds = 0;

            System.out.println("The game has started! Press enter to continue!");
            scanner.nextLine();

            while (userWins < (bestOf / 2 + 1) && computerWins < (bestOf / 2 + 1)) {
                rounds++;
                System.out.println("Round " + rounds + " has begun");

                if (choice.equals("G")) {
                    if (testMode) {
                        // Flip the coin and show the result before the user guesses
                        boolean coinFlip = random.nextBoolean(); // true = heads, false = tails
                        String result = coinFlip ? "heads" : "tails";
                        System.out.println("[DEBUG] Coin flip result: " + result);

                        System.out.println("Time to guess! Enter 'H' or 'T' to guess heads or tails, respectively");

                        String guess;
                        while (true) {
                            guess = scanner.nextLine().trim().toUpperCase();
                            if (guess.equals("H") || guess.equals("T")) {
                                break;
                            }
                            System.out.println("Invalid guess! Please enter 'H' or 'T'!");
                        }

                        // Determine if the guess is correct
                        if ((guess.equals("H") && coinFlip) || (guess.equals("T") && !coinFlip)) {
                            System.out.println("The coin landed on " + result + ", you win the round!");
                            userWins++;
                        } else {
                            System.out.println("The coin landed on " + result + ", the Computer wins the round!");
                            computerWins++;
                        }
                    } else {
                        // Normal mode: user guesses before the coin flip
                        System.out.println("Time to guess! Enter 'H' or 'T' to guess heads or tails, respectively");

                        String guess;
                        while (true) {
                            guess = scanner.nextLine().trim().toUpperCase();
                            if (guess.equals("H") || guess.equals("T")) {
                                break;
                            }
                            System.out.println("Invalid guess! Please enter 'H' or 'T'!");
                        }

                        // Flip the coin and reveal the result
                        boolean coinFlip = random.nextBoolean(); // true = heads, false = tails
                        String result = coinFlip ? "heads" : "tails";

                        if ((guess.equals("H") && coinFlip) || (guess.equals("T") && !coinFlip)) {
                            System.out.println("The coin landed on " + result + ", you win the round!");
                            userWins++;
                        } else {
                            System.out.println("The coin landed on " + result + ", the Computer wins the round!");
                            computerWins++;
                        }
                    }
                } else { // Flipper mode
                    String computerGuess = random.nextBoolean() ? "H" : "T";
                    System.out.println("Computer is guessing outcome...");
                    if (testMode) {
                        System.out.println("[DEBUG] Computer's guess: " + (computerGuess.equals("H") ? "heads" : "tails"));
                    }
                    System.out.println("Computer guessed " + (computerGuess.equals("H") ? "heads" : "tails"));
                    System.out.println("Time to flip the coin! Press enter to flip the coin");
                    scanner.nextLine();

                    boolean coinFlip = random.nextBoolean(); // true = heads, false = tails
                    String result = coinFlip ? "heads" : "tails";

                    if (testMode) {
                        System.out.println("[DEBUG] Coin flip result: " + result);
                    }

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
    }
}