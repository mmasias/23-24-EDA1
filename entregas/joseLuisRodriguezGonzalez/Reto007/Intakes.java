public class Intakes {
    private List<Food> fooList;

    public Intakes() {
        this.fooList = new List<>();
    }

    public void agregarAlimento(Food alimento) {
        fooList.add(alimento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<Food> current = fooList.getHead();
        while (current != null) {
            sb.append(current.getData().getNombre());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

    public void listFood() {
        Node<Food> current = fooList.getHead();
        while (current != null) {
            System.out.println("\t - " + current.getData().getNombre());
            current = current.getNext();
        }
    }
    
    public String toStringIndented() {
        StringBuilder sb = new StringBuilder();
        Node<Food> current = fooList.getHead();
        while (current != null) {
            sb.append("    ").append("- ").append(current.getData().getNombre()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}