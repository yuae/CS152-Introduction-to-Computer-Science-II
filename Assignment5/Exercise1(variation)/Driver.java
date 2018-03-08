
/**
 * Driver - driver
 * 
 * @author YE YUAN(ID:145919) 
 * @version Feb.26,2017
 */

import javax.swing.*;

public class Driver
{
    public static void main(String [] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
