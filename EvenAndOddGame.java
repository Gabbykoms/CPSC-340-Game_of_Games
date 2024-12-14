import java.util.Scanner;

public class EvenOddGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Even Odd Game!");
        System.out.println("Two players will enter numbers, and the sum will determine if it's Even or Odd.");

        // Initialize game variables
        int player1Score = 0;
        int player2Score = 0;

        System.out.print("Enter the number of rounds to play (best of 3, 5, etc.): ");
        int totalRounds = scanner.nextInt();

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\nRound " + round + ":");

            System.out.print("Player 1, enter a number (1-5): ");
            int player1Number = scanner.nextInt();
            if (player1Number < 1 || player1Number > 5) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                round--;
                continue;
            }

            System.out.print("Player 2, enter a number (1-5): ");
            int player2Number = scanner.nextInt();
            if (player2Number < 1 || player2Number > 5) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                round--;
                continue;
            }

            // Calculate sum and determine round winner
            int sum = player1Number + player2Number;
            System.out.println("Player 1 chose: " + player1Number);
            System.out.println("Player 2 chose: " + player2Number);
            System.out.println("The sum is: " + sum);

            if (sum % 2 == 0) {
                System.out.println("The sum is Even. Player 2 wins this round!");
                player2Score++;
            } else {
                System.out.println("The sum is Odd. Player 1 wins this round!");
                player1Score++;
            }

            displayScoreboard(player1Score, player2Score);
        }

        // Determine overall winner
        System.out.println("\nGame Over!");
        if (player1Score > player2Score) {
            System.out.println("Player 1 is the overall winner!");
        } else if (player2Score > player1Score) {
            System.out.println("Player 2 is the overall winner!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    // Method to display the scoreboard
    public static void displayScoreboard(int player1Score, int player2Score) {
        System.out.println("Scoreboard: Player 1 - " + player1Score + ", Player 2 - " + player2Score);
    }
}

