package src;

public class Ingesta implements Comparable<Ingesta> {
    private Horario horario;
    private GenericList<Alimento> alimentos;

    public Ingesta(Horario horario) {
        this.horario = horario;
        this.alimentos = new GenericList<>();
    }

    public Horario getHorario() {
        return this.horario;
    }

    public void insertarAlimento(Alimento alimento) {
        this.alimentos.insertarOrdenado(alimento);
    }

    @Override
    public int compareTo(Ingesta o) {
        return Integer.compare(this.horario.getCode(), o.horario.getCode());
    }

    public String getInformacion() {
        StringBuilder texto = new StringBuilder(horario.getDescription() + ": ");
        for (int i = 0; i < alimentos.size(); i++) {
            texto.append(alimentos.getObjeto(i).toString());
            if (i < alimentos.size() - 1) {
                texto.append(", ");
            }
        }
        return texto.toString();
    }

    public void vaciar() {
        this.alimentos.vaciar();
    }

    @Override
    public String toString() {
        return getInformacion();
    }
}
