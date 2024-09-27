package Reto004;

public class Ejemplo{
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacia? " + nephews.isEmpty());

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");
        nephews.insertFront("Luisito");

        System.out.println("Esta vacia? " + nephews.isEmpty());

        viewLine(nephews);

        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteEnd();
        nephews.deleteFront();
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);
        nephews.deleteTo(1);
        viewLine(nephews);

        nephews.insertTo("Patricio",1);
        nephews.insertTo("Alex",2);
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

