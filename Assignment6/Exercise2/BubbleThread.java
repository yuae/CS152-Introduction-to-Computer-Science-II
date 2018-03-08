
/**
 * BubbleThread - implements performence to the threads
 * 
 * @author Ye Yuan(ID:145919) 
 * @version March.12, 2017
 */


public class BubbleThread extends Thread
{
    // instance variables
    private BubblePanel adress;
    private boolean breathing = true;

    //constructor
    public BubbleThread(BubblePanel bp)
    {
        /*
         * taking the BubblePanel into thread 
         * so it can call back to the bubble panel 
         * and draw the circle
        */
        adress = bp;
    }

    public void run()
    {
        while(true)
        {  
            //delay acertain time between each drawing
            try{sleep(300);}
            catch(InterruptedException e){}
            // trigger the drawing in the appropriate bubblepanel
            if (breathing)
            {  
                adress.Move();
            }
        }
    }
    
    //method to enable/disable the drawing
    public void setBreathing(boolean status)
    {
        breathing = status;
    }
}
