// Mastermind Version 2 Darren Dunn

import java.util.Scanner;

public class Mastermind2 {
    public static final String colors="RGYBOP";

    public static void main(String[] args) {
        StringBuilder secret = generateSecret();

        System.out.println(secret); // for testing purposes

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

            for (int i = 0; i < 4; i++) {
                copySecret.append(originalSecret.charAt(i));
            }

            String guess = getGuess();

            StringBuilder cGuess = new StringBuilder(guess);

            int exacts = computeExacts(copySecret, cGuess);
            System.out.println("Number of exacts: " + exacts);

            int partials = computePartials(copySecret, cGuess);
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

    // static method for generating secret
    public static StringBuilder generateSecret() {
        StringBuilder secret = new StringBuilder(4);

        for (int i = 0; i < 4; i++) {
            int index = (int) (colors.length() * Math.random());
            secret.append(colors.charAt(index));
        }
        return secret;
    }

    // static method for getting user's guess
    public static String getGuess() {
        String guess = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guesses consist of 4 letters from:" + colors);
        System.out.println("Please enter a 4 letter guess:");
        guess = scanner.nextLine();
        return guess;
    }

    // static method for computing exact matches
    public static int computeExacts(StringBuilder secret, StringBuilder guess) {
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

    // static method for computing partial matches
    public static int computePartials(StringBuilder secret, StringBuilder guess) {
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