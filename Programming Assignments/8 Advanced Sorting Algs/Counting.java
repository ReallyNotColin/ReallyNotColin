public class Counting{
    // Initialize fields
    int[] list;
    int n;

    // constructor
    public Counting(int[] someArray){
        list = someArray;
        n = list.length;
    }

    // Takes in an array and sorts its values
    public void countingSort(int[] list){
        // Declare and initialize a max value (set to array[0] by default)
        int max = list[0];  
        
        // Find the actual maximum value in the given array
        for(int i = 0; i < list.length; i++){
            if(list[i] > max){
                max = list[i];
            }
        }

        // Allocate the count array and initialize to all zeros
        int[] count = new int[max + 1];
        for(int i = 0; i < count.length; i++){
            count[i] = 0;
        }


        // Calculate the histogram of key frequences
        for(int i = 0; i < n; i ++){
            count[list[i]] = count[list[i]] + 1;
        }

        // Calculate the starting index for each key 
        int total = 0;
        for(int i = 0; i < count.length; i++){
            int oldCount = count[i];
            count[i] = total;
            total = total + oldCount;
        }

        // Allocate the output array
        int[] output = new int [n];

        // Copy to output array, leeping order of inputs with equal keys (aka stable sort)
        for(int i=0; i< n; i++){
            int value = list[i];
            output[count[value]] = value;
            count[value] = count[value] + 1;
        }

        // copy back to original list
        for(int i = 0; i < n; i++){
            list[i] = output[i];
        }
    }
    
}