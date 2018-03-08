
/**
 * class Squares - driver
 * 
 * @author (your name) 
 * @version Feb
 */

import javax.swing.*;

public class Squares
{
    public static void main (String[]args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
