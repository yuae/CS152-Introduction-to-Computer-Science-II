
/**
 * class Cookies - a class that under the class Treat, which extends it
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.22, 2017
 */

import java.text.*;

public class Cookies extends Treat
{
    // instance variables
    private double price;
    private int quantity;
    
    //take parameters to instance variables
    public Cookies(String name, int quantity, double price)
    {
        super(name);
        this.quantity = quantity;
        this.price = price;
    }

    //calculate the total cost
    public double getCost()
    {
        return price/12*quantity;//since the price was given in dozen, it has to be devided by 12
    }
    
    //override the toString method to proper form
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return quantity+" "+name+" @ "+fmt.format(price/12)+" = "+fmt.format(price/12*quantity);
    }
}
