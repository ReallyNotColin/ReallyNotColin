public class Quick {
    // Declare an array called list for "list of values"
    int[] list;
    

    // Constructor
    public Quick(int[] array){
        // Initialize list the list array with the given array 
        list = array;
    }


    
    // Takes in the given list of values as an array as well as the array's 
    // upper and lower bounds (first and last indices).
    // Sorts the list of values in quicksort fashion
    public void quicksort(int[] list, int left, int right){
        //-----DEBUGGING STATEMENT-----
        // Used to determine values in the "list"
        // Understand this will print 2 more times since it's called twice
            for(int i = 0; i < list.length; i++){
               Debug.print(list[i] + " ");
            }

        // If left value is less than right value
        if(left < right){
            // Set the partition to a value 
            int p = partition(list, left, right);
            // sublists
            quicksort(list, left, p - 1);
            quicksort(list, p + 1, right);
        }

    }

    // function to create a partition value
    public int partition(int[] list, int left, int right){
        // We choose the left index to be the pivot
        int pivotPos = left;
        // Move the left index over one to make room for the pivot
        left = left + 1;
        // While true
        while(true){
            // while the left index is inbounds and the value at left index < value at pivot index
            while (left < list.length-1 && list[left] < list[pivotPos]){
                // Move it over one 
                left = left + 1;
            }
            // While the right value is greater than the pivot and is greater than or equal to 0
            while(right >=0 && list[right] > list[pivotPos]){
                // Move the right from the end of the list  
                right = right -1;
            }
            // If the left value is greater than or equal to the right
            if (left >= right){
                // End the partition function
                break;
            }
            // Otherwise 
            else{
                // Swap left and right values 
                int duplicate = list[left];
                list[left] = list[right];
                list[right] = duplicate;
                // move left over one 
                left = left + 1;
                // move right from the end of the list 
                right = right -1;
            }
        }
        // Swap right and pivot values 
        int newval = list[right];
        list[right] = list[pivotPos];
        list[pivotPos] = newval;
        // Return right index
        return right;
    }
}

