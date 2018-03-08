
/**
 * MagazineRack - driver class
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Apr.3rd, 2017
 */
public class MagazineRack
{
    public static void main(String[]args)
    {
        //create new list and magazine
        MagazineList rack = new MagazineList();
        Magazine one = new Magazine("Time");
        Magazine two = new Magazine("Woodworking Today");
        Magazine three = new Magazine("Communications of the ACM");
        Magazine four = new Magazine("House and Garden");
        Magazine five = new Magazine("GQ");
        Magazine six = new Magazine("Zed");
        Magazine seven = new Magazine("Ace");
        Magazine eight = new Magazine("Djmax");
        
        //testing deleting when no object added
        rack.delete(three);
        System.out.println(rack);
        //add new magazine
        rack.add(one);
        rack.add(two);
        rack.add(three);
        rack.add(four);
        rack.add(five);
        //print list
        System.out.println(rack);
        
        //testing insertion and delete
        rack.add(six);
        System.out.println(rack);
        rack.delete(three);
        System.out.println(rack);
        rack.add(seven);
        System.out.println(rack);
        rack.add(eight);
        System.out.println(rack);
        rack.delete(six);
        System.out.println(rack);
        rack.delete(seven);
        System.out.println(rack);
        rack.delete(one);
        System.out.println(rack);
    }
}
