package listasbasicas;

public class Main {
    public static void main(String[] args) {
        List list = new List();

        list.insertFirst("Juanito");
        list.insertLast("Anita");
        list.insertAt(1, "Pepito");

        viewLine(list);

        list.deleteFirst();
        list.deleteLast();

        viewLine(list);
    }

    static void viewLine(List lista) {
        String[] elementos = lista.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (String elemento : elementos) {
            System.out.println(elemento);
        }
        System.out.println("-".repeat(25));
        System.out.println("Tamaño: " + lista.size());
    }
}
