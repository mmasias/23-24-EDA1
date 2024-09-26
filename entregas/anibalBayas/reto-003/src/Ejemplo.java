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
    }

    static void viewLine(List filaDeSobrinos) {

        System.out.println("LA FILA" + "-".repeat(18));
        filaDeSobrinos.printMessages();
        filaDeSobrinos.printList();
        System.out.println("-".repeat(25));
    }
}

