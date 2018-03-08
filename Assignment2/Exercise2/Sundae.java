
/**
 * class Sundae - a class that under the class Treat, which extends it
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.22, 2017
 */


import java.text.*;
public class Sundae extends IceCream
{
    // instance variables
    private String top;
    private double topPrice;

    //take parameters to instance variables
    public Sundae(String name, double price, String top, double topPrice)
	{
    	super.name = name;
    	super.price = price;
        this.top = top;
        this.topPrice = topPrice;
    }

    //calculate the total cost
    public double getCost()
    {
        return price+topPrice;
    }
    
    //override the toString method to proper form
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return name+" ("+fmt.format(price)+") "+" + "+top
               +" ("+fmt.format(topPrice)+") "+" = "+fmt.format(price+topPrice);
    }
}
