/**********************************************************************
* Name: Colin Bumpass
* Desc: Create a function that takes in a vector of integers and returns the 
*	    absolute value of the sum of all of the integers in the vector
***********************************************************************/

// Vectors are like arrays but can change in size dynamically/as needed
#include <iostream>
#include <vector>

/*
The function below is used to find the absolute value and sum of all the 
integers within the integer vector named "arr"
*/
int getAbsSum(std::vector<int> arr) {
	int limit = arr.size(); // define the bound for the for loop
	int sum = 0;
	for(int i = 0; i < limit;i++){
		sum = sum + abs(arr.at(i)); // use the .at() function to access vector elements 
	}
	return sum; // return the sum
} // end of getAbsSum function

