
/**
 * class Circle - a subclass to the class Shape
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.22, 2017
 */
public class Circle extends Shape
{
    // instance variables of the class Circle
    private double radius;

    //Constructors for objects of class Circle
    public Circle()
    {
        radius = 1.0;
    }
    public Circle(double radius)
    {
        radius = radius; 
    }
    public Circle(double radius, String color, boolean filled)
    {
        super(color,filled);
        this.radius = radius;
    }
    
    
    //getter and setter methods of the class Circle
    public double getRadius()
    {
        return radius;
    }
    public void setRadius(double radius)
    {
        this.radius = radius;
    }
    
    //methods calculate area and perimeter
    public double getArea()
    {
        return Math.PI*Math.pow(radius,2);//return calculated area of the circle
    }
    public double getPerimeter()
    {
        return Math.PI*2*radius;
    }
    
    //overrides the toString method in Shape
    public String toString()
    {
        return "A Circle with radius = "+radius+", which is a subclass of "+super.toString();
    }
}
