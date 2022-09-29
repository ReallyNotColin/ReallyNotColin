/**
 * @file q2.c
 * @author Colin Bumpass, CSC 222 - 003
 * @brief Write a program q2.c that asks the user to enter the number of miles 
 *        traveled (as a float) and the number of gasoline consumed. Use constants.
 * @version 0.1
 * @date January 7, 2022
 * 
 * @copyright Copyright (c) 2022
 * 
*/
#include <stdio.h> // imports printf, scanf

// Main function:
// Asks for user input and converts
int main(){

    // Declare and initialize constants
    const float gal2Liter = 3.785; //litres
    const float mile2km= 1.609; //km

    // Declare variables for user input
    float miles;
    float gallons;

    // Ask for user input
    printf("Enter number of miles traveled: ");
    scanf("%f", &miles);
    printf("Enter number of gallons of gas used: ");
    scanf("%f", &gallons);

    // Calculate miles per gallon
    float mpg = (miles/gallons);
    printf("Mile-per-gallon: %.2f\n", mpg);

    // Calculate liters per 100 kilometers
    float lp100k = (235/mpg); 
    printf("Liters-per-100-km: %1f\n", lp100k);

    return 0;

}