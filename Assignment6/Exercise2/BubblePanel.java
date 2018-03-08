
/**
 * BubblePanel - creating subpanel object
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Mar.15, 2017
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class BubblePanel extends JPanel
{
    // instance variables
    private BubbleThread bThread;
    private JPanel buttonPanel, breathPanel;
    private JButton start, stop;
    private Random ran = new Random();
    private int diameter,
                bubbleVal = 0;
    private final int X = 200;
    private final int Y = 180;
    
    // Constructor 
    public BubblePanel()
    {   
        //initializing the BubblePanel
        
        //creating objects by calling each object creating method
        start = StartButton();
        stop = StopButton();
        buttonPanel = ButtonPanel();
        buttonPanel.add(start);//adding button to button panel
        buttonPanel.add(stop);
        breathPanel = BreathPanel();
        //add sub panels to BubblePanel
        add(buttonPanel);
        add(breathPanel);
        //implement thread to BubblePanel
        bThread = new BubbleThread(this);
    }
    
    //start the thread
    public void startBreathing()
    {
        bThread.start();
    }
    
    //method called by thread 
    public void Move()
    {
        // get graphics area
        Graphics g = breathPanel.getGraphics();
        
        // get random colours
        Color drawing = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
        // draw the circle
        DrawCircle(g, bubbleVal, drawing);
        
        // go to next phase
        bubbleVal = (bubbleVal+1)%2;
        //get new colors
        drawing = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
        //draw new circle
        DrawCircle(g, bubbleVal, drawing);
    }
    
    //drawing method
    public void DrawCircle(Graphics page, int phase, Color color)
    {
        switch(phase)
        { 
            case 0: //derawing the last circle
                    page.setColor(Color.white);
                    page.fillOval(X-diameter/2, Y-diameter/2, diameter, diameter);
                    
                    //generate small circle diameter (10~30)
                    diameter = ran.nextInt(21)+10;
                    page.setColor(color);
                    //draw the current circle, start point is center point minus radius(diameter/2), and diameter
                    page.fillOval(X-diameter/2, Y-diameter/2, diameter, diameter);
            
            case 1 ://dedrawing the last circle
                    page.setColor(Color.white);
                    page.fillOval(X-diameter/2, Y-diameter/2, diameter, diameter);
                    
                    //generate large circle diameter (100~150)
                    diameter = ran.nextInt(101)+50;
                    page.setColor(color);
                    //draw the current circle, start point is center point minus radius(diameter/2), and diameter
                    page.fillOval(X-diameter/2, Y-diameter/2, diameter, diameter);
        }
    }
    
    //elements creating methods
    private JButton StartButton()//create start buttons
    {
        JButton start = new JButton(" start ");
        start.setEnabled(false);//set start button initialized disabled
        start.addActionListener(new StartListener());//implement button listener
        return start;
    }
    private JButton StopButton()//create stop buttons
    {
        JButton stop = new JButton(" stop ");
        stop.addActionListener(new StopListener());//implement button listener
        return stop;
    }
    private JPanel ButtonPanel()//create button panels
    {
        JPanel buttonPane = new JPanel();
        buttonPane.setPreferredSize(new Dimension(400,40));//set panel size
        buttonPane.setBackground(Color.gray);//set panel background
        return buttonPane;
    }
    private JPanel BreathPanel()//create drawing panels
    {
        JPanel breathPane = new JPanel();
        breathPane.setPreferredSize(new Dimension(400,360));//set panel size
        breathPane.setBackground(Color.white);//set panel background
        return breathPane;
    }
    
    public void breath()
    {
        bThread.setBreathing(true);//enable the thread
        start.setEnabled(false);//diable start button
        stop.setEnabled(true);//enable stop button
    }
    public void suffocate()
    {
        bThread.setBreathing(false);//disable the thread
        stop.setEnabled(false);//disable stop button
        start.setEnabled(true);//enable start button
    }
    
    
    //implement action listeners to buttons
    class StartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            breath();//start "breathing"
        }
    }
    class StopListener implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            suffocate();//stop "breathing"
        }
    }
}
