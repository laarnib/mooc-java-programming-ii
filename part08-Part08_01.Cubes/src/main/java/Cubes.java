
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask for input until user enters "end"
        while(true) {
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            } 
            
            // Check if input is a number
            try {
                /* Parse input to an integer and print to the screen 
                the cube of the integer */
                int number = Integer.valueOf(input);
                System.out.println(number * number * number);
            } catch (NumberFormatException e) {
                System.out.println("Input is not a number. Please enter a number.");
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}
