
/**
 * class Square - a subclass to class Rectangle
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.22, 2017
 */

public class Square extends Rectangle
{
    //Constructor for objects of class Square
    public Square()
    {
        length = 1.0;
        width = 1.0;
    }
    public Square(double side)
    {
        super(side,side);
    }
    public Square(double side, String color, boolean filled)
    {
        super(side,side,color,filled);
    }

    //getter and setter for the class
    public double getSide()
    {
        return length;
    }
    public void setSide(double side)
    {
        length = side;
        width = side;
    }
    
    //override methods from class Rectangle
    public String toString()
    {
        return "A Square with side = "+length+", which is a subclass of "+super.toString();
    }
    public void setLength(double side)
    {
        length = side;
        width = side;
    }
    public void setWidth(double side)
    {
        width = side;
        length = side;
    }
}
