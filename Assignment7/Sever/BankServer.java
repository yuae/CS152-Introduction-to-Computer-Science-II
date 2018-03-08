
/**
 * Server - server class
 * 
 * @author YE YUAN(ID:145919) 
 * @version Mar.24, 2017
 */

import java.net.*;
import java.io.*;
import java.util.*;

public class BankServer
{
    private ServerSocket ss;
    private AccountList list; 
    public BankServer(int port)
    {
        try
        {
            System.out.println("Waiting for socket connection on port " + port);
            ss = new ServerSocket(port);
            list = new AccountList();
        }
        catch(IOException e)
        {
            System.out.println("Disconnected.");
        }
    }
    public void handleClients()
    {
		Socket connection = null;
        while(true)
        {
            try
            {
                //create connection passage
                connection = ss.accept();
                System.out.println("Connection accepted from: " + connection.getInetAddress().getHostName());
                //creating worker and process
                Worker worker = new Worker(connection,list);
                worker.start();
            }
            catch (IOException ioe) 
            {
                System.err.println("IO Exception in writing: " + ioe);
            }
        } // while
    }
    public static void main(String[]args)
    {
        //ask for port number
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Plaease enter the port number : ");
        int port = keyboard.nextInt();
        //creat server socket and start thread
        BankServer server = new BankServer(port);
        server.handleClients();
    }
}
