// Mastermind Version 3 Darren Dunn

import java.util.Scanner;

public class Mastermind3 {
    public static final String colors="RGYBOP";

    public static void main(String[] args) {

        Mastermind3 mastermind = new Mastermind3();

        StringBuilder secret = mastermind.generateSecret();

        System.out.println(secret);

        // creating a new string originalSecret to keep the original secret
        StringBuilder originalSecret = new StringBuilder(4);

        for (int i = 0; i < 4; i++) {
            originalSecret.append(secret.charAt(i));
        }

        // control
        boolean finished = false;
        int numGuesses = 0;

        while (!finished) {
            StringBuilder copySecret = new StringBuilder(4);
            System.out.println(secret); // for testing purposes

            for (int i = 0; i < 4; i++) {
                copySecret.append(originalSecret.charAt(i));
            }

            String guess = mastermind.getGuess();

            StringBuilder cGuess = new StringBuilder(guess);

            int exacts = mastermind.computeExacts(copySecret, cGuess);
            System.out.println("Number of exacts: " + exacts);

            int partials = mastermind.computePartials(copySecret, cGuess);
            System.out.println("Number of partials: " + partials);

            // iterate number of Guesses
            numGuesses = numGuesses + 1;

            // check if user guessed correctly
            if (exacts == 4) {
                finished = true;
                System.out.println("Congratulations!");
            }

            // print number of guesses
            System.out.println("Number of guesses: " + numGuesses);
        }
    }

    // instance method for generating secret
    public StringBuilder generateSecret() {
        StringBuilder secret = new StringBuilder(4);

        for (int i = 0; i < 4; i++) {
            int index = (int) (colors.length() * Math.random());
            secret.append(colors.charAt(index));
        }
        return secret;
    }

    // instance method for getting user's guess
    public String getGuess() {
        boolean validInput = false;
        String guess = "";
        Scanner scanner = new Scanner(System.in);

        while (!validInput) {
            System.out.println("Guesses consist of 4 letters from:" + colors);
            System.out.println("Please enter a 4 letter guess:");
            guess = scanner.nextLine();

            // validate user input
            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == 'R' || guess.charAt(i) == 'G' || guess.charAt(i) == 'Y' || guess.charAt(i) == 'B' || guess.charAt(i) == 'O' || guess.charAt(i) == 'P') {
                    validInput = true;
                } else {
                    validInput = false;
                }
            }
            if (!validInput) {
                System.out.println("Invalid input. Please use colors provided.");
            }
        }
        return guess;
    }

    // instance method for computing exact matches
    public int computeExacts(StringBuilder secret, StringBuilder guess) {
        int exacts = 0;
        for (int i = 0; i < 4; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                secret.setCharAt(i, '*');
                guess.setCharAt(i, '$');
                exacts = exacts + 1;
            }
        }
        return exacts;
    }

    // instance method for computing partial matches
    public int computePartials(StringBuilder secret, StringBuilder guess) {
        int partials = 0;
        int t = 0;
        while (t < 4) {
            for (int i = 0; i < 4; i++) {
                if (secret.charAt(i) == guess.charAt(t)) {
                    partials = partials + 1;
                }
            }
            t = t + 1;
        }
        return partials;
    }
}