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

    public double totalCalorias() {
        double total = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = this.alimentos.getValorPorPosicion(i);
            if(Informacion.getDatos(alimento.getNombre()) != null){
                int caloria = Informacion.getDatos(alimento.getNombre()).getCalorias();
                total += caloria >= 0 ? caloria * alimento.getGramos() / 100 : 0;
            }
        }
        return total;
    }

    public double totalAzucar() {
        double total = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = this.alimentos.getValorPorPosicion(i);
            if(Informacion.getDatos(alimento.getNombre()) != null){
                int azucar = Informacion.getDatos(alimento.getNombre()).getAzucar();
                total += azucar >= 0 ? azucar * alimento.getGramos() / 100 : 0;
            }
        }
        return total;
    }

    public double totalProteinas() {
        double total = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = this.alimentos.getValorPorPosicion(i);
            if(Informacion.getDatos(alimento.getNombre()) != null){
                int proteinas = Informacion.getDatos(alimento.getNombre()).getProteinas();
                total += proteinas >= 0 ? proteinas * alimento.getGramos() / 100 : 0;
            }
        }
        return total;
    }

    public double totalGrasas() {
        double total = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = this.alimentos.getValorPorPosicion(i);
            if(Informacion.getDatos(alimento.getNombre()) != null){
                int grasas = Informacion.getDatos(alimento.getNombre()).getGrasas();
                total += grasas >= 0 ? grasas * alimento.getGramos() / 100 : 0;
            }
        }
        return total;
    }

    public int totalTipo(String nombreTipo) {
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



}


