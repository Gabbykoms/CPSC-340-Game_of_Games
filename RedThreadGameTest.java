import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RedThreadGameTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean testMode = false; // Test mode flag

        // Welcome message and Test Mode prompt
        System.out.println("Welcome to The Red Thread Game! Would you like to go first or second? Enter 1 or 2");
        System.out.println("Enter 'TEST' to enable Test Mode!");

        String initialInput = scanner.nextLine().trim().toUpperCase();
        int userChoice;

        // Enable Test Mode
        if (initialInput.equals("TEST")) {
            testMode = true;
            System.out.println("Test Mode enabled! Debug information will be displayed.");
            System.out.println("Would you like to go first or second? Enter 1 or 2");
        }

        // Choose order (1 = first, 2 = second)
        while (true) {
            try {
                userChoice = Integer.parseInt(scanner.nextLine().trim());
                if (userChoice == 1 || userChoice == 2) {
                    break;
                }
                System.out.println("Invalid number! Please enter 1 or 2.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number: 1 or 2.");
            }
        }

        // Enter best out of value
        if (userChoice == 1) {
            System.out.println("You’re picking first! Enter best out of value (must be an odd integer)");
        } else {
            System.out.println("You’re picking second! Enter best out of value (must be an odd integer)");
        }

        int bestOf;
        while (true) {
            try {
                bestOf = Integer.parseInt(scanner.nextLine().trim());
                if (bestOf > 0 && bestOf % 2 != 0) {
                    break;
                }
                System.out.println("Invalid best out of value! Please enter an odd integer!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid odd integer.");
            }
        }

        // Enter number of threads to pick at a time
        System.out.println("Great! Please enter the number of threads you would like to pick at a time.");
        int threadsPerPick;
        while (true) {
            try {
                threadsPerPick = Integer.parseInt(scanner.nextLine().trim());
                if (threadsPerPick > 0 && threadsPerPick < 10 && 20 % threadsPerPick == 0) {
                    break;
                }
                System.out.println("Invalid Number! Please enter a number that is less than 10 and a factor of 20!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        int userWins = 0, computerWins = 0, round = 0;

        while (userWins < (bestOf / 2 + 1) && computerWins < (bestOf / 2 + 1)) {
            round++;
            System.out.println("Round " + round + " has begun!");
            System.out.println("Game has started! Threads are being randomized… \nPress enter to continue.");
            scanner.nextLine();

            // Initialize threads: 1 red thread and 19 blue threads
            ArrayList<String> threads = new ArrayList<>();
            for (int i = 0; i < 19; i++) {
                threads.add("blue");
            }
            threads.add("red");
            Collections.shuffle(threads); // Randomize thread positions

            boolean redThreadFound = false;
            boolean isUserTurn = (userChoice == 1);

            while (!redThreadFound && !threads.isEmpty()) {
                if (isUserTurn) {
                    // User's Turn
                    System.out.println("Your turn! Enter \"pick\" to choose " + threadsPerPick + " threads:");

                    // Display debug information for threads to be picked
                    if (testMode) {
                        for (int i = 0; i < threadsPerPick && i < threads.size(); i++) {
                            System.out.println("[DEBUG] Thread about to be picked: " + threads.get(i));
                        }
                    }

                    while (true) {
                        String move = scanner.nextLine().trim().toLowerCase();
                        if (move.equals("pick")) {
                            break;
                        }
                        System.out.println("Invalid move! Enter 'pick' to choose threads.");
                    }

                    for (int i = 0; i < threadsPerPick && !threads.isEmpty(); i++) {
                        String pickedThread = threads.remove(0);
                        if (pickedThread.equals("red")) {
                            System.out.println("You picked the red thread!! You win the round!");
                            userWins++;
                            redThreadFound = true;
                            break;
                        } else {
                            System.out.println("You picked a blue thread!! Better luck next time!");
                        }
                    }
                } else {
                    // Computer's Turn
                    System.out.println("Computer’s Turn! Computer is picking " + threadsPerPick + " threads… \nPress enter to continue.");
                    if (testMode) {
                        for (int i = 0; i < threadsPerPick && i < threads.size(); i++) {
                            System.out.println("[DEBUG] Thread about to be picked: " + threads.get(i));
                        }
                    }
                    scanner.nextLine();

                    for (int i = 0; i < threadsPerPick && !threads.isEmpty(); i++) {
                        String pickedThread = threads.remove(0);
                        if (pickedThread.equals("red")) {
                            System.out.println("Computer picked the red thread! The computer wins this round!");
                            computerWins++;
                            redThreadFound = true;
                            break;
                        } else {
                            System.out.println("Computer picked a blue thread!");
                        }
                    }
                }

                if (!redThreadFound) {
                    System.out.println("Threads remaining: " + threads.size());
                }

                isUserTurn = !isUserTurn; // Alternate turns
            }

            // Update and display scoreboard
            System.out.println("Scoreboard: You - " + userWins + ", Computer - " + computerWins);

            if (userWins < (bestOf / 2 + 1) && computerWins < (bestOf / 2 + 1)) {
                System.out.println("Next round! Press enter to continue to next round!");
                scanner.nextLine();
            }
        }

        // Game over messages
        if (userWins > computerWins) {
            System.out.println("Game is over. Congratulations, you win!! Enter '1' to exit game.");
        } else {
            System.out.println("Game is over. Congratulations, computer wins!! Enter '1' to exit game.");
        }

        while (true) {
            String exitChoice = scanner.nextLine().trim();
            if (exitChoice.equals("1")) {
                break;
            }
            System.out.println("Invalid entry! Enter '1' to exit game.");
        }

        System.out.println("Thanks for playing The Red Thread Game!");
        scanner.close();
    }
}
