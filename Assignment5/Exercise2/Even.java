
/**
 * class Even - determin if a word typed in is an even word
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.21, 2017
 */

import java.util.Scanner;

public class Even
{
    // instance variables
    private String word;
    
    //main driver of the programm
    public static void main(String[]args)
    {
        System.out.print("Enter word : ");
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        Even words = new Even();
        if(words.isEvenWord(word))
            words.operation(word);
        else
            System.out.println(word+" is not an even word.");
    }
    
    //determine if the word is even
    private boolean isEvenWord(String word)
    {
        int index;//variable to store the index of the character matchs the first character
        boolean ifEven = true;//set initial boolean result
        if(word.length()%2 != 0)//if the characters of the word is odd then it's not a even word
        {
            ifEven = false;
        }
        else
        {
            if(word.isEmpty())//if no characters left then ends the checking process
               {
                   ifEven = true;
                }
            else
            {
                String startChar = word.substring(0,1);//take the first character out of the word
                word = word.substring(1);
                if(word.contains(startChar))//determine if the rest of the word contains the first character
                {
                    index = word.indexOf(startChar);//get the index of the matched character
                    if(index != 0)//take the characters other than the matched character
                        word = word.substring(0,index)+word.substring(index+1);
                    else//if the charcter is at the first place then take the rest of the word
                        word = word.substring(1);
                    isEvenWord(word);
                }
                else//if can't find the matched character in the rest of the word then set false
                {
                    ifEven = false;
                }
            }
        }
        return ifEven;
    }
    public void operation(String word)
    {
        int index;
        if(word.isEmpty())//set base of the recursion
            System.out.println("\t\"\" is an even word.");
        else
        {
            System.out.println("\t\""+word+"\" is a even word, because");
            
            //acquire the first character
            String startChar = word.substring(0,1);
            word = word.substring(1);
            index = word.indexOf(startChar);
            
            //remove the matched charcters
            if(index != 0)
                word = word.substring(0,index)+word.substring(index+1);
            else
                word = word.substring(1);
            
            //set recursions 
            operation(word);
        }
    }
}
