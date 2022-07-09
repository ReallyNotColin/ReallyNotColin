/**********************************************************************
* Name: Colin Bumpass
* Desc: Learn c++ (cpp). This file will cover syntax and how to compile
*       and create cpp files.
***********************************************************************/
// Like C but with OOP (Classes, Objects, etc)

// Library for input/output objects
#include <iostream>

int main(){

    std::cout << "Hello, World!" << std::endl;
    // std = standard (scope). without it, cout would try to be global
    /*       Additionally, you could've entered "using namespace std;"
             after importing the iostream library to omit the "std::" and "<< endl;"
             SHOWN IN helloworld2.cpp
    */
    // cout =  object of class ostream
    // << = insert operator 
    // endl = "end line", makes a new line

    return 0;
} // end of main function

/*
To compile and run this code on Windows, we needed a third-party compiler called 
MinGW. We installed it, added it to the Windows System's PATH environment, and
now we can use it here. 

To compile this code, save it. Then, find the triangular play button at the top right.
The arrow next to it will show the "Run Code" option, which will create an executable
of the c++ file. 

Alternatively, you can type in the terminal: g++ helloworld.cpp to generate the exe file.
To run the exe file, type: ./a.exe or maybe ./helloworld.exe. This is the way.
*/