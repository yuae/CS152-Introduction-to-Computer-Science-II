
/**
 * SumArray - Test Driver of the program
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Mar.12, 2017
 */
import java.util.*;

public class SumArray
{
    public static void main(String [] args)
    {
        int[] integers = new int[1000000];
        int sum = 0;
        Random ran = new Random();
        Scanner s = new Scanner(System.in);
        for(int index = 0; index<1000000; index++)
        {
            integers[index] = ran.nextInt(100)+1;
            //System.out.println(integers[index]);
            sum+=integers[index];
        }
        AdderThread adder = new AdderThread();
        System.out.println("Enter the number of the threads(<=1000000) : ");
        int numberOfThread = s.nextInt();
		System.out.println();
        System.out.println("total integer sum : "+sum);
		System.out.println();
        System.out.println("total partial sum : "+adder.addEm(integers,numberOfThread));
    }
}
