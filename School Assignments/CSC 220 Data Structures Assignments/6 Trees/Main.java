/******************************************************************************
 * Name: Colin Bumpass, CSC 220 - 003
 * Date: October 25, 2021
 * Desc: Program 6: Binary Search Tree. The Main.java file, when run, displays
 *       an empty binary search tree for one to insert, search for, and delete
 *       numbers, as well as find the minimum and maximum numbers within the 
 *       tree in addition to printing the values in a certain order. 
 *       As of this time, the delete function doesn't work. 
 *****************************************************************************/


// Main entry point
public class Main {
    public static void main(String [] args){
        // Create instance of a binary tree
        BST tree = new BST();
        
        // If not running on Windows, change to false
        // before running program
        Vis.runOnWindows = true;
        // Display the binary search tree 
        Vis.test(tree);
    }
}
