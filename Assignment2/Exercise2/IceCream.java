
/**
 * class IceCream - a class that under the class Treat, which extends it
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.22, 2017
 */

import java.text.*;

public class IceCream extends Treat
{
    // instance variables
    protected double price;
    
    //take parameters to instance variables
    public IceCream(String name, double price)
    {
        super(name);
        this.price = price;
    }

    //calculate the cost
    public double getCost()
    {
        return price;
    }
    
    //override the toString method to a proper form to store
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return name+" = "+fmt.format(price);
    }
}
