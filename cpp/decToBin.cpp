/**********************************************************************
* Name: Colin Bumpass
* Desc: Create a function that when called, displays a decimal number's
*       equivalent binary value. 
***********************************************************************/

#include <iostream>

using namespace std;

void decimal_to_binary(int dec){
    int binaryNums[32];
    int i = 0;

    while (dec > 0){
        binaryNums[i] = dec % 2;
        dec = dec /2;
        i++;
        // if decimal number is 10, array will go like so:
        // 10 % 2 = 0
        // 5 % 2 = 1
        // 2 % 2 = 0
        // 1 % 2 = 1
    }
    // print the array from the last element to the first element 
    for(int k = i-1; k >=0; k--){
        cout << binaryNums[k];
    }
} // end of decimal_to_binary function

int main(){
    // Decimal value:
    int dec = 10;
    // Call the function to print binary value
    decimal_to_binary(10);
    return 0;
} //end of main function

