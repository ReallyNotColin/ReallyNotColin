/**********************************************************************
* Name: Colin Bumpass
* Desc: Create if, if else, and else statements in cpp.
***********************************************************************/
#include <iostream>

using namespace std;

int main(){
    // Declare integer data type variables
    int first;
    int second;

    // Request user input to initialize the variables
    cout << "Enter first integer:" << endl;
    cin >> first;
    cout << "Enter second integer:" << endl;
    cin >> second;

    // Prints if the user input is greater than the second
    if (first < second){
        cout << "first is less than second" << endl;
    }

    // if first condition is false,
    else if (first > second){
        cout << "first is greater than second" << endl;
    }

    // If both conditions are false
    else{
        cout << "first is equal to second" << endl;
    }


    // Shorthand if statement that is very cool:
    // variable = (condition) ? expressionTrue : expressionFalse;
    int time = 20;
    string result = (time < 18) ? "Good day." : "Good evening.";
    cout << result << endl;

    return 0;
} // end of main function