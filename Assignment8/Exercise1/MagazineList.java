
/**
 * MagazineList - create new list
 * 
 * @author YE YUAN(ID:145919) 
 * @version Apr.3rd, 2017
 */
public class MagazineList
{
    //codes from textbook
    private MagazineNode list;
    public MagazineList()
    {
        list = null;
    }
    public String toString()
    {
        String result = "";
        MagazineNode current = list;
        while(current!=null)
        {
            result += current.magazine + "\n";
            current = current.next;
        }
        return result;
    }
    private class MagazineNode
    {
        public Magazine magazine;
        public MagazineNode next;
        public MagazineNode(Magazine mag)
        {
            magazine = mag;
            next = null;
        }
    }
    
    //modified and new methods
    public void add(Magazine m)
    {
        MagazineNode node = new MagazineNode(m);//temp node for new node
        if(list == null)//if nothing in the list add it to the first
        {    
            list = node;
        }
        else if(list.magazine.compareTo(m)>0)//if it is smaller than first add it to the first
        {
            node.next = list;
            list = node;
        }
        else 
        {
            boolean insertion = false;//boolean variable for checking 
            MagazineNode current = list;//a pointer node
            while(!insertion && current.next!=null)//finding when to insert
            {
                if(current.next.magazine.compareTo(m)>0)//if found insert
                {
                    node.next = current.next;
                    current.next = node;
                    insertion = true;
                }
                else//move to next if not match
                {
                    current = current.next;
                }
            }
            if(!insertion)//if it is the biggest add it to the last
                current.next = node;
        }
    }
    public void delete(Magazine m)
    {
        boolean found = false;
        if(list==null)//if nothing in list
        {
            System.out.println("no object in list");
            return;
        }
        else if(list.magazine.compareTo(m)==0)//if first is match
        {
            list = list.next;
            found = true;
        }
        else
        {
            MagazineNode current = list;//pointer
            while(!found&&current.next!=null)//find its position
            {
                if(current.next.magazine.compareTo(m)==0)//delete current node
                {
                    current.next = current.next.next;
                    found = true;
                }
                else//move to next
                    current = current.next;
            }
        }
        if(!found)
            System.out.println("no such magazine");
        else
            System.out.println(m+" is deleted.");
    }
}
