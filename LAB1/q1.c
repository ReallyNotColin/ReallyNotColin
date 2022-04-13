/**
 * @file q1.c
 * @author Colin Bumpass
 * @brief Lab 1, Question 1: Write a program that takes an array of integers
 *   size n and reverses the order of elements. A function void reverseOrder(int arr[], int n)
 *   should do the work. Write a main program to test your function.
 * @version 0.1 
 * @date 2022-01-06
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <stdio.h> // imports printf, scanf

// Function that prints the contents of the array
void printOrder (int array[], int size){
    for (int i = 0; i < size ; i++){
        printf("\n Array[%d] => %d", i, array[i]);
    }
}

// Function that prints the contents of the array in reverse
void reverseOrder(int array[], int size){
    for(int i = size-1; i > -1; i--){
        
        printf("\n Reversed Array[%d] => %d",i, array[i]);
    }
}

// Main function 
// Asks user for array size and elements, calls functions
int main(){
    // Ask user for array size (int userN)
    printf("Please enter an integer n length for the array: ");
    int userN;
    // change the value of userN
    scanf("%d", &userN); 
    // Create an array using the array size
    int array[userN];
    // Ask user for array's elements at specified indices
    for(int i = 0; i < userN ; i++){
        printf("Enter an integer to put in the array[%d]: ", i); 
        int num;
        scanf("%d", &num);
        array[i] = num;
    }

    // Calls the  void printOrder function, which simply prints the contents of the array
    printOrder(array, userN);
    
    // Calls the void reverseOrder function, which prints the contents of the array in reverse
    reverseOrder(array, userN);
    
    printf("\n");

    // End of main function
    return 0;
}


