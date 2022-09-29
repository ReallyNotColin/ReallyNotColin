/**
 * @file q1.c
 * @author Colin Bumpass, CSC 222 - 003
 * @brief Write a C function with the following signature: 
 *        int * generateRand( unsigned n, unsigned max) ; This function generates
 *        n random numbers between 1 and max, stores the numbers in an array and
 *        returns a pointer to the generated random numbers. Write a main function to
 *        test your function. The arguments n and max of the function should be passed
 *        through the command line. 
 * @version 0.1
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <stdio.h> //imports printf 
#include <stdlib.h> // imports atoi, srand

int *generateRand(unsigned n, unsigned max){
    int i;
    int *r = (int *)malloc(n*sizeof(int));
    for( i = 0; i < n ; i++){
        r[i] = (int)(rand() % max)+1;
    }

    return r;

}

int main (int argc, char *argv[]){

    if (argc < 3){
        printf("Not enough arguments. Please execute with amount of generates numbers and their max\n");
    }

    if (argc == 3){
        unsigned int n = atoi(argv[1]);
        unsigned int max = atoi(argv[2]);

        int *pointer = generateRand(n,max);
        for( int i = 0; i < n; i++){
            printf("%d\n", pointer[i]);
        }
    }

    
    return 0;
}