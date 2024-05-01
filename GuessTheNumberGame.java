// TASK 1

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int attemptsLimit = 5;
        int score = 0;

        System.out.println("Let's start the Guess the Number Game!");

        do {
            int randomNumber = random.nextInt(max - min + 1) + min;
            System.out.println("\nI have selected a number between " + min + " and " + max + ".");
            System.out.println("You have " + attemptsLimit + " attempts to guess it.");

            for (int attempts = 1; attempts <= attemptsLimit; attempts++) {
                System.out.print("Enter your guess (Attempt " + attempts + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    score += attemptsLimit - attempts + 1;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                if (attempts == attemptsLimit) {
                    System.out.println("You have run out of attempts. The correct number was: " + randomNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        System.out.println("Game over. Your total score is: " + score);
        scanner.close();
    }
}