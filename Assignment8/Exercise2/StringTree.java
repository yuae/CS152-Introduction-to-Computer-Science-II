
/**
 * StringTree - create new string tree and driver
 * 
 * @author YE YUAN(ID:145919) 
 * @version Apr.3rd, 2017
 */

import java.util.Scanner;
import java.io.*;

public class StringTree
{
    // instance variables
    private TreeNode treeList;
    
    /**
     * Constructor
     */
    public StringTree()
    {
        treeList = null;//set new node to null
    }
    
    //adding method called by driver
    public void add(String word)
    {
        //treeList = addBranch(word,treeList);
        TreeNode temp = new TreeNode(word);//creating new node
        if(treeList == null)//if if null add it to the current position
            treeList = temp;
        else 
        {
            TreeNode current = treeList;
            while(current!=null)
            {
                if(current.word.compareTo(word)>0)//less move to left
                    current = current.left;
                else//move to right
                    current = current.right;
            }
            current = temp;
        }
    }
    //adding method of the tree
    private TreeNode addBranch(String word,TreeNode root)
    {
        TreeNode temp = new TreeNode(word);//creating new node
        if(root == null)//if if null add it to the current position
            root = temp;
        else 
        {
            if(root.word.compareTo(word)>0)//less move to left
                root.left = addBranch(word,root.left);
            else//move to right
                root.right = addBranch(word,root.right);
        }
        return root;//return current root
    }
    
    //search method
    public void search(String word)
    {
        if(treeList==null)//if nothing is in the tree
            System.out.println("Nothing in the list");
        else 
        {
            boolean found = false;
            TreeNode current = treeList;//pointer of current position
            while(current != null && !found)
            {
                if(current.word.equals(word))//if matched
                {
                    found = true;
                }
                else if(current.word.compareTo(word)>0)//if less than current position
                {
                    current = current.left;
                }
                else
                {
                    current = current.right;
                }
            }
            if(found == true)//if found
                System.out.println(word+" is found");
            else
                System.out.println(word+" is not found");
        }
    }
    
    //toString method called by driver
    public String toString()
    {
        String result = getWord(treeList);
        return result;
    }
    //real method getting the tree in alphabetical order
    private String getWord(TreeNode current)
    {
        String result = "";
        if(current==null)//if it's the end
            return "\n";
        else//if it's not the end the the current string is its left part and itself and its right part
            return getWord(current.left)+current.word+getWord(current.right);
    }
    
    
    public static void main (String[]args)
    {
        try
        {
            //instance variables and objects
            Scanner fileScan = new Scanner(new File("words.txt"));
            Scanner keyboard = new Scanner(System.in);
            StringTree tree = new StringTree();
            String word;
            int count = 0;
            
            //adding words
            while(fileScan.hasNext())
            {
                String newWord = fileScan.nextLine();
                tree.add(newWord);
            }
            
            //print out the tree
            System.out.println(tree);
            
            //prompt the user for searching 
            do
            {
                System.out.println("Please enter the word you wish to found (enter \"ZZZ\" to quit) :");
                word = keyboard.nextLine().toLowerCase();
                if(!word.equals("zzz"))
                    tree.search(word);
            }
            while(!word.equals("zzz"));//while not entering "zzz"
            System.out.println("See you soon");
        }
        catch(IOException e)
        {
            System.out.println("No file found.");
        }
    }
    
    //creating binary tree node
    private class TreeNode
    {
        public String word;
        public TreeNode left,right;
        public TreeNode(String word)
        {
            this.word = word;
            left = null;
            right = null;
        }
        public String toString()
        {
            return word;
        }
    }
}
