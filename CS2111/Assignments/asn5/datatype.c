// Cs2211a 2023, section 1
// Assignment 5
// Andrew Mansur
// 251302251
// amansur7
// 2023-12-06


#include "datatype.h"
#include<stdio.h>

// Create and initialize a key with dynamic memory allocation.
Key key_ini() {
    Key new_key = (Key)malloc(sizeof(Key_struct));
    
    // Handle memory allocation errors
    if (new_key == NULL) {
	fprintf(stderr, "Memory allocation error.\n");
        return NULL; // Return NULL to indicate the error
    }

    // Initialize numbers of new key
    new_key->key1 = NULL;
    new_key->key2 = 0;
    return new_key;
}


void key_set(Key key, Key1 key1, Key2 key2) {
    if (key->key1) free(key->key1);
    key->key1 = strdup(key1);
    key->key2 = key2;
}

// Compares 2 keys
int key_comp(Key key1, Key key2) {

    // Compares the integer components
    if (key1->key2 != key2->key2) {
        int result = key1->key2 - key2->key2;
        return result;
    }

    // Compares the string components
    int str_cmp = strcmp(key1->key1, key2->key1);
    return str_cmp;
}

// prints key 1
void key_print1(Key key) {
    printf("%s %d\n", key->key1, key->key2);
}

// prints key 2
void key_print2(Key key) {
    printf("%d %s\n", key->key2, key->key1);
}

// Frees memory allocated for the key
void key_free(Key key) {
    if (key->key1) free(key->key1);
    free(key);
}

// creates and initiralizes data
Data data_ini() {
    Data new_data = (Data)malloc(sizeof(float));
    
    // Handle memory error
    if (new_data == NULL) {
        fprintf(stderr, "Memory allocation error.\n");
        return NULL; // Return NULL to indicate the error
    }
    *new_data = 0.0;
    return new_data;
}

// Asisns value of data with intdat
void data_set(Data data, float intdata) {
    if (data != NULL) {
        *data = intdata;
    }
}

// prints data
void data_print(Data data) {
    if (data) printf("%f\n", *data);
}

// frees data
void data_free(Data data) {
    free(data);
}

