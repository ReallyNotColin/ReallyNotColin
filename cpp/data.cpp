/**********************************************************************
* Name: Colin Bumpass
* Desc: Create a function that goes over common data types in cpp
***********************************************************************/
#include <iostream>

using namespace std;

int main(){

    // general format: data_type variable_name = variable_value
    // Data types and variables: 
    int a = 69; 
    double b = 4.20; 
    float bb = 4.20;
    char c = 'z';
    string d = "Hello, World!";
    bool e = true;

    // Like C, you can declare a variable, but not initialize it 'til later:
    int f;
    f = 3;

    cout << "a = " << a << endl;
    cout << "b = " << b << endl;
    cout << "c = " << c << endl;
    cout << "d = " << d << endl;
    cout << "e = " << e << endl;
    cout << "f = " << f << endl;

    int sum = a + f;

    cout << "sum of a and f = " << sum << endl;

    // can declare and initialize together 
    int g,h,i;
    g=h=i=20;
    cout << g + h + i << endl;

    int j = 1, k = 1, l = 0;
    cout << j + k + l << endl;
    
    // create a constant variable that cannot be modified 
    const int m = 12;

    return 0;
}

/*
IMPORTANT: tried to name the function something other than "main" but c++ 
           wouldn't have it.
boolean: 1 byte
char:    1 byte
int:     2 or 4 bytes (-32767 to 32767 is 2 bytes) (anything else is 4 on a 32-bit system)
float:   4 bytes
double:  8 bytes
*/