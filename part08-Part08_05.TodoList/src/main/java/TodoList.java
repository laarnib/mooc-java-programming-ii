/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lb123
 */
import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> taskList;
   
    public TodoList() {
        this.taskList = new ArrayList<>();
    }
    
    // Adds task to list
    public void add(String task) {
        taskList.add(task);
    }
    
    // Prints the task list with its corresponding number
    public void print() {
        int taskNumber = 1;
        for (String task : taskList) {
            System.out.println(taskNumber + ": " + task);
            taskNumber++;
        }
    }
    
    // Remove a task from the list using its associated number
    public void remove(int number) {
        if (number > taskList.size() || number <= 0) {
            System.out.println("Invalid. Task number does not exist.");
        } else {
            taskList.remove(number - 1);
        }
    }
}