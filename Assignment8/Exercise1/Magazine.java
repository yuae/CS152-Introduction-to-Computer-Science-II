
/**
 * Magazine - create maazine object
 * 
 * @author YE YUAN(ID:145919) 
 * @version Apr.3rd, 2017
 */
public class Magazine implements Comparable<Magazine>
{
    //instnce variable
    private String title;
    
    //constructor
    public Magazine(String newTitle)
    {
        title = newTitle;
    }
    //toString
    public String toString()
    {
        return title;
    }
    
    //implement compare to method
    public int compareTo(Magazine m)
    {
        return this.title.compareTo(m.title);
    }
}
