package Reto004;

public class Ejemplo {
    public static void main(String[] args) {

        List sobrinos = new List();

        viewLine(sobrinos);
        System.out.println("¿Está vacía? " + sobrinos.isEmpty());

        sobrinos.insert("Juanito");
        sobrinos.insert("Pepito");
        sobrinos.insert("Anita");

        System.out.println("¿Está vacía? " + sobrinos.isEmpty());

        viewLine(sobrinos);

        sobrinos.insert("Luisito");

        System.out.println("Tamaño: " + sobrinos.size());

        sobrinos.delete();
        System.out.println("Tamaño: " + sobrinos.size());

        viewLine(sobrinos);

        sobrinos.insertFirst("NuevoInicio");
        viewLine(sobrinos);

        sobrinos.insertAtIndex(2, "NuevoEnMedio");
        viewLine(sobrinos);

        sobrinos.deleteFirst();
        viewLine(sobrinos);

        sobrinos.deleteAtIndex(2);
        viewLine(sobrinos);
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
