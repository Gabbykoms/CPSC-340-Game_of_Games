import java.util.Scanner;

/**
 * A test class for the FindTheThimble game.
 * Implements "Test Mode" to reveal debug information about the game state,
 * such as the thimble's location and guesses made during each round.
 */
public class FindTheThimbleTest {
    public static void main(String[] args) {
        FindTheThimble game = new FindTheThimble();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Test Mode for Find the Thimble!");

        // Test 'best out of' validation
        int bestOf = 5; // Hardcoded odd value for test mode
        System.out.println("[DEBUG] 'Best out of' set to: " + bestOf);

        // Simulate roles
        boolean isPlayer1Chooser = true;
        System.out.println("[DEBUG] Initial roles: Player 1 is Chooser.");

        int player1Wins = 0;
        int player2Wins = 0;
        int roundNumber = 1;

        while (player1Wins < (bestOf / 2 + 1) && player2Wins < (bestOf / 2 + 1)) {
            System.out.printf("\nRound %d:\n", roundNumber);
            System.out.println("[DEBUG] Current Scores:");
            System.out.printf("Player 1 Wins: %d\n", player1Wins);
            System.out.printf("Player 2 Wins: %d\n", player2Wins);

            String thimbleHand;
            String guess;

            if (isPlayer1Chooser) {
                thimbleHand = "L"; // Hardcoded for testing; use "L" for left or "R" for right.
                System.out.println("[DEBUG] Player 1 hides the thimble in: " + thimbleHand);

                guess = "L"; // Simulate Player 2 guessing correctly
                System.out.println("[DEBUG] Player 2 guesses: " + guess);

                if (guess.equalsIgnoreCase(thimbleHand)) {
                    System.out.println("Player 2 guessed correctly! Player 1 wins this round.");
                    player1Wins++;
                } else {
                    System.out.println("Player 2 guessed incorrectly! Player 2 wins this round.");
                    player2Wins++;
                }
            } else {
                thimbleHand = "R"; // Simulate Player 2 hiding the thimble
                System.out.println("[DEBUG] Player 2 hides the thimble in: " + thimbleHand);

                guess = "R"; // Simulate Player 1 guessing correctly
                System.out.println("[DEBUG] Player 1 guesses: " + guess);

                if (guess.equalsIgnoreCase(thimbleHand)) {
                    System.out.println("Player 1 guessed correctly! Player 2 wins this round.");
                    player2Wins++;
                } else {
                    System.out.println("Player 1 guessed incorrectly! Player 1 wins this round.");
                    player1Wins++;
                }
            }

            if (player1Wins >= (bestOf / 2 + 1) || player2Wins >= (bestOf / 2 + 1)) {
                break;
            }

            // Continue to next round
            isPlayer1Chooser = !isPlayer1Chooser;
            roundNumber++;
        }

        // Display final results
        System.out.println("\nGame Over!");
        if (player1Wins > player2Wins) {
            System.out.println("Player 1 wins the game!");
        } else {
            System.out.println("Player 2 wins the game!");
        }
        System.out.printf("Final Scores: Player 1 Wins: %d | Player 2 Wins: %d\n", player1Wins, player2Wins);

        scanner.close();
    }
}
