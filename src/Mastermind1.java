// Mastermind Version 1 Darren Dunn
import java.util.Scanner;
import java.util.Random;
/**
 * Mastermind game with code all in main and no non-constant data members defined
 */
public class Mastermind1 {
    public static final String colors="RGYBOP";

    public static void main(String args[]) {

        // generateSecret
        // uses StringBuilder to create a new string of limit 4 characters, using only the colors in this class
        StringBuilder secret = new StringBuilder(4);

        for (int i = 0; i < 4; i++) {
            int index = (int) (colors.length() * Math.random());
            secret.append(colors.charAt(index));
        }

        System.out.println(secret);

        //Creating a new string originalSecret to keep the original secret
        StringBuilder originalSecret = new StringBuilder(4);

        for (int i = 0; i < 4; i++) {
            originalSecret.append(secret.charAt(i));
        }

        // getGuess
        // you'll need to add code to validate that user entered four
        // valid colors, but leave that at end of project

        // control
        boolean finished = false;
        int numGuesses = 0;

        while (finished == false) {
            StringBuilder copySecret = new StringBuilder(4);
            for (int i = 0; i < 4; i++) {
                copySecret.append(originalSecret.charAt(i));
            }

            String guess = "";
            Scanner scanner = new Scanner(System.in);
            System.out.println("Guesses consist of 4 letters from:" + colors);
            System.out.println("Please enter a 4 letter guess:");
            guess = scanner.nextLine();

            // convert guess string into StringBuilder
            StringBuilder cGuess = new StringBuilder(guess);

            // computeExacts
            int exacts = 0;
            for (int i = 0; i < 4; i++) {
                if (copySecret.charAt(i) == cGuess.charAt(i)) {
                    copySecret.setCharAt(i, '*');
                    cGuess.setCharAt(i, '$');
                    exacts = exacts + 1;
                }
            }
            System.out.println("Number of exacts: " + exacts);

            // computePartials
            int partials = 0;
            int t = 0;
            while (t < 4) {
                for (int i = 0; i < 4; i++) {
                    if (copySecret.charAt(i) == cGuess.charAt(t)) {
                        partials = partials + 1;
                    }
                }
                t = t + 1;
            }
            System.out.println("Number of partials: " + partials);

            // iterate number of guesses
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
}
