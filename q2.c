#include <stdio.h> 
#include <stdlib.h> 
#include <sys/wait.h> 
#include <unistd.h> 
#include <limits.h>
#include <time.h>
#include <string.h>
#include <stdlib.h>

int main (int argc, char* argv[]){

    if (argc < 3){
        printf("Usage: ./q2 <num_proc> <executable> \n");
        printf("e.g., ./q2 2 ./q1 \n");
    }

    else{
        for(int i = 0; i < strtol(argv[1], NULL, 10) ; i++){
            pid_t pid = fork();

            if (pid == 0){
                srand(time(NULL));
                int r = (rand() % (10 - 1)+1);
                char string[20];
                (sprintf(string, "%d", r));
                char* target = strdup(string);
                printf("The random number generated is: %s \n", target);
                
                // Argument not passed through correctly 
                char *arguments[] = {target, NULL};
                if (execvp(argv[2], arguments)==0){
                    printf("In child %d: ",getpid());
                    (execvp(argv[2],arguments));
                    exit(0);
                }

                else{
                    exit(1);
                }
            }
            int status;
            waitpid(pid, &status, 0);
            
        }
        
    }
}