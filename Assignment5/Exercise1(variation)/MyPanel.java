
/**
 * MyPanel - JPanel class
 * 
 * @author YE YUAN(ID:145919) 
 * @version Feb.26, 2017
 */



import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel
{
    //instance variables
    private int order,initialSide;
    private Point origin; 
    
    //JPanel Object
    public MyPanel()
    {
        //boolean variable for checking if valid nember was typed
        boolean valid = false;
        
        //acqiring order number
        do
        {
            try
            {
                //check if typed number is integer
                order = Integer.parseInt(JOptionPane.showInputDialog ("Enter order (>1,integer) : "));
                if(order>=1)//check if typed number is greater than 1
                    valid = true;
                else//show message when less than 1
                    JOptionPane.showMessageDialog(null,"Invalid order, Please try again.");
            }
            catch(NumberFormatException exception)//show message if not an integer
            {
                JOptionPane.showMessageDialog(null,"Invalid order, Please try again.");
            }
        }
        while(!valid);//repeat if order is not typed properly
        
        //initializing
        setPreferredSize(new Dimension(800,800));
        setBackground(Color.white);
    }
    
    //paint the JPanel
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        origin = new Point(getWidth()/2,getHeight()/2);
        initialSide = (int)(getWidth()/2);
        
        //recursion method
        drawSquares(origin,initialSide,order,g);
    }
    
    //recursion method for drawing
    public void drawSquares(Point point,int side,int order,Graphics g)
    {
        //recursion method for drawing
        if(order == 0)
        {
            return;
        }
        else
        {
            //calculate corner points(by add/subtruct the center point coordinate with the side)
            Point leftUpCorner = new Point(point.x-side/2,point.y-side/2);
            Point leftDownCorner = new Point(point.x-side/2,point.y+side/2);
            Point rightUpCorner = new Point(point.x+side/2,point.y-side/2);
            Point rightDownCorner = new Point(point.x+side/2,point.y+side/2);
            
            //recursive
            drawSquares(leftUpCorner,side/2,order-1,g);
            drawSquares(leftDownCorner,side/2,order-1,g);
            drawSquares(rightDownCorner,side/2,order-1,g);
            
            //drawing squares
            Square square = new Square(point.x,point.y,side);
            square.draw(g);
            
            //change sequence to match the requirment
            drawSquares(rightUpCorner,side/2,order-1,g);
        }
    }
}
