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


        String lastDeleted = nephews.delete();

        if (lastDeleted != null) {
            System.out.println("Salió " + lastDeleted);
        }

        System.out.println("Tamaño: " + nephews.size());

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