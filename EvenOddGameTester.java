class EvenOddGameTester {
    public static void main(String[] args) {
        EvenOddGame game = new EvenOddGame();
        game.start();

        System.out.println("Player 1 Total Wins: " + EvenOddGame.player1Wins());
        System.out.println("Player 1 Total Losses: " + EvenOddGame.player1Losses());
        System.out.println("Player 2 Total Wins: " + EvenOddGame.player2Wins());
        System.out.println("Player 2 Total Losses: " + EvenOddGame.player2Losses());
    }

    public static void testGame() {
        // Simulate inputs for testing
        int[][] testCases = {
            {3, 2}, // Player 1: 3, Player 2: 2 (Sum: 5, Odd)
            {4, 4}, // Player 1: 4, Player 2: 4 (Sum: 8, Even)
            {1, 5}, // Player 1: 1, Player 2: 5 (Sum: 6, Even)
        };

        int player1Score = 0;
        int player2Score = 0;

        for (int[] testCase : testCases) {
            int player1Number = testCase[0];
            int player2Number = testCase[1];
            int sum = player1Number + player2Number;

            System.out.println("Player 1 chose: " + player1Number);
            System.out.println("Player 2 chose: " + player2Number);
            System.out.println("The sum is: " + sum);

            if (sum % 2 == 0) {
                System.out.println("The sum is Even. Player 2 wins this round!");
                player2Score++;
                EvenOddGame.player2Wins++;
            } else {
                System.out.println("The sum is Odd. Player 1 wins this round!");
                player1Score++;
                EvenOddGame.player1Wins++;
            }

            EvenOddGame.displayScoreboard(player1Score, player2Score);
        }

        // Final results
        if (player1Score > player2Score) {
            System.out.println("Player 1 is the overall winner in the test!");
        } else if (player2Score > player1Score) {
            System.out.println("Player 2 is the overall winner in the test!");
        } else {
            System.out.println("The test ended in a tie!");
        }
    }
}
