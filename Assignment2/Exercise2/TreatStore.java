
/********************************************************************************
 * TreatStore.java - Stephen Howard
 * A test driver program the Treat Store program. 
 *********************************************************************************/

import java.text.*;

public class TreatStore 
{

    public static void main(String[] args) 
    {
  
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        
        Order order1 = new Order(123, 0.15);
   
        order1.addTreat(new Candy("Peanut Butter Fudge", 2.25, 5.99));
        order1.addTreat(new IceCream("Vanilla Ice Cream",3.50));
        order1.clear();      
        order1.addTreat(new Sundae("Choc. Chip Ice Cream",3.50, "Hot Fudge", .75));
        order1.addTreat(new Cookies("Oatmeal Raisin Cookies", 4, 7.99));
        System.out.println(order1);
    
        System.out.println("Number of items: " + order1.numberOfItems());
        System.out.println("Total cost: " + fmt.format(order1.totalCost()));
        System.out.println("Total tax: " + fmt.format(order1.totalTax()));
        System.out.println("Cost + Tax: " + (fmt.format(order1.totalCost() + 
                                                        order1.totalTax())));
        System.out.println();
        System.out.println();

        Order order2 = new Order(456, 0.14);

        order2.addTreat(new IceCream("Strawberry Ice Cream",145));
        order2.addTreat(new Sundae("Vanilla Ice Cream",4.00, "Caramel", 1.00));
        order2.addTreat(new Candy("Gummy Worms", 1.33, 4.98));
        order2.addTreat(new Cookies("Chocolate Chip Cookies", 15, 6.50));
        order2.addTreat(new Candy("Salt Water Taffy", 1.5, 7.98));
        order2.addTreat(new Candy("Candy Corn",3.0, 10.50));
        System.out.println(order2);
    
        System.out.println("Number of items: " + order2.numberOfItems());
        System.out.println("Total cost: " + fmt.format(order2.totalCost()));
        System.out.println("Total tax: " + fmt.format(order2.totalTax()));
        System.out.println("Cost + Tax: " + (fmt.format(order2.totalCost() + 
                                                        order2.totalTax())));
        System.out.println();
    }
}