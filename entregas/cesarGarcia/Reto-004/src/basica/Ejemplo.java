package basica;

class Ejemplo {
    public static void main(String[] args) {
        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacía? " + nephews.isEmpty());

        nephews.insert("Juanito");
        nephews.insert("Pepito");
        nephews.insert("Anita");

        System.out.println("Esta vacía? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insert("Luisito");

        System.out.println("Tamaño: " + nephews.size());

        String firstDeleted = nephews.deleteFromBeginning();
        if (firstDeleted != null) {
            System.out.println("Salió " + firstDeleted);
        }

        String lastDeleted = nephews.deleteFromEnd();
        if (lastDeleted != null) {
            System.out.println("Salió " + lastDeleted);
        }
        System.out.println("Tamaño: " + nephews.size());

        nephews.insertAtIndex("NuevoElemento", 2);

        viewLine(nephews);
    }

    static void viewLine(List filaDeSobrinos) {
        String[] larray = filaDeSobrinos.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (int i = 0; i < larray.length; i++) {
            System.out.println((i + 1) + ". " + larray[i]);
        }
        System.out.println("-".repeat(25));
    }
}
