/*
public class Ingesta implements Comparable<Ingesta>, DatosArbol {
    private Horario horario;
    private GenericList<Alimento> alimentos;

    public Ingesta(Horario horario) {
        this.horario = horario;
        this.alimentos = new GenericList<Alimento>();
    }

    public void setHorario(String nombre) {
        this.horario = horario;
    }

    public Horario getHorario() {
        return this.horario;
    }

    public void insertarAlimento(Alimento alimento) {
        this.alimentos.insertarOrdenado(alimento);
    }

    @Override
    public int compareTo(Ingesta o) {
        if (this.horario.getCode() < o.horario.getCode()) {
            return 1;
        } else if (this.horario.getCode() > o.horario.getCode()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String getInformacion() {
        String texto = this.getHorario().getDescription() + ":";
        for (int i = 0; i < alimentos.size(); i++) {
            Alimento alimento = alimentos.getValorPorPosicion(i);
            texto += alimento.getNombre() + "(" + alimento.getGramos() + "g), ";
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                int caloria = Informacion.getDatos(alimento.getNombre()).getCalorias();
                int grasa = Informacion.getDatos(alimento.getNombre()).getGrasas();
                int proteina = Informacion.getDatos(alimento.getNombre()).getProteinas();
                int azucar = Informacion.getDatos(alimento.getNombre()).getAzucar();

                texto += "Calorias: " + (caloria * alimento.getGramos()) / 100 + " Grasas: "
                        + (grasa * alimento.getGramos()) / 100 + " Proteinas: "
                        + (proteina * alimento.getGramos()) / 100 + " Azucar: " + (azucar * alimento.getGramos());
            } else {
                texto += "Faltan valores nutricionales. ";
            }
        }
        return texto.substring(0, texto.length() - 2);
    }

    public void vaciar() {
        this.alimentos.vaciar();
    }

    public int totalTipoI(String nombreTipo) {
        int cantidad = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = alimentos.getValorPorPosicion(i);
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                String tipo = Informacion.getDatos(alimento.getNombre()).getTipo();
                if (nombreTipo.equalsIgnoreCase(tipo)) {
                    cantidad++;
                }
            }

        }
        return cantidad;
    }

    public double totalCaloriasI() {
        double total = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = alimentos.getValorPorPosicion(i);
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                int caloria = Informacion.getDatos(alimento.getNombre()).getCalorias();
                total += caloria >= 0 ? caloria * alimento.getGramos() / 100 : 0;
            }

        }
        return total;
    }
}
*/