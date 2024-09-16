package reto004;

class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacía? " + nephews.isEmpty());

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");

        System.out.println("Esta vacía? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insertFront("Luisito"); // Cambiado a insertFront

        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteEnd(); // Cambiado a deleteEnd
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);

        nephews.insertAtIndex(1, "Nuevo"); // Nuevo método insertAtIndex

        viewLine(nephews);

        nephews.deleteAtIndex(2); // Nuevo método deleteAtIndex

        viewLine(nephews);
    }

    static void viewLine(List filaDeSobrinos) {
        
        String[] larray = filaDeSobrinos.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (String sobrino : larray){
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }
}
