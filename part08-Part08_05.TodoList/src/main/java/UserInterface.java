/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lb123
 * Implements the program.
 */

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private TodoList todoList;
    
    public UserInterface(TodoList todoList, Scanner scanner) {
        this.scanner = scanner;
        this.todoList = todoList;
    }
    
    public void start() {
        while(true) {
            System.out.print("Command: ");
            String command = scanner.nextLine().toLowerCase();
            
            if (command.equals("stop")) {
                break;
            } else if (command.equals("add")) {
                addTask();
            } else if (command.equals("list")) {
                listTask();
            } else if (command.equals("remove")) {
                removeTask();
            } else {
                System.out.println("Command not found!");
            }
        }
        
        // Close the scanner
        scanner.close();      
    }
    
    // Adds task to the list
    public void addTask() {
        System.out.print("To add: ");
        String task = scanner.nextLine();
        todoList.add(task);
    }
    
    // Prints Todo List
    public void listTask() {
        todoList.print();
    }
    
    // Removes task from Todo List
    public void removeTask() {
        System.out.print("Which one is removed? ");
        
        // Check if input is an integer
        try {
            int number = Integer.valueOf(scanner.nextLine());
            todoList.remove(number);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.out.println("Invalid number");
        }
    }
}