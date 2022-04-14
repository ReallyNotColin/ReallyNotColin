/**
 * @file malloc.c
 * @author Colin Bumpass
 * @brief This program works; displays malloc's functionality.
 * @version 0.1
 * @date 03-13-2022
 * 
 * 
 */

#include <stdio.h>
#include <stdlib.h> // malloc, realloc, free
#include <string.h> // strcpy

int main(){

    char *str;

    // Initial memory allocation  (Changes contents and address of str from nothing)
    str = (char*)malloc(15); // (cast type*) malloc(size_t size) - casts memory stored as a string with size of 15 characters
    strcpy(str,"tutorialspoint"); // strcpy(char *dest, const char *src) - copies a string into a destination
    printf("String = %s, Address = %p\n",str,str);

    // Reallocating memory (Changes conents and address of str)
    str = (char*) realloc(str,25);
    strcat(str,".com");
    printf("String = %s, Address = %p\n",str,str);

    // De-Allocates the memory used by str
    free(str);

    return 0;
}