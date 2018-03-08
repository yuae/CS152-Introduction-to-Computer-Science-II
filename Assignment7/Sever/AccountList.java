
/**
 * AccounList - creat a list of account
 * 
 * @author YE YUAN(ID:145919) 
 * @version Mar.23, 2017
 */

import java.util.ArrayList;

public class AccountList
{
    // instance variables
    private ArrayList<Account> list = new ArrayList<Account>();

    /**
     * Constructor for objects of class AccounList
     */
    public AccountList()
    {
        //initiaize the list with two accounts
        list.add(new Account("12345678",5156,"Jone"));
        list.add(new Account("15446343",62647,"Sam"));
    }

    //method
    public void add(String acctNum, int balence, String owner)
    {
        list.add(new Account(acctNum,balence,owner));
    }
    public void remove(String key)
    {
        int index;
        for(int i = 0;i<list.size();i++)
        {
            String match = list.get(i).getAccount();
            if (match.equals(key))
                list.remove(i);
        }
    }
    public Account find(String key)
    {
        Account found = null;
        for(int i = 0;i<list.size();i++)
        {
            String match = list.get(i).getAccount();
            if (match.equals(key))
                found = list.get(i);
        }
        return found;
    }
    public boolean exist(String key)
    {
        boolean found = false;
        for(int i = 0;i<list.size();i++)
        {
            String match = list.get(i).getAccount();
            if (match.equals(key))
                found = true;
        }
        return found;
    }
}
