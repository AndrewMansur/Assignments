// Cs2211a 2023, section 1
// Assignment 5
// Andrew Mansur
// 251302251
// amansur7
// 2023-12-06

#include "matrix.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// main function
int main() {
    // create new matrix
    Matrix m = matrix_construction();

    // initialize variables
    const int bufferSize = 100;
    char index1[bufferSize];  
    Index2 index2;           
    Value value;

    char inputLine[bufferSize];  


    while (fgets(inputLine, sizeof(inputLine), stdin)) {
 
        char* spacePtr = strchr(inputLine, ' ');
        if (spacePtr != NULL) {
	    // replace space with a null	
            *spacePtr = '\0';
            index2 = atoi(inputLine);
            strncpy(index1, spacePtr + 1, bufferSize - 1);
            index1[strcspn(index1, "\n")] = 0;  // Remove newline character

	    // get value from matrix
            const Value *existing_value = matrix_get(m, index1, index2);
            value = existing_value ? *existing_value + 1 : 1;
            matrix_set(m, index1, index2, value);
        } else {
        }
    }

    // print final result
    printf("Number Street Occurrence\n");
    bstree_traverse(m);
    matrix_destruction(m);

    return 0;
}

