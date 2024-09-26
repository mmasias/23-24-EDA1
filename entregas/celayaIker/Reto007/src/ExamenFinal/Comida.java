package ExamenFinal;

import ExamenFinal.utils.generica.GenericList;
import ExamenFinal.utils.generica.GenericNode;
import java.util.Scanner;

public class Comida {
    String alimentos;
    String tipoComida;
    GenericList<String> lista = new GenericList<>();
    int dia;

    public void añadirAlimento(String alimento) {
        lista.insertEnd(alimento);
    }

    public void mostrarAlimentos() {
        System.out.println("Alimentos del " + tipoComida + ": ");
        GenericNode<String> current = lista.getFirst();
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public String getLista() {
        StringBuilder result = new StringBuilder();
        GenericNode<String> current = lista.getFirst();
        while (current != null) {
            if (result.length() > 0) result.append(", ");
            result.append(current.getValue());
            current = current.getNext();
        }
        return result.toString();
    }

    public void creaComida(String tipoComida) {
        lista.clear();
        System.out.println("Ingrese un alimento de " + tipoComida + " del día " + dia + 
                           " (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (!alimentos.equals("-1")) {
            if (alimentos.equals("-2")) {
                mostrarAlimentos();
            } else {
                añadirAlimento(alimentos);
            }
            alimentos = sc.nextLine();
        }
        sc.close();
    }

    public void creaDesayuno() {
        creaComida("desayuno");
    }

    public void creaMedia() {
        creaComida("media mañana");
    }

    public void creaAlmuerzo() {
        creaComida("almuerzo");
    }

    public void creaMerienda() {
        creaComida("merienda");
    }

    public void creaCena() {
        creaComida("cena");
    }
}