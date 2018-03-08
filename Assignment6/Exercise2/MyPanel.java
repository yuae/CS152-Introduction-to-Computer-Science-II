
/**
 * MyPanel - adding four sub panels to the Panel
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Mar.12,2017
 */

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel
{
    // instance variables and objects
    private BubblePanel[] bubblePanels = new BubblePanel[4];


    //constructor of the panel
    public MyPanel()
    {
        //initialize
        setPreferredSize(new Dimension(815,815));
        setLayout(new GridLayout(2,2,5,5));
        
        //create display elements
        for(int i = 0; i<4;i++)
        {
            bubblePanels[i] = new BubblePanel();
            add(bubblePanels[i]);
        }
        
        //startthread
        for (int i = 0; i < 4; i++)
            bubblePanels[i].startBreathing();
    }
}
