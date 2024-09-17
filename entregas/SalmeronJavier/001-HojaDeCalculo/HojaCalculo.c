#include <stdio.h>
#include <string.h>

#define NUM_ROWS 15
#define NUM_COLS 10
#define VALUE_SIZE 10 // Size of the array values
#define DISPLAY_SIZE 7 // Ammount of chars to display per cell

// Function to print separator lines
void printSeparatorLine() {
    printf("       ");
    for (int j = 0; j < NUM_COLS; j++) {
        printf("+---------");
    }
    printf("+\n");
}

int main() {
    char arrayValues[NUM_ROWS][NUM_COLS][VALUE_SIZE] = {{{'\0'}}}; // Initialize array

    int cursorRow = 0, cursorCol = 0; // Initial cursor location
    char userInput[50], newValue[VALUE_SIZE];

    while (1) {

        // "Clear" the terminal
        for (int i = 0; i < 6; i++)
            printf("\n");

        printf("       ");
        for (int j = 0; j < NUM_COLS; j++) {
            printf("| %c       ", 'A' + j); // Column headers (A B ...)
        } 
        printf("|\n");

        printSeparatorLine();

        // Print rows with array values
        for (int i = 0; i < NUM_ROWS; i++) {
            printf("%-6d |", i + 1); // Row numbers (1 2 ...)

            for (int j = 0; j < NUM_COLS; j++) {
                char displayValue[DISPLAY_SIZE + 1]; // Array to hold display value
                strncpy(displayValue, arrayValues[i][j], DISPLAY_SIZE); // Copy characters from arrayValues to displayValue
                displayValue[DISPLAY_SIZE] = '\0'; // Add Null-terminator

                // Print value from arrayValues. Add cursor if at position.
                printf((i == cursorRow && j == cursorCol) ? "[%7s]|" : " %7s |", displayValue);
            }
            printf("\n");
        }

        printSeparatorLine();

        // Get user input
        printf("Posicion actual %c%d\nMover posicion : w/a/s/d\nModificar Valor: M\nSalir: q\n --> ", 'A' + cursorCol, cursorRow + 1);
        if (scanf(" %49[^\n]", userInput) != 1) { // Read input until newline, ignore leading whitespaces
            printf("Error: Entrada invalida!\n");
            continue;
        }

        switch (userInput[0]) {
            case 'w': case 'W': if (cursorRow > 0) cursorRow--; break;
            case 'a': case 'A': if (cursorCol > 0) cursorCol--; break;
            case 's': case 'S': if (cursorRow < NUM_ROWS - 1) cursorRow++; break;
            case 'd': case 'D': if (cursorCol < NUM_COLS - 1) cursorCol++; break;
            case 'm': case 'M':
                printf("Enter new value: ");
                if (scanf(" %9[^\n]", newValue) != 1) break; // Read new value from user, ignore leading whitespaces
                strncpy(arrayValues[cursorRow][cursorCol], newValue, VALUE_SIZE - 1); // Copy new value to arrayValues
                arrayValues[cursorRow][cursorCol][VALUE_SIZE - 1] = '\0'; // Null-terminate arrayValues
                break;
            case 'q': case 'Q': return 0;
            default: printf("ERROR: Introduce una tecla valida\n");
        }
    }

    return 0;
}
