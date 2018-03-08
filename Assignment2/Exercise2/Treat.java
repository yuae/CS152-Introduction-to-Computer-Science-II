
//*************************************************************
// Treat.java - by S. Howard
// Represents a treat (of some sort).  
//*************************************************************
public abstract class Treat
{
    protected String name; // every treat has a name
    
    public Treat()
    {
        this(""); // calls the other construtor with an empty string
    }
    
    public Treat(String name)
    {
        this.name = name;
    }

    public final String getName() 
    {
        return name;
    }

    public abstract double getCost();  // subclasses must implement
       
}
