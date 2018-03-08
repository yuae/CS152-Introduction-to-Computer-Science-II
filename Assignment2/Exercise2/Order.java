
/**
 * class Order - a class provides the methods to the Driver
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.22, 2017
 */

import java.util.*;

public class Order
{
    // instance variables for this class
    private ArrayList<Treat> order = new ArrayList<Treat>();
    private int orderNumber;
    private double totalCost, totalTax, tax; 
    
    //assign parameters to instance variables
    public Order(int orderNumber, double tax)
    {
        this.orderNumber = orderNumber;
        this.tax = tax;
    }
    
	//methosd provided to Driver

    //method to clear the arraylist
    public void clear()
    {
        order.clear();
    }
    //add Treat subclasses' object to arraylist
    public void addTreat(Treat treat)
    {
        order.add(treat);
    }
    //return the number of treat
    public int numberOfItems()
    {
        return order.size();
    }
    //calculate the total cost
    public double totalCost()
    {
        double cost = 0;//creat a new variable so it won't 
						//calculate the cost twice by calling it twice
		for(int i = 0;i<order.size();i++)
        {
            cost += order.get(i).getCost();
        }
        totalCost = cost;
		return totalCost;
    }
    //calculate the total tax
    public double totalTax()
    {
        return tax*totalCost;
    }
    
    //override the toString method to desired form
    public String toString()
    {
        String result = "Order Number: "+orderNumber+"\n";
        for(Treat item:order)
            result += item+"\n";
        return result;
    }
}
