
/**
 * class Shape - a class that defines the super class 
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.22, 2017
 */
public class Shape
{
    // instance variables used in this class
    protected String color;
    protected boolean filled;

    /**
     * Constructors for objects of class Shape
     */
    
    
    public Shape()
    {
        color = "green";
        filled = true;
    }
    
    public Shape(String color, boolean filled)
    {
        // initialise instance variables
        this.color = color;
        this.filled = filled;
    }

    //setters and getters 
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public String getColor()
    {
        return  color;
    }
    
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }
    
    public boolean isFilled()
    {
        return filled;
    }
    
    //toString method
    public String toString()
    {
        String str;
        if(filled)
            str = "A Shape with color of "+color+" and filled.";
        else
            str = "A Shape with color of "+color+" and not filled.";
        return str;
    }
}
