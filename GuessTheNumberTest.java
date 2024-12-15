import java.util.Scanner;
import java.util.Random;

/**
 * Test class for the GuessTheNumber game.
 * Implements a "Test Mode" to display internal information for easier debugging.
 */
public class GuessTheNumberTest {

    public static void main(String[] args) {
        GuessTheNumberTest test = new GuessTheNumberTest();
        test.runTestMode();
    }

    private void runTestMode() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Test Mode for Guess the Number!");

        // Step 1: Set up range
        int rangeStart = 1;
        int rangeEnd = 10;
        System.out.printf("Test mode active: Range is set to %d to %d.%n", rangeStart, rangeEnd);

        // Step 2: Set up maximum guesses
        int maxGuesses = (rangeEnd - rangeStart + 1) / 2;
        System.out.printf("Test mode active: Max guesses is set to %d.%n", maxGuesses);

        // Step 3: Assign roles
        boolean isUserPicker = random.nextBoolean();
        String picker = isUserPicker ? "Player 1 (Tester)" : "Player 2 (AI)";
        String guesser = isUserPicker ? "Player 2 (AI)" : "Player 1 (Tester)";
        System.out.printf("Test mode active: %s is the Picker; %s is the Guesser.%n", picker, guesser);

        // Step 4: Picker selects a number
        int pickedNumber;
        if (isUserPicker) {
            pickedNumber = rangeStart + random.nextInt(rangeEnd - rangeStart + 1);
            System.out.printf("Test mode active: Picker (%s) selects number: %d.%n", picker, pickedNumber);
        } else {
            System.out.printf("%s, select a number between %d and %d: ", picker, rangeStart, rangeEnd);
            pickedNumber = validateIntegerInput(scanner, rangeStart, rangeEnd);
            System.out.printf("Test mode active: Picker selects number: %d.%n", pickedNumber);
        }

        // Step 5: Guesser attempts to guess
        boolean guessedCorrectly = false;
        int guessesUsed = 0;
        while (guessesUsed < maxGuesses) {
            System.out.printf("Guesser (%s), you have %d guesses left.%n", guesser, maxGuesses - guessesUsed);

            int guess;
            if (isUserPicker) {
                System.out.printf("AI guesses: ");
                guess = rangeStart + random.nextInt(rangeEnd - rangeStart + 1);
                System.out.println(guess);
            } else {
                System.out.printf("Enter your guess between %d and %d: ", rangeStart, rangeEnd);
                guess = validateIntegerInput(scanner, rangeStart, rangeEnd);
            }

            System.out.printf("Test mode active: Guesser guesses: %d.%n", guess);
            guessesUsed++;

            if (guess == pickedNumber) {
                guessedCorrectly = true;
                break;
            } else {
                System.out.println("Incorrect guess.");
            }
        }

        // Display game result
        if (guessedCorrectly) {
            System.out.printf("Congratulations! %s guessed the number %d correctly!%n", guesser, pickedNumber);
        } else {
            System.out.printf("Game over! %s failed to guess the number. The correct number was %d.%n", guesser, pickedNumber);
        }

        scanner.close();
    }

    /**
     * Validates and retrieves an integer input from the user within the specified range.
     *
     * @param scanner    Scanner for user input
     * @param rangeStart Start of the range (inclusive)
     * @param rangeEnd   End of the range (inclusive)
     * @return Valid integer input within the specified range
     */
    private int validateIntegerInput(Scanner scanner, int rangeStart, int rangeEnd) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= rangeStart && input <= rangeEnd) {
                    return input;
                } else {
                    System.out.printf("Invalid input. Enter a number between %d and %d.%n", rangeStart, rangeEnd);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}