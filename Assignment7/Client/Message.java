//*****************************************************************************
// Message.java - by Stephen Howard
// Represents a message - used by both client and server and for both inbound 
// and outbound messages. A message contains 4 fields:
//      - an operation field
//      - an account number field
//      - an amount field (amount or balance depending on operation)
//      - an owner field
// All fields are stored as strings (but the getter for the amount field 
// returns it as an int).  Any fields not needed are left as empty strings.
// When a message is sent, the 4 fields are concatenated into a single string 
// with fields separated by a delimeter. When a message string is received 
// from the remote party, a message object is created and the fields are loaded 
// by parsed the string (removing the delimiters).   
//*****************************************************************************
import java.util.*;
import java.io.*;
import java.net.*;

public class Message
{
    final static String DELIMITER = ":";
    
    // message fields
    String op = "";       // operation
    String acctNum = "";  // account number
    String amount = "";   // amount/balance
    String owner = "";    // account owner

    //--------------------------------------------------------------------------
    // This constructor creates a message to be sent 
    //--------------------------------------------------------------------------
    public Message(String op, String acctNum, int amount, String owner)
    {
        this.op = op; 
        this.acctNum = acctNum; 
        this.amount = "" + amount; 
        this.owner = owner; 
 
    }
    
    //--------------------------------------------------------------------------
    // This constructor is used by the receive method (below) to build
    // a message object from a received message string
    //--------------------------------------------------------------------------
    public Message(String msgStr)
    {
        Scanner scan = new Scanner (msgStr);
        scan.useDelimiter(DELIMITER);
        if (scan.hasNext()) this.op = scan.next(); 
        if (scan.hasNext()) this.acctNum = scan.next(); 
        if (scan.hasNext()) this.amount = scan.next(); 
        if (scan.hasNext()) this.owner = scan.next(); 

    }

    //--------------------------------------------------------------------------
    // This constructor creates an error message.  In such cases the operation
    // field will contain "ERROR" and the account number field will serve to 
    // hold a description of the error.
    //--------------------------------------------------------------------------
    public Message(String oper, String errorDesc)
    {
        op = oper; 
        acctNum = errorDesc; 
    }

    //--------------------------------------------------------------------------
    // Getters for the 4 message fields
    //--------------------------------------------------------------------------
    public String getOp()
    {
        return op;
    }
    
    public String getAcctNum()
    {
        return acctNum;
    }
        
    public int getAmount()
    {
        // amount should be returned as an int
        try
        {
            return Integer.parseInt(amount);
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }
    
    public String getOwner()
    {
        return owner;
    }

    //--------------------------------------------------------------------------
    // getErrorDescription - there is no error description field per se, so for
    // errors, the account number field serves to hold a description of the error
    //--------------------------------------------------------------------------
    public String getErrorDescription()
    {
        return acctNum;
    }
    
    //--------------------------------------------------------------------------
    // send - sends message 
    //--------------------------------------------------------------------------
    public void send(PrintWriter to) 
    {
        try 
        {
            to.println(this);  // calls toString below
        }
        catch (Exception e)
        {
            System.out.println("Error sending message: [" + this + "]");
        }
    }

    //--------------------------------------------------------------------------
    // receive - receives the incomming string from the remote party and creates
    // a new message object setting its fields from the parsed string
    //--------------------------------------------------------------------------
    public static Message receive(Scanner from)  
    {
        Message msg = null;
        try 
        {
            msg = new Message (from.nextLine());
        }
        catch (Exception e)
        {
            System.out.println("Receive error");
        }
        return msg;
    }
    
    //--------------------------------------------------------------------------
    // toString - returns a string containing the concatenated message fields 
    // separated by a delimiter
    //--------------------------------------------------------------------------
    public String toString()
    {
        return op + DELIMITER + acctNum + DELIMITER + amount + 
                DELIMITER + owner;
    }
}
