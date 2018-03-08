
/**
 * class MyPanel - draw the graph
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Feb.9, 2017
 */

//import packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;

public class MyPanel extends JPanel
{
    // instance constants
    private final int COUNTDOWN = 300,//the time of the timer continues
                      DISTENCE = 20,//distence between each bars
                      STARTX = 10,//startX coordinate
                      WIDTH = 10,//width of the bar
                      ACQUIRING_TARGET = 0, //status constants 
                      MOVING_BARS = 1, 
                      INSERTING_TARGET = 2,
                      ZERO = 0;//temperory value of the object for the time being 
    
    // instance variables
    private int [] list = new int [200];//array to store data
    private int count, bottom, key, bar, status, min,//instance variables
                pos = 1;//set initial position to the second position
    private boolean done = false;//boolean variable to determine end of sorting
    
    //instance objects
    private JButton start;//start sorting
    private Color color;//store the color was choosed in JColorChooser
    private Timer timer;//creat delay between change the graph
    
    //main panel setting 
    public MyPanel()
    {
        status = 0;//initial status
        
        //store the data to array
        setList();
        
        //creat and show JColorChooser
        color = JColorChooser.showDialog(this, "Choose the rectangle color", color);
        
        //creat and set initial delay of the timer
        timer = new Timer(COUNTDOWN, new TimeListener());
        
        //creat and implement action to button start
        start = new JButton("Start Sorting");
        start.addActionListener(new StartListener());
        
        //add start to main panel
        add(start);
        
        //initial panel settings
        setPreferredSize(new Dimension(1020,550));
        setBackground(Color.WHITE);
    }
    
    //drawing graph and objects
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        bottom = getHeight();//get the height of the window
        g.setColor(color);//set bars' color to choosed color
        for(int i = 0;i<count;i++)//draw bars
        {
            //x coordinate is startX plus the base distance multiply the position in the array 
            //y coordinate is the bottom subtract the height of the rectangle 
            g.fillRect(STARTX+DISTENCE*i,bottom-list[i],WIDTH,list[i]);
        }
        if(done)//draw text after all sosrting is done
        {
            g.setColor(Color.RED);
            g.drawString ("Sorting Complete",10,10);
        }
    }
    
    //read file and store to array
    private void setList() 
    {
        JFileChooser fc = new JFileChooser(".");
        boolean read = false;
        do//show JFileChooser again when IOExceptions happen
        {
            fc.setDialogTitle("Choose data file");
            fc.showOpenDialog(null);
            try//actions when file is read properly
            {
                Scanner fileScan = new Scanner(fc.getSelectedFile());
                for(int i = 0; fileScan.hasNext();i++)
                {       
                    list[i] = fileScan.nextInt();
                    count++;//count how many datas were stored 
                    read = true;
                }
            }
            catch(IOException excption)//show message when IOException happen
            {   
                JOptionPane.showMessageDialog(null,"Invalid file, Please try again");
            }
        }
        while(!read);
    }
    
    //actually actions when called by stimer
    private void doChange()
    {
        if(!done)
        {
            switch(status)
            {
                case 0://acquiring the currently data
                {
                    key = list[pos];//acquire the data
                    list[pos] = ZERO;//set it to zero
                    repaint();//redraw graph
                    bar = pos-1;//catching the first data to be compared 
                    status = MOVING_BARS;//move to next action
                    timer.start();//start timer
                    break;
                }
                case 1://moving bars until hits the data less then current data 
                {
                    if(key<list[bar])//determine wether to swap
                    {
                        min = bar;//set current min position
                        list[bar+1] = list[bar];//moveing bar
                        list[bar] = ZERO;//set the current bar to zero
                        bar--;//move to the previous bar
                        repaint();//redraw graph
                    }
                    if(bar == -1||key>=list[bar])//determine when to quit
                    {
                        status = INSERTING_TARGET;//move to next action
                    }
                    timer.start();//start timer
                    break;
                }
                case 2://exchange the data
                {
                    list[min] = key;//insert the bar
                    pos++;//moving to the next data
                    repaint();
                    status = ACQUIRING_TARGET;
                    if(pos == count)//when all data procesed set it done
                    {
                        done = true;
                    }
                    timer.start();//start timer
                    break;
                }
            }
        }
    }
    
    
    //implement actions when start is clicked
    private class StartListener implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            timer.start();//start first sorting
        }
    }
    
    //implement actions for timer when timer fires up
    private class TimeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            timer.stop();//stop the timer for next movement
            doChange();//redraw the graph
        }
    }
}
