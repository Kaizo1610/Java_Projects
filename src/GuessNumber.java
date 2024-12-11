import java.util.Scanner;
import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                guessedCorrectly = true;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
