#include <stdio.h>

// recursive function to calculate power of two
unsigned long powerOfTwo(int exponent) {
    
    // escape case
    if (exponent == 0) {
        return 1;
    //checking if the exponent is divisible by 2
    } else if (exponent % 2 == 0) {
        unsigned long tempExp = powerOfTwo(exponent / 2);
        return tempExp * tempExp;
    //checking if remainder is 1 after being divided by 2
    } else {
        unsigned long tempExp = powerOfTwo((exponent - 1) / 2);
        return tempExp * tempExp * 2;
    }
}

int main() {
    int exponent;

    // Iterating until user enters 0
    while (1) {
        // Prompting user input
        printf("enter the exponent: ");
        scanf("%d", &exponent);

        // If user enters 0, the final answer will be 1
        if (exponent == 0) {
            printf("2^0 = 1\n");
            break;
        }
    
        // Callinf the powerOfTwo function with the exponent input
        unsigned long answer = powerOfTwo(exponent);
        printf("2^%d = %lu\n", exponent, answer);
    }

    return 0;
}



