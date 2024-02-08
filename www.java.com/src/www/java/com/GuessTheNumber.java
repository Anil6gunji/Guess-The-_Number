package www.java.com;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) 
    {
        guessTheNumber();
    }

    static void guessTheNumber() 
    {
        System.out.println("Welcome to the Guess the Number game!");
        boolean playAgain = true;
        int totalAttempts = 0;
        int totalRounds = 0;

        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            // Generate a random number within the specified range
            Random random = new Random();
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean roundWon = false;

            // Prompt user to guess and provide feedback
            while (true) 
            {
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == secretNumber)
                {
                	System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    roundWon = true;
                    break;
                } else if (userGuess < secretNumber) 
                {
                    System.out.println("Too low! Try again.");
                } else 
                {
                    System.out.println("Too high! Try again.");
                }
            }

            totalAttempts += attempts;
            totalRounds++;

            // Limit the number of attempts
            if (attempts > 5)
            {
                System.out.println("Sorry, you've reached the maximum number of attempts. The secret number was: " + secretNumber);
            }

            //  Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        // Display user's score
        System.out.println("\nGame Over!\nTotal Rounds: " + totalRounds + "\nTotal Attempts: " + totalAttempts +"\n");;
        scanner.close();
    }
}
                
