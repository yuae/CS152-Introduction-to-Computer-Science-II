
/**
 * AdderThread - create thread
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Mar.14,2017
 */


public class AdderThread extends Thread
{
    //intance variables and objects
    private int[] integers;
    private int low,high;
    private int sum;
    
    //constructors
    public AdderThread()
    {}
    public AdderThread(int[] array, int lo, int hi)
    {
        integers = array;
        low = lo;
        high = hi;
    }
    
    //run method to calculate current thread sum
    public void run()
    {
        for(int i=low;i<high;i++)
        {
            sum+=integers[i];
            if(Math.random()<0.25)//1/4 chance this thread will wait till other thread done summing
            {    
                yield();
            }
        }
        System.out.println("From : "+(low+1)+"  To : "+high);
        System.out.println("partial sum : "+sum);
		System.out.println();
    }
    
    //acquire current thread sum
    public int getSum()
    {
        return sum;
    }
    
    //generates n threads and return total sum of the array passed in
    public static int addEm(int[] array, int n)
    {
        //variables
        AdderThread[] addThread = new AdderThread[n];//store all threads
        int totalSum = 0;//variable holding total sum
        int deltaN = (int)array.length/n;//the integers of every thread need to calculate
        
        //creat n threads
        for(int num = 0; num<n;num++) 
        {    
            AdderThread aThread = new AdderThread(array,deltaN*num,deltaN*(num+1));
            addThread[num] = aThread;
        }
        //sometimes not all element will include in the threads 
        //so we need to modify the last thread when this happened
        if(n*deltaN != array.length)
            addThread[n-1] = new AdderThread(array,deltaN*(n-1),array.length);
        //run and calculate total sum
        for(int i = 0; i<n; i++)
        {
            addThread[i].start();//wait thread end 
            try
            {
                addThread[i].join();
            }
            catch(Exception e)
            {}
            //adding each thread's sum
            totalSum += addThread[i].getSum();
        }
        //return the total sum
        return totalSum;
    }
}
