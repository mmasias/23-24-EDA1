package entregas.garciaLydia.reto004.ListaSimpleV2;

public class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacía? " + nephews.isEmpty());

        nephews.insertEnd("Juanito");
        System.out.println(" > Llegó Juanito");
        nephews.insertEnd("Pepito");
        System.out.println(" > Llegó Pepito");
        nephews.insertEnd("Anita");
        System.out.println(" > Llegó Anita");

        System.out.println("Esta vacía? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insertEnd("Luisito");
        System.out.println(" > Llegó Luisito");

        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteEnd();
        System.out.println("Tamaño: " + nephews.size());
        System.out.println("Se fue " + nephews.getLastRemoved());

        nephews.insertFront("Lucas");
        System.out.println(" > Llegó Lucas");

        nephews.deleteFront();
        System.out.println("Se fue " + nephews.getLastRemoved());

        nephews.insertAtIndex(1, "Marta");
        System.out.println(" > Llegó Marta");

        viewLine(nephews);

        nephews.deleteAtIndex(1);
        System.out.println("Se fue " + nephews.getLastRemoved());

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



