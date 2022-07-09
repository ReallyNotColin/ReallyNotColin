/**********************************************************************
* Name: Colin Bumpass
* Desc: Create a function to concatonate, append, and access the 
*       individual characters within a string, in addition to obtaining
*       the string's length. 
***********************************************************************/

#include <iostream>
#include <string>

using namespace std;

int main(){

    // Concatonation
    string firstName = "Colin";
    string lastName = "Bumpass";
    string fullName = firstName + " " + lastName;
    cout << fullName;

    // Append
    fullName = firstName.append(lastName);
    cout << fullName << endl;

    // String Length
    string txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    cout << "\nThe length of txt is: " << txt.length() << endl;
    cout << "The length of txt is: " << txt.size() << endl;

    // Accessing Strings as character arrays
    string myString = "Morning";
    cout << myString[0] << endl; // print the first element in the string (character arrray)
    
    return 0;
} //end of main function