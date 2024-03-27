import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;
        int totalAttempts = 0;
        int rounds = 0;

        // Play multiple rounds
        while (true) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            System.out.println("Round " + (rounds + 1));

            // Loop until user guesses the correct number or runs out of attempts
            while (attempts < maxAttempts) {
                System.out.print("Guess the number between 1 and 100: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + targetNumber);
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            totalAttempts += attempts;
            rounds++;

            // Check if user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        // Display user's score
        System.out.println("Game over!");
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Average attempts per round: " + (double) totalAttempts / rounds);

        scanner.close();
    }
}
