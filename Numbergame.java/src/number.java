import java.util.Random;
import java.util.Scanner;

class number{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0, totalRounds = 0;

        while (playAgain) {
            totalRounds++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean correctGuess = false;
            int totalChances = 0;
            int difficulty;

            // Difficulty Level Selection
            while (true) {
                System.out.println("\nSELECT YOUR DIFFICULTY:\nEasy = 1 | Moderate = 2 | Hard = 3");
                
                if (scan.hasNextInt()) {
                    difficulty = scan.nextInt();
                    scan.nextLine(); // Clear input buffer
                    
                    switch (difficulty) {
                        case 1 -> { System.out.println("You selected Easy :) Good luck!"); totalChances = 10; }
                        case 2 -> { System.out.println("You selected Moderate :) Good luck!"); totalChances = 6; }
                        case 3 -> { System.out.println("You selected Hard :) Good luck!"); totalChances = 3; }
                        default -> { System.out.println("Invalid number! Please enter 1, 2, or 3."); continue; }
                    }
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scan.next(); // Clear invalid input
                }
            }

            System.out.println("You have " + totalChances + " attempts to guess the number (1-100).");

            // Guessing Loop
            while (attempts < totalChances && !correctGuess) {
                System.out.print("Enter your guess: ");
                if (!scan.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scan.next();
                    continue;
                }

                int userGuess = scan.nextInt();
                scan.nextLine();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("The number is greater than you guessed! Attempts left: " + (totalChances - attempts));
                } else if (userGuess > numberToGuess) {
                    System.out.println("The number is smaller than you guessed! Attempts left: " + (totalChances - attempts));
                } else {
                    System.out.println("\nWow! You guessed correctly in " + attempts + " attempts!");
                    correctGuess = true;
                    totalScore++;
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you're out of attempts. The correct number was: " + numberToGuess);
            }

            // Play Again Prompt
            System.out.println("\nDo you want to play again?");
            System.out.println("Enter 0 to play again or 1 to exit.");
            System.out.print("Your choice: ");
            
            if (scan.hasNextInt()) {
                int choice = scan.nextInt();
                scan.nextLine();
                if (choice != 0) playAgain = false;
            } else {
                playAgain = false;
            }
        }

        // Final Game Result
        System.out.println("\nGame Over!");
        System.out.println("RESULT: You scored " + totalScore + " out of " + totalRounds + " rounds.");
        scan.close();
    }
}