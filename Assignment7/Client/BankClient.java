
/**
 * BankClient - class for the client side
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Mar.23, 2017
 */

import java.net.*;
import java.io.*;
import java.util.*;

public class BankClient
{
    //instance objects
    private Socket s;
    private Scanner hear;
    private PrintWriter say;
    
    //Constructor
    public BankClient(String host, int port)
    {
        //Creating socket
        try
        {
            s = new Socket(host,port);
            //setting send and receive passage
            say = new PrintWriter(s.getOutputStream(),true);
            hear = new Scanner(s.getInputStream());
            System.out.println("Linking...\nLinking Complete.");
        }
        catch(IOException e)
        {
            System.out.println("Unable to connect sever.\nQuiting...");
            System.exit(1);
        }
    }
    
    //displaying the menu and requiring command
    public void processTransactions()
    {
        //variables, object
        ArrayList <String> accounts = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        Message request,reply;
        String acctNum,own,amount;
        //print menu
        System.out.println("Hello, what can I help you?");
        while(true)
        {
            System.out.println("Please type your operation");
            System.out.println("1.CREATE");
            System.out.println("2.CLOSE");
            System.out.println("3.DEPOSIT");
            System.out.println("4.WITHRAW");
            System.out.println("5.INQUIRE");
            System.out.println("6.QUIT");
            int op = scan.nextInt();
            scan.nextLine();
            //process request
            switch(op)
            {
                //creat new account
                case 1: 
                {
                        System.out.println("Please type your new account number : ");
                        acctNum = scan.nextLine();
                        //if no account was typed then create the account
                        System.out.println("Please type your initial balence : ");
                        amount = scan.nextLine();
                        System.out.println("Please type your name : ");
                        own = scan.nextLine();
                        request = new Message("CREATE",acctNum,Integer.parseInt(amount),own);
                        request.send(say);
                        //say.println(request);
                        say.flush();
                        reply = Message.receive(hear);
                        System.out.println(reply);
                        break;
                }
                //close account
                case 2: 
                {
                        System.out.println("Please type your account number : ");
                        acctNum = scan.nextLine();
                        request = new Message("CLOSE",acctNum,0,"");
                        request.send(say);
                        say.flush();
                        reply = Message.receive(hear);
                        System.out.println(reply);
                        break;
                }
                //deposit money
                case 3: 
                {
                        System.out.println("Please type your account number : ");
                        acctNum = scan.nextLine();
                        System.out.println("Please type the amount you want to deposit: ");
                        amount = scan.nextLine();
                        request = new Message("DEPOSIT",acctNum,Integer.parseInt(amount),"");
                        request.send(say);
                        say.flush();
                        reply = Message.receive(hear);
                        System.out.println(reply);
                        break;
                }
                //withdraw money
                case 4: 
                {
                        System.out.println("Please type your new account number : ");
                        acctNum = scan.nextLine();
                        System.out.println("Please type the amount you want to withdraw : ");
                        amount = scan.nextLine();
                        request = new Message("WITHDRAW",acctNum,Integer.parseInt(amount),"");
                        request.send(say);
                        say.flush();
                        reply = Message.receive(hear);
                        System.out.println(reply);
                        break;
                }
                //inquiring
                case 5: 
                {
                        System.out.println("Please type your account number : ");
                        acctNum = scan.nextLine();
                        request = new Message("INQUIRE",acctNum,0,"");
                        request.send(say);
                        say.flush();
                        reply = Message.receive(hear);
                        System.out.println(reply);
                        break;
                }
                //quiting 
                case 6: 
                {
                        System.out.println("Have a nice day!");
                        request = new Message("Quit","",0,"");
                        request.send(say);
                        say.flush();
                        System.exit(1);
                        break;
                }
                //error message
                default: 
                {
                        request = new Message("??","",0,"");
                         request.send(say);
                         say.flush();
                         reply = Message.receive(hear);
                         System.out.println(reply);
                         break;
                }
            }
        }
    }
    
    //main driver
    public static void main (String[]args)
    {
        //aasking port and host
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter host : ");
        String host = keyboard.nextLine();
        System.out.println("Plaease enter the port number : ");
        int port = keyboard.nextInt();
        keyboard.nextLine();
        //creating object
        BankClient c = new BankClient(host,port);
        c.processTransactions();
    }
}
