/**********************************************************************
* Name: Colin Bumpass
* Desc: Import the cmath header file and learn the functions. Could come
*       in handy.
***********************************************************************/
// header files, not libraries
#include <iostream> 
#include <cmath>
using namespace std;

int main(){
    //tried with more than two values, it doesn't like it 
    cout << max(5,19) << endl; // prints the maximum value of the two numbers, 19
    cout << min (2,18) << endl; // prints the minimum value of the two numbers, 2

    // cmath
    cout << sqrt(64) << endl; // prints the square root of a number
    cout << sqrt(31) << endl; // prints the approximate square root of a number
    cout << round(2.69) << endl; // rounds to the nearest whole number
    cout << ceil(2.69) << endl; // ceil rounds to the nearest whole number
    cout << log(2) << endl; // returns logarithmic value of 2
    return 0;
} // end of main function

/*
The cmath header includes:
abs(x)      Returns the absolute value of x
acos(x)	    Returns the arccosine of x
asin(x)	    Returns the arcsine of x
atan(x) 	Returns the arctangent of x
cbrt(x)	    Returns the cube root of x
ceil(x)	    Returns the value of x rounded up to its nearest (whole) integer
cos(x)	    Returns the cosine of x
cosh(x)	    Returns the hyperbolic cosine of x
exp(x)	    Returns the value of Ex
expm1(x)	Returns ex -1
fabs(x)	    Returns the absolute value of a floating x
fdim(x, y)	Returns the positive difference between x and y
floor(x)	Returns the value of x rounded down to its nearest integer
hypot(x, y)	    Returns sqrt(x2 +y2) without intermediate overflow or underflow
fma(x, y, z)	Returns x*y+z without losing precision
fmax(x, y)	    Returns the highest value of a floating x and y
fmin(x, y)	    Returns the lowest value of a floating x and y
fmod(x, y)	    Returns the floating point remainder of x/y
pow(x, y)	    Returns the value of x to the power of y
sin(x)	    Returns the sine of x (x is in radians)
sinh(x)	    Returns the hyperbolic sine of a double value
tan(x)	    Returns the tangent of an angle
tanh(x)	    Returns the hyperbolic tangent of a double value	
*/











