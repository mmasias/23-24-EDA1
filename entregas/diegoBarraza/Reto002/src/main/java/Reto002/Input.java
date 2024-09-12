package Reto002;

import java.util.Scanner;

class Input {
    public String obtenerOpcion(Scanner scanner) {
        return scanner.nextLine().toUpperCase();
    }

    public String obtenerValor(Scanner scanner) {
        return scanner.nextLine();
    }
}