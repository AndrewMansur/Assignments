// CS2211a 2023, Section 1
// Assignment 4
// Andrew Mansur
// amansur7
// November 14 2023


// defining directive
#include <stdio.h>


int main() {
    // Prompting user input
    double epsilon;
    printf("Enter a small number: ");
    scanf("%lf", &epsilon);

    // initial part of the series	
    double e = 1.0;
    long long factorial = 1;
    int n = 1;

    while (1) {
	// calculating the factorial
        factorial *= n; 
        double term = 1.0 / factorial;

	// chceking if the term number is smalller than epsillon
        if (term < epsilon) {
            break;
        }


	// adding the term to e
        e += term;
        n++;
    }

    // Printing final result
    printf("Approximated value of e: %.15f\n", e);
    return 0;
}

