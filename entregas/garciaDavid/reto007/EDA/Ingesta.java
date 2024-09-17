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
        String texto = " / Los alimentos del " + getHorario().getDescription() + " son: ";
        for (int i = 0; i < alimentos.size(); i++) {
            Alimento alimento = alimentos.getValorPorPosicion(i);
            texto += alimento.getNombre() + "(" + alimento.getGramos() + "gr.), ";
            if (InformacionNutricional.getDatos(alimento.getNombre()) != null) {
                int calorias = InformacionNutricional.getDatos(alimento.getNombre()).getCalorias();
                int grasa = InformacionNutricional.getDatos(alimento.getNombre()).getGrasas();
                int proteinas = InformacionNutricional.getDatos(alimento.getNombre()).getProteinas();
                int azucar = InformacionNutricional.getDatos(alimento.getNombre()).getAzucar();
                texto += "Calorias:" + (calorias * alimento.getGramos()) / 100 + "||Grasas:"
                        + (grasa * alimento.getGramos()) / 100 +
                        "||Proteinas:" + (proteinas + alimento.getGramos()) / 100 + "||Azúcar:"
                        + (azucar * alimento.getGramos()) / 100 + "||";
            } else {
                texto += " faltan valores nutricionales || ";
            }

        }
        return texto.substring(0, texto.length() - 2);
    }

    public void vaciar() {
        this.alimentos.vaciar();
    }

    public double totalCalorias() {
        double total = 0;
        for (int i = 0; i < this.getAlimentos().size(); i++) {
            Alimento alimento = this.getAlimentos().getValorPorPosicion(i);
            if (InformacionNutricional.getDatos(alimento.getNombre()) != null) {
                int caloria = InformacionNutricional.getDatos(alimento.getNombre()).getCalorias();
                total += caloria >= 0 ? caloria * alimento.getGramos() / 100 : 0;
            }

        }
        return total;
    }
    public double totalGrasas(){
        double total=0;

        for(int i =0; i<alimentos.size(); i++){
            Alimento alimento= alimentos.getValorPorPosicion(i);

            int caloria= InformacionNutricional.getDatos(alimento.getNombre()).getGrasas();
            total += caloria>=0 ? caloria*alimento.getGramos()/100 :0;
        }
        return total;
    }

    public double totalAzucar(){
        double total=0;

        for(int i =0; i<alimentos.size(); i++){
            Alimento alimento= alimentos.getValorPorPosicion(i);

            int caloria= InformacionNutricional.getDatos(alimento.getNombre()).getAzucar();
            total += caloria>=0 ? caloria*alimento.getGramos()/100 :0;
        }
        return total;
    }

    public double totalProteinas(){
        double total=0;

        for(int i =0; i<alimentos.size(); i++){
            Alimento alimento= alimentos.getValorPorPosicion(i);

            int caloria= InformacionNutricional.getDatos(alimento.getNombre()).getProteinas();
            total += caloria>=0 ? caloria*alimento.getGramos()/100 :0;
        }
        return total;
    }


    public int totalTipo(String nombreTipo) {
        int cantidad = 0;
        for (int i = 0; i < this.getAlimentos().size(); i++) {
            Alimento alimento = this.getAlimentos().getValorPorPosicion(i);
            if (InformacionNutricional.getDatos(alimento.getNombre()) != null) {
                String tipo = InformacionNutricional.getDatos(alimento.getNombre()).getTipo();
                if (nombreTipo.equalsIgnoreCase(tipo)) {
                    cantidad++;
                }

            }

        }
        return cantidad;
    }
    
}
