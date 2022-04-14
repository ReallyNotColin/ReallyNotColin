/******************************************************************************
 * @file tokenizer.c
 * @author Colin Bumpass, CSC 222 - 003
 * @date January 13, 2022
 * @brief Program 1 Question 2: Ask user for input until "exit" is typed. The
 * user's inputs are then separated into tokens. 
 * 
 *****************************************************************************/

#include <stdio.h> // imports basic text I think
#include <string.h> // imports strcomp function

// Main function
int main(){
    
    char str[256]; // Char array (string) for user input
    char exitStr[256] = {'e','x','i','t','\0'}; // "exit"
    int comp; // compares strings, returns a number using strcmp
    char b[2] = " "; // the character that, if found, creates a token
    char *token; // will point towards a collection of characters before a buffer (b)
    int counter; // counter of tokens, increases by 1 after each token is found
    
    // Prompt for user input using fgets(string, char limit, input)
    printf("$ "); 
    fgets(str, 256, stdin);
    
    // Assign an integer value to comp using strcomp to compare user input and "exit"
    comp = strcmp(str,exitStr);
    
    token = strtok(str, b);

    // if user input is "exit" comp will be 10, so loop until comp == 10
    while(comp != 10){
        // Display text
        printf("Line read: %s\n",str);
        printf("Token(s): \n");

        // check if user input message has ended
        while(token != NULL){
            printf(" %s\n",token); // print token
            token = strtok(NULL, b); // set that token to null
            counter += 1; // increment counter
        }
        
        // Print out final text
        printf("%d token(s) read \n", counter);
        // Reset Counter
        counter = 0;
        
        // Prompt for user input again
        printf("$ ");
        fgets(str, 256, stdin);
        comp = strcmp(str,exitStr);
        token = strtok(str, b);
    }
     

    // End of Function
    return 0;
}