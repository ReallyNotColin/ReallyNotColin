/******************************************************************************
 * Name: Colin Bumpass, CSC 220 - 003 
 * Data: November 15, 2021
 * Desc: Program 9: Dictionaries. Creates a dictionary of employees and their 
 * annual salaries as keyvalue pairs. Contains basic functions to delete and 
 * search for an employee's salary.
 *****************************************************************************/

public class Main {
    public static void main(String args[]){
        // creates new dictionary object
        Dictionary<String, Integer> dict = new Dictionary<String, Integer>();

        // maps keys to the appropriate buckets
        dict.insert("Bob", 50);
        dict.insert("Bill", 120);
        dict.insert("Roger", 80);
        dict.insert("Kevin", 350);
        dict.insert("Jerry", 65);
        dict.insert("Liam", 500);
        
        // search for the values 
        System.out.println("Bob makes $" + dict.search("Bob") +"k a year");
        System.out.println("Bill makes $" + dict.search("Bill") +"k a year");
        System.out.println("Roger makes $" + dict.search("Roger") +"k a year");
        System.out.println("Kevin makes $" + dict.search("Kevin") +"k a year");
        System.out.println("Jerry makes $" + dict.search("Jerry") +"k a year");
        System.out.println("Liam makes $" + dict.search("Liam") +"k a year");
        
        // delete items from dictionary
        dict.delete("Bob");
        dict.delete("Roger");
        dict.delete("Jerry");
        // insert duplicate key into dictionary
        dict.insert("Liam", 650);
        // empty line 
        System.out.println();

        // Check and see if any items were removed from dictionary
        if(dict.search("Bob") == null){
            System.out.println("Bob got fired");
        }
        else if (dict.search("Bob") != null){
            System.out.println("Bob makes $" + dict.search("Bob") +"k a year");
        }

        if(dict.search("Bill") == null){
            System.out.println("Bill got fired");
        }
        else if (dict.search("Bill") != null){
            System.out.println("Bill makes $" + dict.search("Bill") +"k a year");
        }

        if(dict.search("Roger") == null){
            System.out.println("Roger got fired");
        }
        else if (dict.search("Roger") != null){
            System.out.println("Roger makes $" + dict.search("Roger") +"k a year");
        }

        if(dict.search("Kevin") == null){
            System.out.println("Kevin got fired");
        }
        else if (dict.search("Kevin") != null){
            System.out.println("Kevin makes $" + dict.search("Kevin") +"k a year");
        }

        if(dict.search("Jerry") == null){
            System.out.println("Jerry got fired");
        }
        else if (dict.search("Jerry") != null){
            System.out.println("Jerry makes $" + dict.search("Jerry") +"k a year");
        }

        if(dict.search("Liam") == null){
            System.out.println("Liam got fired");
        }
        else if (dict.search("Liam") != null){
            System.out.println("Liam makes $" + dict.search("Liam") +"k a year");
        }

    

    }// end of main entry point
} // end of Main class
