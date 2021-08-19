/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lb123
 * Implements the program
 */

import java.util.Scanner;
public class UserInterface {
    private Container firstContainer;
    private Container secondContainer;
    private Scanner scanner;
    
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.firstContainer = new Container();
        this.secondContainer = new Container();
    }
    
    // Starts the program
    public void start() {
        while(true) {
            int amount = 0;
            
            printContainerContents();
            
            // Get user input
            String input = scanner.nextLine();
            
            if (input.equals("quit")) {
                break;
            }
            
            // Split the input to extract the command and amount
            String[] parts = input.split(" ");
            String command = parts[0];
            
            /* Check if size of string array is two to prevent 
            ArrayIndexOutOfBoundsException.
            */
            if (parts.length != 2) {
                System.out.println("Invalid command");
                continue;
            }
            
            /* Parse second element in array to an Integer. 
            If it's not a number, inform the user
            */
            try {
                amount = Integer.valueOf(parts[1]);                
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Amount should be an integer.");
            }
            
            executeContainerCommand(command, amount);    
        }
    }
    
    // Print the containers current contents
    public void printContainerContents() {
        System.out.println("");
        System.out.println("First: " + firstContainer);
        System.out.println("Second: " + secondContainer);
    }
    
    // Executes the add, move and remove commands. All other commands are invalid.
    public void executeContainerCommand(String command, int amount) {
        if (command.equals("add")) {
            firstContainer.add(amount);
        } else if (command.equals("move")) {
            if (amount > firstContainer.contains()) {
                secondContainer.add(firstContainer.contains());
                firstContainer.remove(amount);
            } else {
                secondContainer.add(amount);
                firstContainer.remove(amount);
            }
        } else if (command.equals("remove")) {
            secondContainer.remove(amount);
        } else {
            System.out.println("Invalid command.  Commands are add, move, and remove");
        }
    }    
}