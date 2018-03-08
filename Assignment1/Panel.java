
/**
 * Panel - a class draws the graph
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.15th,2017
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel
{
    //creats the variables needed for the whole class
    private Point pPoint = null;
    private int count= (int)(Math.random()*27)+4;//set the first sides of the graph
    private boolean clicked = false;//set unclicked before any operation
    
    //set initial values and creates Listener objects
    public Panel()
    {
        addKeyListener(new CountListener());
        PointListener listener = new PointListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
        
        setPreferredSize(new Dimension(800,800));
        setBackground(Color.WHITE);
        setFocusable(true);
    }
    
    //draw the Polygon
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Dimension d = getSize();//get the size of the window
        
        if(clicked)
        {
            Point [] nPoint = new Point [count];//an instant array to store the points
            nPoint[0] = pPoint;//add first point
            
            
            //calculate the radius and the angle between the pressed point and the origin point 
            double r = Math.sqrt(Math.pow(pPoint.x-d.width/2,2)+Math.pow(pPoint.y-d.height/2,2));//calculate the radius of the circle all points are on
            Point cPPoint = toCartesian(pPoint);//conert the pressed point in java to cartesian
            double aDirection = Math.atan2(cPPoint.y,cPPoint.x);//calculate the angle between the pressed point and the x-axis in cartesian
            
            //add the rest of the points
            for(int i=1;i<count;i++)
            {
                double theta = i*(2*Math.PI/count)+aDirection;//calculate the angle between nPoint and the x-axis in cartesian 
                                                              //which is angle between successive points 
                                                              //plus the the angle between the pressed point and the x-axis in cartesian
                Point point = new Point((int)(r*Math.cos(theta)),(int)(r*Math.sin(theta)));//calculate the position of the nPoint in cartesian
                point = toJava(point);//convert this point to java point
                nPoint[i] = point;//store it to the array
            }
            
            //draw segment line between every points
            for(int i=0;i<nPoint.length;i++)
            {
                for (int j=i+1;j<nPoint.length;j++)
                {   
                    g.drawLine(nPoint[i].x,nPoint[i].y,nPoint[j].x,nPoint[j].y);
                }
            }
        }
        
        //draw the number of the points on the left corner 
        g.setColor(Color.RED);
        g.drawString ("Points:" + count,5,d.height-5);
    }
    
    //convert cartesian point to java point by the formular in the instruction
    public Point toJava(Point cartesian)
    {
        Dimension d = getSize();
        Point jPoint = new Point(cartesian.x+d.width/2,cartesian.y*-1+d.height/2);
        return jPoint;
    }
    
    //convert javapoint to cartesian point by the formular in the instruction
    public Point toCartesian(Point java)
    {
        Dimension d = getSize();
        Point cPoint = new Point(java.x-(int)d.getWidth()/2,-1*(java.y-(int)d.getHeight()/2));
        return cPoint;
    }
    
    //implement event listeners for drawing
    private class CountListener extends KeyAdapter
    {
        public void keyPressed(KeyEvent event)//implement the new event for action of typing up or down
        {
            switch (event.getKeyCode())
            {
                case KeyEvent.VK_UP:
                {
                    if (count<30)//set boundaries
                        count++;//increase the sides
                    break;
                }
                case KeyEvent.VK_DOWN:
                {
                    if (count>4)//set boundaries
                        count--;//decrease the sides
                    break;
                }
            }
            repaint();//repaint the graph by the new side 
        }
    }
    private class PointListener implements MouseListener,
                                           MouseMotionListener
    {
        public void mousePressed(MouseEvent event)//implement new event for the action click
        {
            if(!clicked)//determine if the mouse was clicked so to determine wether the graph to be paint
            {
                clicked = true;
            }
            pPoint = event.getPoint();
            repaint();
        }
        public void mouseDragged(MouseEvent event)//implement new event for the action drag
        {
            //determine if the mouse was moved so to determine wether the graph to be paint
            if(!clicked)
            {
                clicked = true;
            }
            pPoint = event.getPoint();//get the current position of the mouse
            repaint();
        }
        public void mouseClicked (MouseEvent event){}
        public void mouseReleased (MouseEvent event){}
        public void mouseEntered (MouseEvent event){}
        public void mouseExited (MouseEvent event){}
        public void mouseMoved (MouseEvent event){}
    }
}
