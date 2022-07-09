/**********************************************************************
* Name: Colin Bumpass
* Desc: Create functions for the main function to call. Each involves 
*       taking in user input, but differ in data type or the extent of 
*       how much of the user's input is recorded.
***********************************************************************/
#include <iostream>
#include <string> // allows string data types

using namespace std;

// This function asks for an integer and returns the integer (not idiot-proof yet)
void number(){
// cin takes numbers
    int x;
    cout << "Enter a number: " << endl;
    cin >> x;
} // end of number function

// This function asks for a string data type, but only initializes the first word
void firstName(){
    // cin considers whitespace/tabs as TERMINATING characters
    // it will only find one word
    string user;
    cout << "Enter your first name" << endl;
    cin >> user;
    cout << "Hello, " << user << endl;
} // end of firstName function

// This function asks for a string data type, and initializes more than one word
void fullName(){
    // For cin to take in more than one word, use getline(cin, input_variable)
    string fullName;
    cout << "Enter your full name" << endl;
    getline (cin, fullName);
    cout << "Hello, " << fullName << "!" << endl;
} /// end of fullName() function

// Main function calls all the above void functions 
int main(){
    number();
    firstName();
    fullName();
    return 0;
} // end of main function