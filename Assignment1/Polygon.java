
/**
 * Polygon - a class of the driver of the program
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.15, 2017
 */

import javax.swing.JFrame;

public class Polygon
{
    public static void main (String[]args)
    {
        JFrame frame = new JFrame("Interactive Complete Graph");//set title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Panel());//add JPanel to JFrame
        frame.pack();
        frame.setVisible(true);//set polygon visible
    }
}
