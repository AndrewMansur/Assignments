#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

//celsius fahrenheit function
float celsiusFahrenheit() {
    char conversionType;
    float tempInput;
    bool continueLoop = true;

    while (continueLoop == true) {
        // printing conversion order and letting user choose
        printf("C for conversion from Celsius to Fahrenheit\n");
        printf("F for conversion from Fahrenheit to Celsius\n");

        scanf(" %c", &conversionType);

        // Checking order of conversion and prompting input
        if (conversionType == 'C') {
            printf("Input the temperature: ");
            scanf("%f", &tempInput); 
            printf("Fahrenheit is: ");
            return (tempInput * 9/5) + 32;
        } else if (conversionType == 'F') {
            printf("Input the temperature: ");
            scanf("%f", &tempInput); 
            printf("Celsius: ");
            return (tempInput - 32) * 5/9;
        }
    }
}

// centimetre inch function
float centimetreInch(){
    char conversionType;
    float lengthInput;
    bool continueLoop = true;

    while (continueLoop == true) {
        // printing conversion order and letting user choose
        printf("C for conversion from Centimetre to Inch\n");
        printf("I for conversion from Inch to Centimetre\n");

        scanf(" %c", &conversionType);

        // Checking order of conversion and prompting input
        if (conversionType == 'C') {
            printf("Input the Length: ");
            scanf("%f", &lengthInput); 
            printf("Inches is: ");
            return (lengthInput / 2.54);
        } else if (conversionType == 'I') {
            printf("Input the Length: ");
            scanf("%f", &lengthInput); 
            printf("Centimetres is: ");
            return (lengthInput * 2.54);
        }
    }
}

//kilometer mile function
float kilometerMile(){
    char conversionType;
    float distanceInput;
    bool continueLoop = true;

    while (continueLoop == true) {
        // printing conversion order and letting user choose
        printf("K for conversion from Kilometer to Miles\n");
        printf("M for conversion from Mile to Kilometer\n");

        scanf(" %c", &conversionType);

        // Checking order of conversion and prompting input
        if (conversionType == 'K') {
            printf("Input the Distance: ");
            scanf("%f", &distanceInput); 
            printf("Miles is: ");
            return (distanceInput / 1.609);
        } else if (conversionType == 'M') {
            printf("Input the Distance: ");
            scanf("%f", &distanceInput); 
            printf("Kilometers is: ");
            return (distanceInput * 1.609);
        }
    }
}

// gallon liter converter
float gallonLiter(){
    char conversionType;
    float volInput;
    bool continueLoop = true;

    while (continueLoop == true) {
        // printing conversion order and letting user choose
        printf("G for conversion from Gallon to Liter\n");
        printf("L for conversion from Liter to Galllon\n");

        scanf(" %c", &conversionType);

        // Checking order of conversion and prompting input
        if (conversionType == 'G') {
            printf("Input the Volume: ");
            scanf("%f", &volInput); 
            printf("Liters is: ");
            return (volInput * 3.785);
        } else if (conversionType == 'L') {
            printf("Input the Volume: ");
            scanf("%f", &volInput); 
            printf("Gallons is: ");
            return (volInput / 3.785);
        }
    }
}

int main() {
    int userChoice = 0;

    while (userChoice >= 0 || userChoice < 5) {
        //printing conversion choices and promting input
        printf("1 for conversion between Celsius and Fahrenheit\n");
        printf("2 for conversion between Centimeter and Inch\n");
        printf("3 for conversion between Kilometer and Mile\n");
        printf("4 for conversion between Gallon and Liter\n");
        printf("0 for quit\n");

        scanf(" %d", &userChoice);
        
        // Checking what the user inputed and calling the funtion
        if (userChoice == 0) {
            exit(0);
        } else if (userChoice == 1) {
            printf("%f\n", celsiusFahrenheit()); 
        } else if (userChoice == 2) {
           printf("%f\n", centimetreInch());
        } else if (userChoice == 3){
            printf("%f\n", kilometerMile());
        }else if (userChoice == 4){
            printf("%f\n", gallonLiter());
        }
    }
    return 0;
}

