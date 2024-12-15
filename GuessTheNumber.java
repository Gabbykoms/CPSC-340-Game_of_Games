import java.util.Scanner;
import java.util.Random;

/**
 * A game where one player (Picker) chooses a number in a range, and the other player (Guesser) tries to guess it.
 * The game validates inputs and tracks the number of guesses left, ensuring the rules are followed.
 */
public class GuessTheNumber {

    private int player1Wins = 0;
    private int player1Losses = 0;
    private int player2Wins = 0;
    private int player2Losses = 0;

    public static void main(String[] args) {
        GuessTheNumber game = new GuessTheNumber();
        game.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Guess the Number!");

        // S01: Choose a range of numbers
        int rangeStart, rangeEnd;
        while (true) {
            System.out.print("Enter the start of the range: ");
            rangeStart = validateIntegerInput(scanner);
            System.out.print("Enter the end of the range: ");
            rangeEnd = validateIntegerInput(scanner);

            if (rangeEnd > rangeStart + 1) {
                break;
            } else {
                System.out.println("Invalid range. Please select a valid range with at least two numbers.");
            }
        }

        // S03: Choose the number of guesses
        int rangeSize = rangeEnd - rangeStart + 1;
        int maxGuesses;
        while (true) {
            System.out.printf("Enter the number of guesses (maximum %d): ", rangeSize / 2);
            maxGuesses = validateIntegerInput(scanner);

            if (maxGuesses > 0 && maxGuesses <= rangeSize / 2) {
                break;
            } else {
                System.out.println("Invalid number of guesses. Maximum guesses cannot exceed half of the range size.");
            }
        }

        // S02: Determine player roles
        boolean isUserPicker = random.nextBoolean();
        String picker = isUserPicker ? "Player 1" : "Player 2 ";
        String guesser = isUserPicker ? "Player 2 " : "Player 1 ";

        System.out.printf("Range accepted. %s is the Picker; %s is the Guesser.\n", picker, guesser);

        // SO4: Picker selects a number within the chosen range
        int pickedNumber;
        if (isUserPicker) {
            while (true) {
                System.out.printf("%s, select a number within the range %d to %d: ", picker, rangeStart, rangeEnd);
                pickedNumber = validateIntegerInput(scanner);

                if (pickedNumber >= rangeStart && pickedNumber <= rangeEnd) {
                    System.out.println("Number selected.");
                    break;
                } else {
                    System.out.println("Invalid selection. The number must be within the chosen range.");
                }
            }
        } else {
            pickedNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            System.out.printf("Number selected.\n");
        }

        // SO5: Guesser attempts to guess the number
        int guessesUsed = 0;
        boolean guessedCorrectly = false;
        while (guessesUsed < maxGuesses) {
            System.out.printf("Guesser, you have %d guesses left. Enter your guess: ", maxGuesses - guessesUsed);
            int guess = isUserPicker ? random.nextInt(rangeEnd - rangeStart + 1) + rangeStart : validateIntegerInput(scanner);

            if (guess < rangeStart || guess > rangeEnd) {
                System.out.printf("Invalid selection. The number must be within the chosen range.\n");
                continue;
            }

            guessesUsed++;

            if (guess == pickedNumber) {
                guessedCorrectly = true;
                break;
            } else {
                System.out.printf("Incorrect guess. You have %d guesses left.\n", maxGuesses - guessesUsed);
            }
        }

        // Game outcome
        if (guessedCorrectly) {
            System.out.printf("Congratulations! %s guessed the number! You win!\n", guesser);
            if (isUserPicker) {
                player2Wins++;
                player1Losses++;
            } else {
                player1Wins++;
                player2Losses++;
            }
        } else {
            System.out.printf("Game over! The picker wins. The number was %d.\n", pickedNumber);
            if (isUserPicker) {
                player1Wins++;
                player2Losses++;
            } else {
                player2Wins++;
                player1Losses++;
            }
        }

        scanner.close();
    }

    /**
     * Validates and retrieves an integer input from the user.
     *
     * @param scanner Scanner for user input
     * @return Valid integer input
     */
    private int validateIntegerInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number with the range");
            }
        }
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
 *
 * @return the count of Player 1's losses.
 */
public int player1Losses() {
    return player1Losses;
}

/**
 * Retrieves the total number of losses for Player 2.
 *
 * @return the count of Player 2's losses.
 */
public int player2Losses() {
    return player2Losses;
}

}
