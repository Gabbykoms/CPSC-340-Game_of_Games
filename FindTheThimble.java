import java.util.Random;
import java.util.Scanner;

/**
 * A game where two players alternate roles as "chooser" or "hider" to guess which hand contains the thimble. The game continues until one player wins the majority of rounds.
 * Validates inputs, tracks scores, and ensures fair play throughout.
 */

public class FindTheThimble {

    private int player1Wins = 0;
    private int player2Wins = 0;

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Guess the Thimble!");

        // Get the 'best out of' value
        int bestOf = getInt(scanner, "Enter the 'best out of' value (odd integer > 0):",
            "Invalid number! Enter an odd integer greater than 0.", 1, Integer.MAX_VALUE);

        while (bestOf % 2 == 0) {
            System.out.println("Invalid input. Please enter an odd integer.");
            bestOf = getInt(scanner, "Enter the 'best out of' value (odd integer > 0):",
                "Invalid number! Enter an odd integer greater than 0.", 1, Integer.MAX_VALUE);
        }

        // Prompt the user to choose their role
        String roleChoice = getString(scanner, "Enter the role you want: 'c' for chooser or 'h' for hider:",
            "Invalid role choice. Please enter 'c' or 'h'.", "c", "h");
        boolean isPlayer1Chooser = roleChoice.equalsIgnoreCase("c");

        Random random = new Random();
        int roundNumber = 1;

        // Play rounds until one player wins the majority
        while (player1Wins < (bestOf / 2 + 1) && player2Wins < (bestOf / 2 + 1)) {
            System.out.println("\nGuess the Thimble Scoreboard:");
            System.out.printf("Player 1: %d wins\n", player1Wins);
            System.out.printf("Player 2: %d wins\n", player2Wins);

            String thimbleHand;
            String guess;

            if (isPlayer1Chooser) {
                thimbleHand = random.nextBoolean() ? "L" : "R";

                guess = getString(scanner, "Player 2, guess which hand the thimble is in: 'L' for left or 'R' for right:",
                    "Invalid hand choice. Please enter 'L' or 'R' to choose the hand with the thimble.", "L", "R");

                if (guess.equalsIgnoreCase(thimbleHand)) {
                    System.out.println("Chooser wins this round!");
                    player1Wins++;
                } else {
                    System.out.println("Hider wins this round!");
                    player2Wins++;
                }
            } else {
                thimbleHand = getString(scanner, "Player 1, hide the thimble! Enter 'L' for left hand or 'R' for right hand:",
                    "Invalid hand choice. Please enter 'L' or 'R' to choose the hand with the thimble.", "L", "R");

                guess = random.nextBoolean() ? "L" : "R";
                System.out.println("Player 2 guesses: " + guess);

                if (guess.equalsIgnoreCase(thimbleHand)) {
                    System.out.println("Chooser wins this round!");
                    player2Wins++;
                } else {
                    System.out.println("Hider wins this round!");
                    player1Wins++;
                }
            }

            // Check if the game has ended
            if (player1Wins >= (bestOf / 2 + 1) || player2Wins >= (bestOf / 2 + 1)) {
                break;
            }

            // Continue to next round
            System.out.println("Continue to round " + (roundNumber + 1) + ". Press Enter to continue.");
            scanner.nextLine();
            roundNumber++;
            isPlayer1Chooser = !isPlayer1Chooser;
        }

        // Display final message
        int winner = (player1Wins > player2Wins) ? 1 : 2;
        System.out.printf("\nPlayer %d won the overall game! Enter '1' to exit.\n", winner);

        // Wait for exit input
        while (true) {
            String exitChoice = scanner.nextLine();
            if ("1".equals(exitChoice)) {
                System.exit(0);
            } else {
                System.out.println("Invalid input. Enter '1' to exit.");
            }
        }
    }

   


    private int getInt(Scanner scanner, String prompt, String errorMessage, int min, int max) {
        while (true) {
            System.out.println(prompt);
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max && input % 2 != 0) {
                    return input;
                } else if (input % 2 == 0) {
                    System.out.println("Invalid number! Enter an odd integer!");
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer!");
            }
        }
    }

    private String getString(Scanner scanner, String prompt, String errorMessage, String... validInputs) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim().toUpperCase(); // Normalize input
            for (String valid : validInputs) {
                if (input.equals(valid.toUpperCase())) { // Compare normalized inputs
                    return input;
                }
            }
            System.out.println(errorMessage);
        }
    }

    public static void main(String[] args) {
        FindTheThimble game = new FindTheThimble();
        game.play();
    }
     /**
 * Retrieves the total number of wins for Player 1.
 *
 * @return the count of Player 1's wins.
 */
public int player1Wins() {
    return player1Wins;
}

/**
 * Retrieves the total number of wins for Player 2.
 *
 * @return the count of Player 2's wins.
 */
public int player2Wins() {
    return player2Wins;
}

/**
 * Retrieves the total number of losses for Player 1.
 * Note: Player 1's losses are equivalent to Player 2's wins.
 *
 * @return the count of Player 1's losses.
 */
public int player1Losses() {
    return player2Wins;
}

/**
 * Retrieves the total number of losses for Player 2.
 * Note: Player 2's losses are equivalent to Player 1's wins.
 *
 * @return the count of Player 2's losses.
 */
public int player2Losses() {
    return player1Wins;
}
}
