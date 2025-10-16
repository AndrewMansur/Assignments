// CS2211a 2023, Section 1
// Assignment 4
// Andrew Mansur
// amansur7
// November 14 2023

#ifndef BST_H
#define BST_H

#include "data.h"

typedef struct {
    Node *tree_nodes;
    unsigned char *is_free;
    int size;
} BStree;

BStree bstree_ini(int size);
void bstree_insert(BStree bst, Key key, int data);
void bstree_traversal(BStree bst);
void bstree_free(BStree bst);

#endif

