#include <stdio.h>

// Creating the 3 dimensional array of seven segment numbers
const char segments[10][3][3] = {
    { {' ', '_', ' '}, {'|', ' ', '|'}, {'|', '_', '|'} },  
    { {' ', ' ', ' '}, {' ', '|', ' '}, {' ', '|', ' '} }, 
    { {' ', '_', ' '}, {' ', '_', '|'}, {'|', '_', ' '} }, 
    { {' ', '_', ' '}, {' ', '_', '|'}, {' ', '_', '|'} }, 
    { {' ', ' ', ' '}, {'|', '_', '|'}, {' ', '|', ' '} },  
    { {' ', '_', ' '}, {'|', '_', ' '}, {' ', '_', '|'} },  
    { {' ', '_', ' '}, {'|', '_', ' '}, {'|', '_', '|'} },  
    { {' ', '_', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'} },  
    { {' ', '_', ' '}, {'|', '_', '|'}, {'|', '_', '|'} },  
    { {' ', '_', ' '}, {'|', '_', '|'}, {' ', '_', '|'} }   
};

int main() {
    // declaring variables
    int num;
    char again = 'y';  

    while (again == 'Y' || again == 'y') {
        int digits[10];
        int count = 0;  

        // getting user input and checking if the number is negative
        printf("Enter an integer: ");
        scanf("%d", &num);

        if (num < 0) {
            printf("negative number\n");
            num = -num;
        }

        // Extract individual digits from the number
        while (num) {
            digits[count++] = num % 10;
            num /= 10;
        }

        // iterating through the array
        for (int i = 0; i < 3; i++) {
            for (int j = count - 1; j >= 0; j--) {
                for (int z = 0; z < 3; z++) {
                    printf("%c", segments[digits[j]][i][z]);
                }
                printf(" ");
            }
            printf("\n");
        }

        printf("Do you want to continue? (Y/N): ");
        scanf(" %c", &again);
        getchar();  // Consume the newline left by scanf
    } 

    return 0;
}
