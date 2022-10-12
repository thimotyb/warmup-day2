import java.util.Arrays;
import java.util.Scanner;

/**
 * Ask for a number to calculate the square root of.
 * If the user does not type a number, ask again for a maxium of n times.
 * After <n> attempts, stop the program with a farewell message. (if, while)
 */
public class UserInfo {

    private static final int MAX_ATTEMPTS_ALLOWED = 5; // Declare flow-control constants at the beginning

    private static String[] userInputs = { "", "", "", "", "" };
    // myArray[0] --> String
    // myArray[1]  ---> String
    // myArray[2]   ---> String

    /**
     * Front-End
     * @param args
     */
    public static void main(String[] args) {

        int attempts = 1;
        boolean thereWasAConversionError = false; // Technique: using a flag to "remember" events that happened and use this info later on in your algorithm
        boolean complete = false;

        // This is the main loop (Captain Obvious Strikes Again!)
        while (attempts <= MAX_ATTEMPTS_ALLOWED && !complete) {
            //////// USER INTERFACE //////
            Scanner scanner = new Scanner(System.in); // An object to wait user input from Keyboard
            System.out.println(String.format("Please enter a number (attempt: %d): ", attempts));
            String numberEnteredByUser = scanner.nextLine();

            // Put the string into the array
            userInputs[attempts-1] = numberEnteredByUser;

            ////////////////////
            //// INPUT VALIDATION PART ////////
            int number = 0;
            try {
                number = Integer.parseInt(numberEnteredByUser); // What if String is not convertible into int?
            } catch (NumberFormatException e) {
                System.out.println("The information you typed is not a number.");
                thereWasAConversionError = true;
            }

            ///////
            ////// APPLICATION LOGIC ///////
            if (!thereWasAConversionError) {
                System.out.println("The square root of your number is: " + calculate(number)); // implicit type conversion from int to double
                complete = true;
            } else {
                System.out.println("It is not possible to calculate the square root of: " + numberEnteredByUser);
                attempts = attempts + 1; // attempts++
            } 
            ///////////////////////////////
            if (attempts > MAX_ATTEMPTS_ALLOWED) {
                System.out.println("You are too dumb for this program. I quit.");
            }

        }

        //Arrays.sort(userInputs); // Mutate the array by sorting its elements
        for (String s: userInputs) { // Array linear forward scanning
            System.out.println("You typed: "+s);
        }

    }

    /**
     * Back-End
     * @param value
     * @return
     */
    public static double calculate(double value) {
        double calculatedValue = Math.sqrt(value);
        return calculatedValue;
    }

}
