
class Example {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacia? " + nephews.isEmpty());

        System.out.println(" > Llegó " + nephews.insert("Juanito"));
        System.out.println(" > Llegó " + nephews.insert("Pepito"));
        System.out.println(" > Llegó " + nephews.insert("Anita"));

        System.out.println(" > Llegó al inicio " + nephews.insertFirst("Pablito"));

        System.out.println(" > Llegó al final " + nephews.insertLast("Raulito"));

        System.out.println(" > Llegó en la posición 2 " + nephews.insertAt("Karol", 1));

        System.out.println("¿Está vacía? " + nephews.isEmpty());

        viewLine(nephews);

        System.out.println(" > Llegó " + nephews.insert("Luisito"));

        System.out.println("Tamaño: " + nephews.size());

        System.out.println("Se fue " + nephews.delete());
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);

        System.out.println("Se fue desde el inicio " + nephews.deleteFirst());
        viewLine(nephews);

        System.out.println("Se fue desde el final " + nephews.deleteLast());
        viewLine(nephews);

        System.out.println("Se fue desde la posición 2 " + nephews.deleteAt(1));
        viewLine(nephews);
    }

    static void viewLine(List nephewsList) {

        String[] larray = nephewsList.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (String sobrino : larray){
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }
}