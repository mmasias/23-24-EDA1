import java.util.Scanner;

/*
 * El programa recibe una palabra y de forma ordenada recibe cuantas letras hay
 */

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce una palabra: ");
        String palabra = entrada.nextLine();

        BinaryTree arbol = new BinaryTree<>();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            arbol.insert(letra);
        }

        arbol.inorden();
        entrada.close();
    }
}
