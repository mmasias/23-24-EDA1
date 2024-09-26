package listas.basicas;

class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacia? " + nephews.isEmpty());

        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");

        System.out.println("Esta vacia? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insertEnd("Luisito");

        System.out.println("Tamaño: " + nephews.size());

        nephews.delete();
        System.out.println("Tamaño: " + nephews.size());
        //System.out.println("Tamaño: " + nephews.tamaño);

        viewLine(nephews);

        nephews.insertFront("Manuel");
        viewLine(nephews);
        nephews.deleteFront();
        nephews.deleteFront();
        nephews.deleteFront();
        nephews.deleteFront();
        viewLine(nephews);
        System.out.println("Tamaño: "+nephews.size());
        System.out.println("Esta vacia? " + nephews.isEmpty());
         nephews.insertEnd("Julio");
        nephews.insertEnd("Marcos");
        nephews.insertEnd("Juan");
        nephews.insertEnd("Luis");
        viewLine(nephews);

        System.out.println("Tamaño: "+nephews.size());
        nephews.insertPos("Pepe",5);
        viewLine(nephews);
        nephews.deletePos(2);
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
