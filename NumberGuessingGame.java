package calculator;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100; // You can change this range as desired
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int numberOfAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a random number between " + lowerBound + " and " + upperBound + ". Try to guess it.");

        boolean hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
            } else if (userGuess < randomNumber) {
                System.out.println("It's low! Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("It's high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number (" + randomNumber + ") correctly in " + numberOfAttempts + " attempts.");
                hasGuessedCorrectly = true;
            }
        }

        scanner.close();
    }
}
