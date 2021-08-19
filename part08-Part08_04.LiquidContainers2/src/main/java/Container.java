/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lb123
 */
public class Container {
    private int amount;
	private String name;
    
    public Container(String name) {
        this.amount = 0;
		this.name = name;
    }
    
	// Returns name of the container
	public String getContainerName() {
		return this.name;
	}

    // Returns the amount that the container currently holds
    public int contains() {
        return this.amount;
    }
    
    /* Adds amount to the container. The container cannot hold
    more than a hundred liters and everything added past it will go to
    waste */    
    public void add(int amount) {
        if (amount < 0) {
            this.amount = this.amount;
        } else if (this.amount + amount > 100) {
            this.amount = 100;
        } else {
            this.amount += amount;
        }        
    }
    
    /* Removes the amount of liquid specified from thecontainer. 
    If user specifies an amount greater than what the container 
    currently holds, remove all the remaining liquid.
    */    
    public void remove(int amount) {
        if (amount < 0) {
            this.amount = this.amount;
        } else if (amount > this.amount) {
            this.amount = 0;
        } else {
            this.amount -= amount;
        }           
    }
    
    @Override
    public String toString() {
        return this.name + ": " + amount + "/100";
    }
}
