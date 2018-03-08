
/**
 * class Sorting - main driver of the program
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Feb.9, 2017
 */

import javax.swing.*;
import java.io.*;

public class Sorting
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
