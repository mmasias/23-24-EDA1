public class Ingestas {
    private List<Alimentos> alimentos;

    public Ingestas() {
        this.alimentos = new List<>();
    }

    public void agregarAlimento(Alimentos alimento) {
        alimentos.agregar(alimento);
    }

    public void mostrarAlimentos() {
        Node<Alimentos> current = alimentos.getCabeza();
        while (current != null) {
            System.out.println("             - " + current.getData().getNombre());
            current = current.getSiguiente();
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<Alimentos> current = alimentos.getCabeza();
        while (current != null) {
            sb.append(current.getData().getNombre());
            if (current.getSiguiente() != null) {
                sb.append(", ");
            }
            current = current.getSiguiente();
        }
        return sb.toString();
    }
    public String toStringIndented() {
        StringBuilder sb = new StringBuilder();
        Node<Alimentos> current = alimentos.getCabeza();
        while (current != null) {
            sb.append("    ").append("- ").append(current.getData().getNombre()).append("\n");
            current = current.getSiguiente();
        }
        return sb.toString();
    }

}