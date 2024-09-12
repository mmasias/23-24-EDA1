package Reto007;

public class Dias {
    private int diaIndex;
    private Tree<IngestaTipo> ingestasTree;

    public Dias(int diaIndex) {
        this.diaIndex = diaIndex;
        this.ingestasTree = new Tree<>();
        for (String tipoIngesta : getTiposIngestaValidos()) {
            ingestasTree.insert(new Node<>(new IngestaTipo(tipoIngesta, new Ingestas()), tipoIngesta.hashCode()));
        }
    }

    public void agregarAlimento(Alimentos alimento, String tipoIngesta) {
        Node<IngestaTipo> ingestaTipoNode = ingestasTree.find(tipoIngesta.hashCode());
        if (ingestaTipoNode != null) {
            ingestaTipoNode.getData().getIngestas().agregarAlimento(alimento);
        } else {
            System.out.println("Error: Tipo de ingesta no válido.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("Día ").append(diaIndex).append(":\n");
    
        for (String tipoIngesta : getTiposIngestaValidos()) {
            Node<IngestaTipo> ingestaTipoNode = ingestasTree.find(tipoIngesta.hashCode());
            if (ingestaTipoNode != null) {
                sb.append(" ").append("Ingesta ").append(tipoIngesta).append(":\n");
                sb.append(ingestaTipoNode.getData().getIngestas().toStringIndented());
            }
        }
    
        return sb.toString();
    }
    private static String[] getTiposIngestaValidos() {
        return new String[]{"Desayuno", "Media Mañana", "Almuerzo", "Merienda", "Cena"};
    }

}
