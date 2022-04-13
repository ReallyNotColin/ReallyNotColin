/*
Name: Colin Bunpass, CSC 222 - 003 
Date: January 27, 2022
Desc: Program 2: A child process displays working directory and changes
       directory based off the second command line arguement. 
       Ex) ./prog2 /root      "./prog2" is the program name and "/root" is 
       the directory it's changing to. Parent process displays exit status
       of the child process: 1 if failure, 0 if success.
*/

#include <stdio.h> 
#include <stdlib.h> 
#include <sys/wait.h> 
#include <unistd.h> 
#include <limits.h>

// Main function 
// argc: Tracks number of command line arguments 
// argc[]: Character array that contains command line arguements 
int main(int argc, char* argv[]){
    // character array for current working directory 
    char cwd[PATH_MAX];
    // 
    pid_t pid = fork();

    // Child process: 
    // - Displays Current Directory 
    // - Attempts to change directory 
    // -Exits with either exit(0) or exit(1)
    if (pid == 0){
        // Display the Current Working Directory, change it, list contents
        if (getcwd(cwd, sizeof(cwd)) != NULL){
            printf("Current working directory: %s \n", cwd);
            printf("Executing ls %s --all -l --human-readable \n", argv[1]);
            // Change directory. If failure, exit with status 1
            if (chdir(argv[1]) != 0){
                printf("Can't chdir to %s \n", (argv[1]));
                exit(1);
            }
            // List the contents of that directory using required parameters 
            execl("/bin/ls", "ls", cwd, "--all", "-l", "--human-readable", NULL);
            // A print statement won't work here because execl creates new instance image 
            exit(0);
        }
        // If child process fails, exit with status 1 
        else{
            exit(1);
        }
    }
    // If child process fails, exit with status 1
    if (pid < 0){
        exit(1);
    }

   // Parent Process
   // - Displays Exit Status of child 
   int status;
   // Wait on child process, reap when finished 
   waitpid(pid, &status, 0);
   // Get status
   if( WIFEXITED(status)){
       int exit_status = WEXITSTATUS(status);
       printf("Exit status: %d \n", exit_status);
   }

   // EXIT MAIN FUNCTION 
   return 0;
}