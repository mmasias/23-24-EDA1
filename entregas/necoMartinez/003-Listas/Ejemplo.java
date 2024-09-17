public class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("-------------------------");

        System.out.println("Esta vacia? " + nephews.isEmpty());

        nephews.insert("Juanito");
        nephews.insert("Pepito");
        nephews.insert("Anita");

        System.out.println(" > Llegó Juanito");
        System.out.println(" > Llegó Pepito");
        System.out.println(" > Llegó Anita");

        System.out.println("Esta vacia? " + nephews.isEmpty());

        viewLine(nephews);
        System.out.println("-------------------------");

        nephews.insert("Luisito");

        System.out.println(" > Llegó Luisito");
        System.out.println("Tamaño: " + nephews.size());

        nephews.delete();
        System.out.println("Se fue Luisito");
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);
    }

    static void viewLine(List filaDeSobrinos) {
        System.out.println("LA FILA------------------");
        String sobrinos = filaDeSobrinos.toString();
        if (sobrinos.isEmpty()) {
            System.out.println("-------------------------");
        } else {
            System.out.print(sobrinos);
        }
    }
}
