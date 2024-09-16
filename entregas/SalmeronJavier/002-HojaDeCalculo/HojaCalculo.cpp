#include <iostream>
#include <string>
#include <iomanip>
#include <vector>
#include <limits>

class Spreadsheet {
    static const int NUM_ROWS = 15;
    static const int NUM_COLS = 10;
    static const int VALUE_SIZE = 10;
    static const int DISPLAY_SIZE = 7;

    std::vector<std::vector<std::string>> arrayValues;
    int cursorRow, cursorCol;

public:
    Spreadsheet() : arrayValues(NUM_ROWS, std::vector<std::string>(NUM_COLS)), cursorRow(0), cursorCol(0) {}

    void printSeparatorLine() const {
        std::cout << "      ";
        for (int j = 0; j < NUM_COLS; j++) {
            std::cout << "+---------";
        }
        std::cout << "+" << std::endl;
    }

    void display() const {
        for (int i = 0; i < 8; i++) {
            std::cout << std::endl;
        }

        std::cout << "      ";
        for (int j = 0; j < NUM_COLS; j++) {
            std::cout << "| " << static_cast<char>('A' + j) << "       ";
        }
        std::cout << "|" << std::endl;

        printSeparatorLine();

        for (int i = 0; i < NUM_ROWS; i++)
        {
            std::cout << std::setw(6) << std::left << i + 1 << "|";

            for (int j = 0; j < NUM_COLS; j++)
            {
                std::string displayValue = arrayValues[i][j].substr(0, DISPLAY_SIZE);
                if (i == cursorRow && j == cursorCol)
                    std::cout << "[" << std::setw(7) << displayValue << "]|";
                else
                    std::cout << " " << std::setw(7) << displayValue << " |";
            }
            std::cout << std::endl;
        }

        printSeparatorLine();
    }

    void run() {
        std::string userInput, newValue;

        while (true) {
            display();

            std::cout << "Posicion actual: " << static_cast<char>('A' + cursorCol) << cursorRow + 1;
            std::cout << "\nMover posicion : w/a/s/d\nModificar Valor: M\nSalir: q\n --> ";

            std::cin >> userInput;
            std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

            switch (userInput[0]) {
                case 'w': case 'W': if (cursorRow > 0) cursorRow--; break;
                case 'a': case 'A': if (cursorCol > 0) cursorCol--; break;
                case 's': case 'S': if (cursorRow < NUM_ROWS - 1) cursorRow++; break;
                case 'd': case 'D': if (cursorCol < NUM_COLS - 1) cursorCol++; break;
                case 'm': case 'M':
                    std::cout << "Introduce el nuevo valor: ";
                    std::getline(std::cin, newValue);
                    arrayValues[cursorRow][cursorCol] = newValue.substr(0, VALUE_SIZE - 1);
                    break;
                case 'q': case 'Q': return;
                default: std::cout << "ERROR: Introduce un valor valido!\n" << std::endl;
            }
        }
    }
};

int main() {
    Spreadsheet sheet;
    sheet.run();
    return 0;
}
