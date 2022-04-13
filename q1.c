#include <stdio.h>
#include <stdlib.h>
#include <math.h>


// pretty sure this is wrong
float SquareRoot(int a){

    float x0 = a/2;
    printf("The value of x0 is %.2lf \n", x0);
    float x1 = ((x0 + (a/x0))/2);
    printf("The value of x1 is %.2lf \n", x1);
    float r1 = (fabs(x0) - fabs(x1));
    printf("Result 1: %.2lf \n", r1);

    a++;

    float x3 = a/2;
    printf("The value of x0 is %.2lf \n", x3);
    float x4 = ((x3 + (a/x3)) /2);
    printf("The value of x1 is %.2lf \n", x4);
    float r2 = (fabs(x3) - fabs(x4));
    printf("Result 2: %.2lf \n", r2);

    while ((r1-r2-1) > .0001){
        printf("While loop \n");
        SquareRoot(a);
    }
    return x1;
}

int main(int argc, char* argv[]){

    printf("Number of arguments is %i \n", argc);
    printf("Argument at 1 is : %s \n", argv[1]);

    if (argc < 2){
        printf("Incorrect input \n");
    }
    else{
        SquareRoot(strtol(argv[1],NULL, 10));
    }
    return 0;
}