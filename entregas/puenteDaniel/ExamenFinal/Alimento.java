package entregas.puenteDaniel.ExamenFinal;

import java.util.ArrayList;
import java.util.List;

public class Alimento {
    private String nombre;
    private int gramos;

    public Alimento(String nombre, int gramos) {
        this.nombre = nombre;
        this.gramos = gramos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGramos() {
        return gramos;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Gramos: " + gramos;
    }

    public static void main(String[] args) {
        List<Alimento> listaAlimentos = new ArrayList<>();

        Alimento alimento1 = new Alimento("Manzana", 100);
        Alimento alimento2 = new Alimento("Banana", 150);
        Alimento alimento3 = new Alimento("Naranja", 120);

        listaAlimentos.add(alimento1);
        listaAlimentos.add(alimento2);
        listaAlimentos.add(alimento3);

        // Imprimir la lista ordenada
        for (Alimento alimento : listaAlimentos) {
            System.out.println(alimento);
        }
    }
}