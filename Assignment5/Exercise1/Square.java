
/**
 * class Square - create Square object and drawing method
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Feb,25,2017
 */

import java.awt.*;

public class Square
{
    // instance variables
    private int side, x, y;
    
    //Constructor for objects of class Rectangle
    public Square(int x, int y, int side)
    {
        this.side = side;
        
        //convert center point to the left corner point for drawing
        this.x = x-side/2;
        this.y = y-side/2;
    }
    
    //drawing method.
    public void draw(Graphics g)
    {
        //filling Squares
        g.setColor(Color.gray);
        g.fillRect(x,y,side,side);
        //drawing the boundary lines of the squares
        g.setColor(Color.black);
        g.drawRect(x,y,side,side);
    }
    
    //toString for checking errors
    public String toString()
    {
        return x+"|||"+y+"|||"+side;
    }
}
