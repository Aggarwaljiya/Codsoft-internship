import java.util.Random;
import java.util.Scanner;

public class numberGame {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 6;
        boolean playAgain = true;

        while (playAgain) {
            int userGuess;
            Scanner scanner = new Scanner(System.in);

            while (attempts < maxAttempts) {
                System.out.println("Guess a number between 1 and 100:");
                userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    int score = (6 - attempts);
                    System.out.println("Congratulations, you Win!");
                    System.out.println("Your score is " + score + " out of 6.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("You ran out of attempts. The number was " + numberToGuess + ".");
            }

            System.out.println("Would you like to play again? (yes/no)");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            } else {
                attempts = 0;
                numberToGuess = random.nextInt(100) + 1;
            }
        }
    }
}
