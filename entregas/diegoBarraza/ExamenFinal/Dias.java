package ExamenFinal;

public class Dias {
    protected int diaIndex;
    private List<IngestaTipo> ingestasList;

    public Dias(int diaIndex) {
        this.diaIndex = diaIndex;
        this.ingestasList = new List<>();
        for (String tipoIngesta : getTiposIngestaValidos()) {
            ingestasList.add(new IngestaTipo(tipoIngesta, new Ingestas()));
        }
    }

    public void agregarAlimento(Alimentos alimento, String tipoIngesta) {
        IngestaTipo ingestaTipo = getIngestaTipo(tipoIngesta);
        if (ingestaTipo != null) {
            ingestaTipo.getIngestas().agregarAlimento(alimento);
        } else {
            System.out.println("Error: Tipo de ingesta no válido.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("Día ").append(diaIndex).append(":\n");

        for (IngestaTipo ingestaTipo : ingestasList) {
            sb.append(" ").append(ingestaTipo.getTipo()).append(":\n");
            sb.append(ingestaTipo.getIngestas().toStringIndented());
        }

        return sb.toString();
    }

    private IngestaTipo getIngestaTipo(String tipoIngesta) {
        for (IngestaTipo ingestaTipo : ingestasList) {
            if (ingestaTipo.getTipo().equalsIgnoreCase(tipoIngesta)) {
                return ingestaTipo;
            }
        }
        return null;
    }

    private static String[] getTiposIngestaValidos() {
        return new String[]{"Desayuno", "Media Mañana", "Almuerzo", "Merienda", "Cena"};
    }
}
