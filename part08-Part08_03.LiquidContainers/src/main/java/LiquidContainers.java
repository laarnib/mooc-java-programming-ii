
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstContainer = 0;
        int secondContainer = 0;

        while (true) {
            int amount = 0;
            
            System.out.println("");
            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");
            
            String input = scan.nextLine();
            
            // Exits the loop
            if (input.equals("quit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            String command = parts[0];

            /* Check if length of string is two to prevent 
            ArrayIndexOutOfBoundsException
            */
            if (parts.length != 2) {
                System.out.println("Invalid command");
                continue;
            }
            
            try {
                amount = Integer.valueOf(parts[1]);                
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Amount should be an integer.");
            }
            
            /* Adds amount to the first container. The container cannot hold
            more than a hundred liters and everything added past it will go to
            waste */
            if (command.equals("add")) {
                if (amount < 0) {
                    continue;
                } else if (firstContainer + amount > 100) {
                    firstContainer = 100;
                } else {
                    firstContainer += amount;
                }
            }
            
            /* Moves the amount of liquid specified from the first to the second
            container. If user enters an amount more than what the first container
            currently holds, move all the remaining liquid. The second container
            cannot hold more than a hundred liters and anything past that will go
            to waste
            */
            else if (command.equals("move")) {
                if (amount < 0) {
                    continue;
                } else if (amount > firstContainer && 
                        firstContainer + secondContainer <= 100) {
                    secondContainer += firstContainer;
                    firstContainer = 0;                    
                } else if (amount <= firstContainer && 
                        firstContainer + secondContainer > 100) {
                    firstContainer -= amount;
                    secondContainer = 100;
                } else {
                    firstContainer -= amount;
                    secondContainer += amount;
                }
            }
            
            /* Removes the amount of liquid specified from the second container. 
            If user specifies an amount greater than what the second container 
            currently holds, remove all the remaining liquid.
            */
            else if (command.equals("remove")) {
                if (amount < 0) {
                    continue;
                } else if (amount > secondContainer) {
                    secondContainer = 0;
                } else {
                    secondContainer -= amount;
                }        
            }
            
            else {
                System.out.println("Invalid command");
            }
        }
        
        // Close the scanner
        scan.close();
    }
}