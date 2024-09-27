package entregas.sergioMayen.ListaReto4;

import java.util.Scanner;

class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacia? " + nephews.isEmpty());

        nephews.insert("Juanito");
        nephews.insert("Pepito");
        nephews.insert("Anita");

        System.out.println("Esta vacia? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insert("Luisito");

        System.out.println("Tamaño: " + nephews.size());

        nephews.delete();
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);

        // Preguntar al usuario si desea agregar un elemento al principio o al final
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Deseas agregar un elemento al principio (P) o al final (F)?");
        String choice = scanner.next().toLowerCase();
        scanner.close();

        if (choice.equals("p")) {
            System.out.println("Ingrese el nombre para agregar al principio: ");
            String name = scanner.next();
            nephews.insertAtBeginning(name);
        } else if (choice.equals("f")) {
            System.out.println("Ingrese el nombre para agregar al final: ");
            String name = scanner.next();
            nephews.insert(name);
        }

        viewLine(nephews);
    }

    static void viewLine(List filaDeSobrinos) {
        String[] larray = filaDeSobrinos.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (String sobrino : larray) {
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }
}
