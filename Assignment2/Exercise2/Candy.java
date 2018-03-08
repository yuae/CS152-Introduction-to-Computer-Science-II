
/**
 * class Candy - a class that under the class Treat, which extends it
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.22, 2017
 */

import java.text.*;

public class Candy extends Treat
{
    // instance variables
    private double weight, price;

    //take parameters to instance variables
    public Candy(String name, double weight, double price)
    {
        super(name);
        this.weight = weight;
        this.price = price;
    }

    //calculate the cost 
    public double getCost()
    {
        return weight*price;
    }
    
    //change the toString method to the proper form to store in the arraylist  
    public String toString()
    {
        NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
		DecimalFormat fmt2 = new DecimalFormat("##.##"); 
        return fmt2.format(weight)+" kgs "+name+" @ "+fmt1.format(price)
			   +"/kg"+" = "+fmt1.format(weight*price);
    }
}
