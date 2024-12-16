import java.util.Comparator;

public class Dia {
    private int numeroDia;
    private DatosArbol<Ingesta> ingestas;

    public Dia(int numeroDia) {
        this.numeroDia = numeroDia;
        this.ingestas = new DatosArbol<>(Comparator.comparing(Ingesta::getTipoComida));
    }

    public void agregarIngesta(Ingesta ingesta) {
        ingestas.insertar(ingesta);
    }

    public Ingesta buscarIngesta(String tipoComida) {
        return ingestas.buscar(new Ingesta(tipoComida, null));
    }

    public int getNumeroDia() {
        return numeroDia;
    }

    public DatosArbol<Ingesta> getIngestas() {
        return ingestas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("        Dia ").append(numeroDia).append("\n");
        for (String tipoIngesta : new String[]{"Desayuno", "Media mañana", "Almuerzo", "Merienda", "Cena"}) {
            Ingesta ingesta = this.ingestas.buscar(new Ingesta(tipoIngesta, null));
            if (ingesta == null) {
                sb.append("            ").append(tipoIngesta).append(": Sin datos\n");
            } else {
                sb.append(ingesta.toString());
            }
        }
        return sb.toString();
    }
}
