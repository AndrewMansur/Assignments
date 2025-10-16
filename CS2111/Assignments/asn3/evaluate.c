#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Pointer to work through the expression
char* input;

// returns the next operator int he expression
char get_op(void) {
    // Checknig if the next character is empty
    while (*input == ' ') {
        input++;
    }

    // checking if its an operator
    if (*input == '+' || *input == '-') {
        return *input++;
    
    // Checking if its the escape charactere
    } else if (*input == '\n' || *input == '\0') {
        return *input;
    }
    return '\0';  
}

// returns the next number in the expression
float get_num(void) {
    float num;
    if (sscanf(input, "%f", &num) != 1) {
        printf("Error: Invalid number input\n");
        exit(1);  
    }

    // chcking if character is valid
    while (*input && (*input == '.' || (*input >= '0' && *input <= '9'))) {
        input += 1;
    }
    return num;
}


// returns the value of the expression
float sub_sim_exp(float sub_exp) {
    // getting the next operator
    char nextOperator = get_op();

    // checking if the next operator 
    if (nextOperator == '\0' || nextOperator == '\n') {
        return sub_exp;
    } 
    else {
        // Going to net char until its not empty
        while (*input == ' ') {
            input++;
        }

        if (*input == '\0' || *input == '\n') {
            printf("You need to input a number after the operator\n");
            exit(1); 
        }
        float nextNumber = get_num();

        // creating the recursive function
        if (nextOperator == '+') {
            return sub_sim_exp(sub_exp + nextNumber);
        } else if (nextOperator == '-') {
            return sub_sim_exp(sub_exp - nextNumber);
        }
    }
    return 0;  
}

// returns the value of the expression
float sim_exp() {
    return sub_sim_exp(get_num());
}


int main(void) {
    char choice = 'y';

    // creating the empty expression
    char expression[256];

    // running until user doesnt do yes
    while (choice == 'Y' || choice == 'y') {
        printf("Enter a simple arithmetic expression: ");
        // reading the line
        fgets(expression, sizeof(expression), stdin);
        input = expression;  
        float answer = sim_exp();
        printf("The final answer is: %f\n", answer);
        printf("Do you want to continue? (Y/N): ");
        scanf(" %c", &choice);

        // reading the single char
        getchar();  
    } 

    return 0;
}

