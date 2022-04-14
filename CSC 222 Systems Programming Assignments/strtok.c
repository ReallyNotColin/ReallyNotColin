/**
 * @file strtok.c
 * @author Colin Bumpass, CSC 222 - 003
 * @brief A demo showcasing how strtok divides parts of a character array (string)
 * @version 0.1
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <string.h>
#include <stdio.h>

int main(){
    char str[80] = "This is a string"; // Message to parse
    const char buffer[2] = " "; // The buffer is a space
    char* token;

    // Get the first token
    token = strtok(str,buffer);

    //Now count other tokens
    while (token != NULL){
        printf(" %s \n", token);

        token = strtok(NULL,buffer);
    }
    return 0;
}