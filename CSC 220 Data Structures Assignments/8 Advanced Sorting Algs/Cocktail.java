public class Cocktail {
    // Declare an array of integers called "list" for a list of values
    int[] list;
    // Declare an integer n, which will represent the list of values' length
    int n;
    // Declare a boolean variable to tell if any value swaps have been made
    boolean anySwapsMade;
    
    // constructor 
    public Cocktail(int[] someArray){
        // Initialize fields
        list = someArray;
        n = someArray.length;
    }

    // Takes in a list of values as an array and sorts them
    public void cocktailsort(int[] list){
            
        for(int i = 1; i < ((n-1)/2+ 1); i++){
            // forward direction
            anySwapsMade = false;
            for(int j = i; j < (n-i); j++){
                if(list[j] < list[j-1]){
                int duplicate = list[j];
                list[j] = list[j-1];
                list[j -1] = duplicate;
                anySwapsMade = true;
                } 
            }
            if (anySwapsMade = false){
                break;
            }
            
            // backward direction
            anySwapsMade = false;
            for(int j = (n-i); j > (i-1); j--){
                if(list[j] < list[j-1]){
                    
                    int duplicate = list[j];
                    list[j] = list[j-1];
                    list[j-1] = duplicate;
                    anySwapsMade = true;
                }
            }
            if(anySwapsMade = false){
                break;
            }
        }
    }
}
