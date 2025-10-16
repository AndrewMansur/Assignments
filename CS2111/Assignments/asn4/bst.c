// CS2211a 2023, Section 1
// Assignment 4
// Andrew Mansur
// amansur7
// November 14 2023

//Defining derectives
#include "bst.h"
#include <stdio.h>
#include <stdlib.h>


// creates a bbinary search tree method
BStree bstree_ini(int size) {
    BStree bst;
    bst.tree_nodes = (Node *)malloc((size + 1) * sizeof(Node));
    bst.is_free = (unsigned char *)malloc((size + 1) * sizeof(unsigned char));
   
    // making all spots empty at first
    for (int i = 0; i <= size; i++) {
        bst.is_free[i] = 1;
    }

    //creating the size of the tree
    bst.size = size;
    return bst;
}

// will hel with insertion
static void insert_recursive(Node *nodes, unsigned char *is_free, int size, int index, Key key, int data) {
    if (index > size) return;

    // check if sport at the index is free
    if (is_free[index]) {
        nodes[index].key = key;
        nodes[index].data = data;
        is_free[index] = 0;

    // if its not free
    } else {
        int cmp = key_comp(key, nodes[index].key);
        if (cmp < 0) {
	    // go to left child
            insert_recursive(nodes, is_free, size, 2 * index, key, data);
        } else if (cmp > 0) {
	    // go to right child
            insert_recursive(nodes, is_free, size, 2 * index + 1, key, data);
        }
    }
}

// inserts a key and data
void bstree_insert(BStree bst, Key key, int data) {
    insert_recursive(bst.tree_nodes, bst.is_free, bst.size, 1, key, data);
}

// helper for in order traversal
static void traversal_recursive(Node *nodes, unsigned char *is_free, int size, int index) {
    if (index <= size && !is_free[index]) {
        traversal_recursive(nodes, is_free, size, 2 * index);
        print_node(nodes[index]);
        traversal_recursive(nodes, is_free, size, 2 * index + 1);
    }
}

// does inorder traversal
void bstree_traversal(BStree bst) {
    traversal_recursive(bst.tree_nodes, bst.is_free, bst.size, 1);
}


void bstree_free(BStree bst) {
    for (int i = 0; i <= bst.size; i++) {
        if (!bst.is_free[i]) {
            free(bst.tree_nodes[i].key.name);
        }
    }
    free(bst.tree_nodes);
    free(bst.is_free);
}

