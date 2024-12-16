package entregas.garcíaDiego.Ex004;

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

        nephews.insertFirst("Luisito");
        nephews.insertLast("Carlitos");
        nephews.insertIn("Pedrito", 3);

        viewLine(nephews);

        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteFirst();
        nephews.deleteLast();
        nephews.deleteIn(2);

        System.out.println("Tamaño: " + nephews.size());

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
