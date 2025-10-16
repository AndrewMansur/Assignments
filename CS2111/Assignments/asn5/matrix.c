// Cs2211a 2023, section 1
// Assignment 5
// Andrew Mansur
// 251302251
// amansur7
// 2023-12-06

#include "matrix.h"
#include<stdio.h>

//  contrcutcs maktrix
Matrix matrix_construction(void) {
    return bstree_ini();
}


unsigned char matrix_index_in(Matrix m, Index1 index1, Index2 index2) {
    // new key 
    Key key = key_ini();
    key_set(key, index1, index2);
    
    // search for key
    Data data = bstree_search(m, key);
    key_free(key);

    return data != NULL ? 1 : 0;
}


const Value *matrix_get(Matrix m, Index1 index1, Index2 index2) {
    // initialize key
    Key key = key_ini();
    key_set(key, index1, index2);
    Data data = bstree_search(m, key);
    key_free(key);

    // returns pointer value
    if (data) {
        return data; 
    } else {
        return NULL; 
    }
}

// sets matrix
void matrix_set(Matrix m, Index1 index1, Index2 index2, Value value) {
    // initialize key
    Key key = key_ini();
    key_set(key, index1, index2);

    Data existing_data = bstree_search(m, key);
    if (existing_data) {
   // Increment the count for key
        (*existing_data) += value;
    } else {
        // Insert  key with initial value
        Data new_data = data_ini();
        data_set(new_data, value);
        bstree_insert(m, key, new_data);
    }
}

// performs in order traversal
void in_order_traverse(BStree_node *node) {
    if (node != NULL) {
        in_order_traverse(node->left);
        printf("%d %s %d\n", node->key->key2, node->key->key1, (int)*(node->data));
        in_order_traverse(node->right);
    }
}

// proints indices and values in matrix m
void matrix_list(Matrix m) {
    if (m != NULL && *m != NULL) {
        in_order_traverse(*m);
    }
}

// free alocated space
void matrix_destruction(Matrix m) {
    bstree_free(m);
    free(m);
}
