/******************************************************************************
 * Name: Colin Bumpass, CSC 220
 * Date: November 8, 2021
 * Desc: Program 8. Creates arrays and sorts them according to their classes. 
 * Also creates a very large array and displays the time it took to sort it. 
 * I do believe the times are incorrect. 
 *****************************************************************************/

// import the random library 
import java.util.Random;

public class Main {
    public static void main(String args []){
        // Declare and initialize an array with space for 20 integers
        int[] array0 = new int [20];
        // Declare and initialize an empty list for printing the oringal array later
        String originalList = "";

        // Fill up Original array, which will be used for sorting methods
        for(int i = 0; i < array0.length; i++){
            Random rand = new Random();
            // Generates a random number between 0 to 150 
            int randint = rand.nextInt(150+1);
            // Add random value to an index
            array0[i] = randint;
            // Add each value of the array to a string for printing later
            originalList += (array0[i] + " ");
        }

        //-------[ COCKTAIL SORT ]-------
        // copy original array for Cocktail Sort
        int[] array1 = array0;
        // create instance of the Cocktail class
        Cocktail cocktailed = new Cocktail(array1);
        // call the cocktail sort function 
        cocktailed.cocktailsort(array1);
        // create an empty string
        String cocktailSortResult = "";
        // add each sorted value into the string 
        for(int i = 0; i < array1.length; i++){
            cocktailSortResult += (array1[i] + " ");
        }
        
        //-------[ QUICK SORT ]-------
        // Declare and initialize array2 for Quick Sort 
        int[] array2  = array0;
        // Declare and initialize a new instance of the Quick class, using array2 as parameter
        Quick quicken = new Quick(array2);
        // Call the quicksort function of the Quick class with the appropriate array and its bounds
        quicken.quicksort(array2, 0, array2.length -1);
        // Declare and initialize an empty string 
        String quickSortResult = "";
        // After Quick Sort is done, add each value to the string 
        for(int i = 0; i < array2.length; i++){
            quickSortResult += (array2[i] + " ");
        }

        //-------[ COUNTING SORT ]-------
        // Declare and initialize array3 for Counting Sort
        int[] array3 = array0;
        // create an instance of the counting class
        Counting counted = new Counting(array3);
        // call the counting sort function
        counted.countingSort(array3);
        // create an empty string 
        String countingSortResult = "";
        // add each value to the string 
        for (int i = 0; i< array3.length;i++){
            countingSortResult += (array3[i] + " ");
        }
        

        //-------[ PRINTING THE OUTPUT ]-------
        System.out.println("TESTING WITH n = 20");
        System.out.println("    Original List: " + originalList);
        System.out.println("    Cocktail sorted: " + cocktailSortResult);
        System.out.println("    Quick    sorted: " + quickSortResult);
        System.out.println("    Counting sorted: " + countingSortResult);

        //-------[ THE BIG ARRAY ]-------
        // Declare and initialize an array with space for 20 integers
        int[] arrayBig = new int [20000];

        // Fill up 20,000 array, which will be sorted and timed
        for(int i = 0; i < arrayBig.length; i++){
            Random rand = new Random();
            // Generates a random number between 0 to 150 
            int randint = rand.nextInt(150+1);
            // Add random value to an index
            arrayBig[i] = randint;
            // Add each value of the array to a string for printing later
            originalList += (arrayBig[i] + " ");
        }

        //-------[ COCKTAIL SORT ]-------
        // copy big array
        int[] array4 = arrayBig;
        // create a new instance of the cocktail class
        Cocktail cocktailed2 = new Cocktail(array4);
        // record the start time in nanoseconds 
        long cocktailStart = System.nanoTime();
        // sort the big array
        cocktailed2.cocktailsort(array4);
        // record the end time in nanoseconds
        long cocktailEnd = System.nanoTime();
        // subtract the start time by the end time and divide by a million to get milliseconds
        long cocktailDuration = (cocktailEnd - cocktailStart)/1_000_000;
        
        //-------[ QUICK SORT ]-------
        int[] array5  = arrayBig;
        Quick quicken2 = new Quick(array5);
        long quickStart = System.nanoTime();
        quicken2.quicksort(array5, 0, array5.length -1);
        long quickEnd = System.nanoTime();
        long quickDuration = (quickEnd - quickStart)/1_000_000;

        //-------[ COUNTING SORT ]-------
        // Declare and initialize array3 for Counting Sort
        int[] array6 = arrayBig;
        Counting counted2 = new Counting(array6);
        long countingStart = System.nanoTime();
        counted2.countingSort(array6);
        long countingEnd = System.nanoTime();
        long countingDuration = (countingEnd - countingStart)/1_000_000;
        

        System.out.println("TESTING with n = 20000");
        // absolutely no idea why thse values are so incorrect 
        System.out.println("Cocktail took " + cocktailDuration + " ms");
        System.out.println("Quick took " + quickDuration + " ms");
        System.out.println("Counting took " + countingDuration + " ms");


    }
    
}
