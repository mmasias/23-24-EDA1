package Reto007;

public class Ingestas {
    private List<Alimentos> alimentos;

    public Ingestas() {
        this.alimentos = new List<>();
    }

    public void agregarAlimento(Alimentos alimento) {
        alimentos.add(alimento);
    }

    public void mostrarAlimentos() {
        Node<Alimentos> current = alimentos.getHead();
        while (current != null) {
            System.out.println("             - " + current.getData().getNombre());
            current = current.getNext();
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<Alimentos> current = alimentos.getHead();
        while (current != null) {
            sb.append(current.getData().getNombre());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
    public String toStringIndented() {
        StringBuilder sb = new StringBuilder();
        Node<Alimentos> current = alimentos.getHead();
        while (current != null) {
            sb.append("    ").append("- ").append(current.getData().getNombre()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}