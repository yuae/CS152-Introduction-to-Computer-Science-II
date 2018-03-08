
/**
 * class Rectangle - a class which is another subclass to class Shape
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.22, 2017
 */
public class Rectangle extends Shape
{
    // instance variables for class Rectangle
    protected double width, length;

    //Constructors for objects of class Rectangle
    public Rectangle()
    {
        width = 1.0;
        length = 1.0;
    }
    public Rectangle(double width, double length)
    {
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length, String color, boolean filled)
    {
        super(color,filled);
        this.width = width;
        this.length = length;
    }
    
    //getters and setters methods for width and length
    public double getWidth()
    {
        return width;
    }
    public void setWidth(double width)
    {
        this.width = width;
    }
    public double getLength()
    {
        return length;
    }
    public void setLength(double length)
    {
        this.length = length;
    }
    
    //methods to calculate the area and perimeter of the Rectangle
    public double getArea()
    {
        return width*length;//return calculated Area
    }
    public double getPerimeter()
    {
        return 2*(width+length);//return calculated Perimeter
    }
    
    //Override toString method in Shape class
    public String toString()
    {
        return "A Rectangle with width = "+width+" and length = "+length
               +", which is a subclass of "+super.toString();
    }
}
