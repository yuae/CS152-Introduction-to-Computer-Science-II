
/**
 * class DTB - convert an non-negative decimal integer to binary form
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Feb.21,2017
 */

import java.util.Scanner;

public class DTB
{
    //main driver
    public static void main (String[]args)
    {
        System.out.println("Enter an non-negative decimal integer : ");
        Scanner s = new Scanner(System.in);
        int decimal = s.nextInt();
        s.nextLine();
        System.out.println();
        System.out.println("Binary Form : ");
        DTB converter = new DTB();
        converter.DTB(decimal);
    }

    //method to convert decimal to binary
    private void DTB(int decimal)
    {
        if((int)decimal/2 == 0)
        {    
            System.out.print(decimal%2);
        }
        else
        {
            DTB((int)decimal/2);
            System.out.print(decimal%2);
        }
    }
}
