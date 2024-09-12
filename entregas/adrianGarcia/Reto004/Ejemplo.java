class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("¿Está vacía? " + nephews.isEmpty());

        nephews.insertAtEnd("Juanito");
        nephews.insertAtEnd("Pepito");
        nephews.insertAtEnd("Anita");

        System.out.println("¿Está vacía? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insertAtStart("Luisito");

        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteFromEnd();
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
