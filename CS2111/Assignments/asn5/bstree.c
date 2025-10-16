// Cs2211a 2023, section 1
// Assignment 5
// Andrew Mansur
// 251302251
// amansur7
// 2023-12-06

#include "bstree.h"
#include<stdio.h>

// Allocate memory of type BStree node
BStree bstree_ini(void) {
    BStree bst = (BStree)malloc(sizeof(BStree_node*));
    *bst = NULL;
    return bst;
}

// creates a new node 
static BStree_node *new_node(Key key, Data data) {
    BStree_node *node = (BStree_node *)malloc(sizeof(BStree_node));
    
    // handling error
    if (node == NULL) {
	fprintf(stderr, "Error: Unable to allocate memory for Key.\n");
        return NULL;
    }

    // creating new node and setting ppointers
    node->key = key;
    node->data = data;
    node->left = NULL;
    node->right = NULL;
    return node;
}

// Inserts data with key and into bst
void bstree_insert(BStree bst, Key key, Data data) {

    // if its empty
    if (bst == NULL || *bst == NULL) {
        *bst = new_node(key, data);
        return;
    }

    // Checking if the key is smaller than 0
    if (key_comp(key, (*bst)->key) < 0) {
        bstree_insert(&((*bst)->left), key, data);
    } 
    // Checking if the key is bigger than 0
    else if (key_comp(key, (*bst)->key) > 0) {
        bstree_insert(&((*bst)->right), key, data);
    }
}

// Assuming other parts of bstree.c are unchanged
Data bstree_search(BStree bst, Key key) {
    // If its empty	
    if (bst == NULL || *bst == NULL) {
        return NULL;
    }

    // Comparing
    int comp_result = key_comp(key, (*bst)->key);

    // if result is 0
    if (comp_result == 0) {
        return (*bst)->data;
    } 
    // if its smaller than 0
    else if (comp_result < 0) {
        return bstree_search(&((*bst)->left), key);
    } else {
        return bstree_search(&((*bst)->right), key);
    }

    return NULL; // Added return statement
}


// Traversing the tree
void bstree_traverse(BStree bst) {
    // If the tree is empty
    if (bst == NULL || *bst == NULL) {
        return;
    }

    // Traverse left subtree
    bstree_traverse(&((*bst)->left)); 
    // Print key and data
    printf("%d %s %d\n", (*bst)->key->key2, (*bst)->key->key1, (int)*((*bst)->data));
    // traverse right subtree
    bstree_traverse(&((*bst)->right)); 

}

// Free all dynamic allocated from bst
void bstree_free(BStree bst) {
    // If empoty
    if (bst == NULL || *bst == NULL) {
        return;
    }

    // free left and right subtree
    bstree_free(&((*bst)->left)); 
    bstree_free(&((*bst)->right)); 

    // Free the current node key
    key_free((*bst)->key);
    data_free((*bst)->data);

    // Free the node
    free(*bst);
    *bst = NULL;
}

