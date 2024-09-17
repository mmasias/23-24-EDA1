public class Ingesta implements Comparable<Ingesta>, DatosArbol {
    private Horario horario;
    private GenericList<Alimento> alimentos;

    public Ingesta(Horario horario) {
        this.horario = horario;
        this.alimentos = new GenericList<Alimento>();
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public GenericList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void insertarAlimento(Alimento alimento) {
        this.alimentos.insertEnd(alimento);
    }

    @Override
    public int compareTo(Ingesta o) {
        if (this.horario.getCodigo() < o.horario.getCodigo()) {
            return 1;
        } else if (this.horario.getCodigo() > o.horario.getCodigo()) {
            return -1;
        } else {
            return 0;
        }
    }

    public String getInfo() {
        String texto = this.getHorario().getDescription() + ": ";
        for (int i = 0; i < alimentos.size(); i++) {
            Alimento al = alimentos.getValorPorPosicion(i);
            texto += "\n" + al.getNombre() + " (" + al.getGramos() + " gr.) | ";
            if (Informacion.getDatos(al.getNombre()) != null) {
                int caloria = Informacion.getDatos(al.getNombre()).getCalorias();
                int grasa = Informacion.getDatos(al.getNombre()).getGrasas();
                int proteina = Informacion.getDatos(al.getNombre()).getProteinas();
                int azucar = Informacion.getDatos(al.getNombre()).getAzucar();

                texto += "Calorias: " + ( caloria * al.getGramos() / 100 ) + "gr. | " +
                        "Grasas: " + ( grasa * al.getGramos() / 100 ) + "gr. | " +
                        "Proteinas: " + ( proteina * al.getGramos() / 100 ) + "gr. | " +
                        "Azucar: " + ( azucar * al.getGramos() / 100 ) + "gr. | ";
            } else {
                texto += "Faltan valores nutricionales";
            }
        }
        return texto.substring(0, texto.length() - 2);
    }

    public void vaciar() {
        this.alimentos.vaciar();
    }


}


