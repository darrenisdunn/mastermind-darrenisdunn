import java.util.Scanner;
/**
 * Mastermind game with code all in main and no non-constant data members defined
 */
public class Mastermind1 {
    public static final String colors="RGYBOP";

    public static void main(String args[]){
       
        // getGuess
        // you'll need to add code to validate that user entered four
        // valid colors, but leave that at end of project
        String guess="";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guesses consist of 4 letters from:" + colors);
        System.out.println("Please enter a 4 letter guess:");
        guess = scanner.nextLine();
        System.out.println("guess is:"+guess);  // remove this once working


    }
}
