
/**
 * Account - creating account object
 * 
 * @author YE YUAN(ID:145919) 
 * @version Mar.23, 2017
 */
public class Account
{
    // instance variables 
    private int balence;
    private String acctNum,owner;

    /**
     * Constructor for objects of class Account
     */
    public Account(String acctNum, int balence, String owner)
    {
        this.acctNum = acctNum;
        this.balence = balence;
        this.owner = owner;
    }

    //methods
    public int getBalence()
    {
        return balence; 
    }
    public String getAccount()
    {
        return acctNum;
    }
    public String getName()
    {
        return owner;
    }
    public void deposit(int amount)
    {
        balence += amount; 
    }
    public void withdraw(int amount)
    {
        balence -= amount;
    }
}
