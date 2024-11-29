public class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("-------------------------");

        System.out.println("Esta vacia? " + nephews.isEmpty());

        nephews.insertAtBeginning("Juanito");
        nephews.insertAtEnd("Pepito");
        nephews.insertAtEnd("Anita");

        System.out.println(" > Llegó 1ero: Juanito");
        System.out.println(" > Llegó 2do: Pepito");
        System.out.println(" > Llegó 3ero: Anita");

        System.out.println("Esta vacia? " + nephews.isEmpty());

        viewLine(nephews);
        System.out.println("-------------------------");

        nephews.insertAtEnd("Luisito");

        System.out.println(" > Llegó 4to: Luisito");
        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteFromEnd();
        System.out.println("Se fue el último: Luisito");
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);
    }

    static void viewLine(List filaDeSobrinos) {
        System.out.println("LA FILA------------------");
        String sobrinos = filaDeSobrinos.toString();
        if (sobrinos.isEmpty()) {
            System.out.println("-------------------------");
        } else {
            String[] sobrinosArray = sobrinos.split("\n");
            for (int i = 0; i < sobrinosArray.length; i++) {
                System.out.println(" > " + (i + 1) + "ero: " + sobrinosArray[i]);
            }
        }
    }
}