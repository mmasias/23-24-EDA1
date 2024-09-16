package ExamenFinal;

public class Day {
    String name;
    List<Ingesta> ingesta;

    public Day(String name) {
        this.name = name;
        ingesta = new List<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingesta> getIngesta() {
        return ingesta;
    }

    public void setIngesta(List<Ingesta> ingesta) {
        this.ingesta = ingesta;
    }

    void addIngesta(Ingesta intake) {
        ingesta.insert(intake, -1);
    }

    void showData() {
        System.out.println("  " + name);
        Node<Ingesta> currentIngesta = ingesta.getFirst();
        while (currentIngesta != null) {
            currentIngesta.getData().showData();
            currentIngesta = currentIngesta.getNext();
        }
    }
}