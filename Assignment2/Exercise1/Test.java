
/**
 * class Test - a class tests all methods in all classes
 * 
 * @author Ye Yuan(ID:145919) 
 * @version Jan.22, 2017
 */

import java.util.*;
public class Test
{
    public static void main(String[]args)
    {
        //test class Shape
        Shape one = new Shape();
        Scanner s = new Scanner(System.in);
        System.out.println(one);
        System.out.println("Initialized Color:"+one.getColor());
        System.out.println("Set the color to Blue");
        one.setColor("blue");
        System.out.println("Done.");
        System.out.println("Filled? "+one.isFilled());
        System.out.println("Set the shape unfilled.");
        one.setFilled(false);
        System.out.println("Done.");
        System.out.println(one);
        System.out.println();
        
        //test class Circle
        Circle two = new Circle(1.5);
        System.out.println(two);
        System.out.println("Initialized Color:"+one.getColor());
        System.out.println("Set the color to Red");
        two.setColor("red");
        System.out.println("Done.");
        System.out.println("Filled? "+two.isFilled());
        System.out.println("Set the shape unfilled.");
        two.setFilled(false);
        System.out.println("Done.");
        System.out.println("Set radius to 2.5");
        two.setRadius(2.5);
        System.out.println("Done.");
        System.out.println("The Area of the Circle is "+two.getArea()
                            +" and the perimeter is "+two.getPerimeter());
        System.out.println(two);
        System.out.println();
        
        //test class Rectangle
        Rectangle three = new Rectangle(1.3,2.6,"yellow",false);
        System.out.println(three);
        System.out.println("Initialized Color:"+three.getColor());
        System.out.println("Set the color to Black");
        three.setColor("black");
        System.out.println("Done.");
        System.out.println("Filled? "+three.isFilled());
        System.out.println("Set the shape filled.");
        three.setFilled(true);
        System.out.println("Done.");
        System.out.println("Set width to 2.5, length to 1.7");
        three.setWidth(2.5);
        three.setLength(1.7);
        System.out.println("Done.");
        System.out.println("The Area of the Rectangle is "+three.getArea()
                            +" and the perimeter is "+three.getPerimeter());
        System.out.println(three);
        System.out.println();
        
        //test class Square
        Square four = new Square(2.0,"pink",false);
        System.out.println(four);
        System.out.println("Initialized Color:"+four.getColor());
        System.out.println("Set the color to Violet");
        three.setColor("violet");
        System.out.println("Done.");
        System.out.println("Filled? "+four.isFilled());
        System.out.println("Set the shape filled.");
        three.setFilled(true);
        System.out.println("Done.");
        System.out.println("Set side to 3.5");
        four.setSide(3.5);
        System.out.println("Done.");
        System.out.println("The Area of the Rectangle is "+four.getArea()
                            +" and the perimeter is "+four.getPerimeter());
        System.out.println(four);
    }
}
