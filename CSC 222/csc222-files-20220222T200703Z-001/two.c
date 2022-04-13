// Name Colin Bumpass CSC 222-003 
// Date Febuary 22, 2022
// Desc Final Exam Problem 2


#include <stdio.h>
#include <sys/wait.h> // waitpid()
#include <sys/types.h> // fork
#include <unistd.h> // fork
#include <stdlib.h> // system

int main(int argc, char* argv[]){

    if (argc < 3){
        printf("Usage: ./two <script> [dir1 [dir2]...] \n");
        printf("e.g., ./two one.sh . \n");
    }

    else{

        pid_t pid = fork();

        if (pid == 0){
            // run the script file? (it doesn't :( ))
            int s = system("./two one.sh csc222-files");
            exit(0);
        }
        else{
            exit(1);
        }



        int status;
        // Wait on child process, reap when finished 
        waitpid(pid, &status, 0);
    }

    return 0;
}