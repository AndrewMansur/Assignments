// Defining derectives
#include "data.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// creating a key  object
Key key_construct(char *in_name, int in_num) {
   
    // allocate memory for the name
    Key key;
    key.name = malloc(strlen(in_name) + 1);
    strcpy(key.name, in_name);
    // setting the keys number to the user inputted number
    key.num = in_num;
    return key;
}

// function to compare two key objects
int key_comp(Key key1, Key key2) {
    int string_comp = strcmp(key1.name, key2.name);

    // checking if the names are equal
    if (string_comp == 0) {
        return key1.num - key2.num;
    }
    return string_comp;
}

// function to print the key object
void print_key(Key key) {
    printf("%d %s", key.num, key.name);
}

// prints a node and node data
void print_node(Node node) {
    print_key(node.key);
    printf(" %d\n", node.data);
}

