/**
 * @file q1.c
 * @author Colin Bumpass, CSC 222 - 003
 * @brief Write a C program q1.c that requests a nonnegative integer and returns 
 *        its binary representation. Define a function U2B that does the conversion.
 *        It should have the following signature: void U2B (unsigned long n).
 *        Assume they will not input 0.
 * @version 0.1
 * @date January 7, 2022
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <stdio.h> // imports printf,scanf

// Takes an unsigned long number and prints its binary equivalent
void U2B (unsigned long n){
    // Cast the parameter as an integer
    int num = (int) n;
        //printf("%d", num);
    // Create an empty array
    int a[10];
    // Declare integer variable (whose value will be change in for loops, but its value can be accessed outside the local scope)
    int i = 0;
    // Get the modulous (remainder) of the number and divide it until it is less than zero
    for(i=0; num>0; i++){
        a[i] = num%2;
        num = num/2;
        
    }

    printf("\nBinary equivalent: ");
    // Empty contents of array with no \n to separate the elements
    for(int j=i-1; j>=0; j--){
        printf("%d", a[j]);
    }
}

// Main function: 
// Asks for user input until user input is -1
// Calls U2B function
int main(){

    // Declare user variable and ask for user input
    int user;
    printf("Enter an integer (-1 to quit): \n");
    scanf("%d", &user);

    // 
    while(user != -1){
        // Declare variable userLong and cast the user variable as an unsigned long
        unsigned long userLong = (unsigned long)user;
        //printf("%lu", userLong); //%the letter l and u for "unsigned"
        U2B(userLong);
        printf("\nEnter an integer (-1 to quit): \n");
        scanf("%d", &user);

    }
    printf("Bye.\n");
    return 0;
}
