import java.util.Scanner;

public class InputManager {
    public static String obtenerComando(Scanner scanner) {
        System.out.print("CMDs: [W] Arriba, [S] Abajo, [A] Izquierda, [D] Derecha, [E] Escribir, [F] Salir - Ingrese comando:");
        return scanner.nextLine().trim().toUpperCase();
    }
}
