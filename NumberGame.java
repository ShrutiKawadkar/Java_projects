import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the NumberGame!");
        System.out.println("Few instruction for you.....");
        System.out.println("1. I will guess any number from 1 to 100 and then you will have to guess a number from the same range.");
        System.out.println("2. If your guessed number is the same as my guesssed number then you will get the 1 point otherwise 0");
        System.out.println("3. You will get 5chances(attempt) to guess the correct number");
        System.out.println("Good luck!");

        while (playAgain) {
            int generatedNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI've picked a number between 1 and 100. Try to guess it!");

            while (attempts < 5 && !guessedCorrectly) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the number correctly!");
                    guessedCorrectly = true;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Number is low! Try again.");
                } else {
                    System.out.println("Number is high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts.\n The correct number was: " + generatedNumber);
            } else {
                score++;
            }

            System.out.print("Your current score: " + score + ".\n Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
         System.out.println("Your final score is: " + score);
        System.out.println("Thanks for playing the Number Guessing Game!");
        scanner.close();
    }
}
