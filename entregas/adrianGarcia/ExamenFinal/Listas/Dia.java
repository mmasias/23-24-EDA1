public class Dia {
    private int numeroDia;
    private GenericList<Ingesta> ingestas;

    public Dia(int numeroDia) {
        this.numeroDia = numeroDia;
        this.ingestas = new GenericList<>();
        agregarIngesta(new Ingesta("Desayuno", null));
        agregarIngesta(new Ingesta("Media mañana", null));
        agregarIngesta(new Ingesta("Almuerzo", null));
        agregarIngesta(new Ingesta("Merienda", null));
        agregarIngesta(new Ingesta("Cena", null));
    }

    public void agregarIngesta(Ingesta ingesta) {
        ingestas.insertEnd(ingesta);
    }

    public Ingesta buscarIngesta(String tipoComida) {
        GenericNode<Ingesta> current = ingestas.getFirst();
        while (current != null) {
            Ingesta ingesta = current.getValue();
            if (ingesta.getTipoComida().equalsIgnoreCase(tipoComida)) {
                return ingesta;
            }
            current = current.getNext();
        }
        return null;
    }

    public int getNumeroDia() {
        return numeroDia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("        Dia ").append(numeroDia).append("\n");

        String[] comidas = {"Desayuno", "Media mañana", "Almuerzo", "Merienda", "Cena"};
        for (String comida : comidas) {
            Ingesta ingesta = buscarIngesta(comida);
            if (ingesta != null) { // Asegurar que la ingesta no es null antes de llamar a toString
                sb.append(ingesta.toString());
            }
        }
        return sb.toString();
    }
}

