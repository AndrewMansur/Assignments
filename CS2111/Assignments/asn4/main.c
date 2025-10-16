// CS2211a 2023, Section 1
// Assignment 4
// Andrew Mansur
// amansur7
// November 14 2023

// Defining Derectives
#include <stdio.h>
#include <string.h>
#include "bst.h"

int main(void) {
    // Prompting user to input the size of the array
    int size;
    printf("Enter the size of the tree node array: ");
    scanf("%d", &size);

    getchar();

    BStree bst;
    bst = bstree_ini(size);

    // Defining variables
    char str[100];
    int num;
    int data;

    while (1) {
	//Prompting user to enter the key
        printf("Enter key (number and name) or -1 to stop: ");
        scanf("%d", &num);

	// Checking if the user no no longer wants to input
        if (num == -1) {
            break;
        }

 
        getchar();

	// prompting user to input name
        printf("Enter name: ");
        fgets(str, sizeof(str), stdin);
        str[strcspn(str, "\n")] = 0;  // Remove newline character

        printf("Enter data: ");
        scanf("%d", &data);

        // Clear the buffer
        getchar();

        bstree_insert(bst, key_construct(str, num), data);
    }

    // Printinig the final tree traversal
    printf("BST Traversal:\n");
    bstree_traversal(bst);
    bstree_free(bst);

    return 0;
}

