
/**
 * class Show - main driver of the program
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.28, 2017
 */

import javax.swing.JFrame;
import java.io.*;

public class Show
{
    public static void main(String[]args) throws IOException
    {
        JFrame frame = new JFrame("Show");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
