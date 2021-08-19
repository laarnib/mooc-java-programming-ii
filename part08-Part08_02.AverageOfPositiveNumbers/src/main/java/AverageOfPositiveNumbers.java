
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPositives = 0;
        int sumOfPositives = 0;
        double averageOfPositives = 0.0;

        // Keep asking for user input until user enters zero
        while(true) {
            // Check if input is an integer
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                
                // If input is zero, exit the loop
                if (number == 0) {
                    break;
                }
                
                // If number is greater than zero, add to sum and increment count
                if (number > 0) {
                    countPositives++;  
                    sumOfPositives += number;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
            }
            
            // Handle next line or enter key
            scanner.nextLine();
        }
        
        // Close the scanner
        scanner.close();
        
        // Calculate the average of the positive numbers;
        averageOfPositives = calculateAverage(sumOfPositives, countPositives);
        
        if (averageOfPositives == -1) {
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(averageOfPositives);
        }
    }
    
    /* Calculate average of numbers.
    If count is zero, return -1*/
    public static double calculateAverage(int sum, int count) {
        if (count == 0) {
            return -1;
        }
        
        return (double)sum / count;       
    }
}