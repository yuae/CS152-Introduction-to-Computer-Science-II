
/**
 * class Worker - extends the thread
 * 
 * @author YE YUAN(ID:145919) 
 * @version Mar.23, 2017
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Worker extends Thread
{
    // instance variables
    private PrintWriter say;
    private Scanner hear;
    private AccountList list;
    private boolean linking = true;

    /**
     * Constructor for objects of class Worker
     */
    public Worker(Socket s, AccountList list)
    {
        try
        {
            //set current worker connection
            hear = new Scanner(s.getInputStream());
            say = new PrintWriter(s.getOutputStream(),true);
            this.list = list;
        }
        catch(IOException e)
        {
            System.out.println("Network is down.\nQuitting...");
            System.exit(1);
        }
    }

    //run method for start
    public void run()
    {
        while(linking)
        {
            if(hear.hasNext())
            {
                //create new message
                Message request = Message.receive(hear);
                //process request and send reply
                processRequest(request).send(say);
                say.flush();//flush printwriter
                try{sleep(10);}
                catch(InterruptedException e){}
            }
        }
    }

    //process message
    private synchronized Message processRequest(Message m)
    {
        String op = m.getOp();//get operation
        Message reply = new Message(op);//temp message
        switch (op)
        {
            case "CREATE": 
            {
                boolean exist = list.exist(m.getAcctNum());
                if(exist==true)//check repeat account
                {    
                    reply = new Message("ERROR","Account already exist.");
                }
                else//reply message
                {    
                    list.add(m.getAcctNum(),m.getAmount(),m.getOwner()); 
                    reply = new Message(op,"",m.getAmount(),"");
                }   
                break;   
            }     
            case "CLOSE":
            {
                boolean exist = list.exist(m.getAcctNum());
                if(exist==false)
                {
                    reply = new Message("ERROR","No such account.");
                }
                else
                {
                    list.remove(m.getAcctNum()); 
                    reply = new Message(op,"",0,"");
                }    
                break;     
            }
            case "DEPOSIT":
            {
                boolean exist = list.exist(m.getAcctNum());
                if(exist==false)
                {
                    reply = new Message("ERROR","No such account.");
                }
                else if(m.getAmount() == 0)//check worng deposit amount
                {
                    reply = new Message("ERROR","Insufficient funds.");
                }
                else
                {    
                    list.find(m.getAcctNum()).deposit(m.getAmount());
                    reply = new Message(op,"",list.find(m.getAcctNum()).getBalence(),"");
                }
                break;
            }
            case "WITHDRAW":
            {
                boolean exist = list.exist(m.getAcctNum());
                if(!exist)
                {    
                    reply = new Message("ERROR","No such account.");
                }
                else
                {    
                    list.find(m.getAcctNum()).withdraw(m.getAmount());
                    reply = new Message(op,"",list.find(m.getAcctNum()).getBalence(),"");
                }
                break;
            }
            case "INQUIRE":
            {
                boolean exist = list.exist(m.getAcctNum());
                if(!exist)
                {
                    reply = new Message("ERROR","No such account.");
                }
                else
                {
                    reply = new Message(op,"",list.find(m.getAcctNum()).getBalence(),"");
                }
                break;
            }
            case "QUIT":
            {
                linking = false;
                break;
            }
            case "??":
            {
                reply = new Message("ERROR","Invalid request");
                break;
            }
        }
        return reply;
    }
}
