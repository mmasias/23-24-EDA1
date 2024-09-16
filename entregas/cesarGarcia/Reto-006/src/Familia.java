import java.util.Arrays;

public class Familia {

    public static void main(String[] args) {
        FamiliaTree<String> arbolFamiliar = new FamiliaTree<>();

        // Agregar miembros a la familia
        arbolFamiliar.agregarMiembro("Abuelo", null, false);
        arbolFamiliar.agregarMiembro("Padre", "Abuelo", true);
        arbolFamiliar.agregarMiembro("Madre", "Abuelo", false);
        arbolFamiliar.agregarMiembro("Hijo1", "Padre", true);
        arbolFamiliar.agregarMiembro("Hijo2", "Padre", false);
        arbolFamiliar.agregarMiembro("Hija", "Madre", true);

        // Imprimir la estructura del árbol familiar
        arbolFamiliar.imprimirArbol();

        // Mostrar información de la estructura
        System.out.println("Tamaño del árbol familiar: " + arbolFamiliar.size());
        System.out.println("El árbol familiar está vacío: " + arbolFamiliar.isEmpty());
        System.out.println("Lista de miembros de la familia: " + Arrays.toString(arbolFamiliar.listData()));
    }
}
