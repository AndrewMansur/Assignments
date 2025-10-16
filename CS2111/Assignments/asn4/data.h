// CS2211a 2023, Section 1
// Assignment 4
// Andrew Mansur
// amansur7
// November 14 2023

#ifndef DATA_H
#define DATA_H

typedef struct {
    char *name;
    int num;
} Key;

typedef struct {
    Key key;
    int data;
} Node;

Key key_construct(char *in_name, int in_num);
int key_comp(Key key1, Key key2);
void print_key(Key key);
void print_node(Node node);

#endif

