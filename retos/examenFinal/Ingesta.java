
public class Ingesta implements Comparable<Ingesta>, DatosLista {
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

    @Override
    public String getInfo() {
        String texto = this.getHorario() + ": ";

        for (int i = 0; i < alimentos.size(); i++) {
            Alimento alimento = alimentos.getValorPorPosicion(i);
            texto += alimento.getNombre() + "(" + alimento.getGramos() + "g), ";

            if (Informacion.getDatos(alimento.getNombre()) != null) {
                int caloria = Informacion.getDatos(alimento.getNombre()).getCalorias();
                int grasa = Informacion.getDatos(alimento.getNombre()).getGrasas();
                int proteina = Informacion.getDatos(alimento.getNombre()).getProteinas();
                int azucar = Informacion.getDatos(alimento.getNombre()).getAzucar();

                texto += "Calorias: " + (caloria * alimento.getGramos()) / 100 + " Grasas: "
                        + (grasa * alimento.getGramos()) / 100 +
                        "Proteinas: " + (proteina + alimento.getGramos()) / 100 + "Azúcar: "
                        + (azucar * alimento.getGramos()) / 100;
            } else {
                texto += "faltan valores nutricionales";
            }

        }
        return texto.substring(0, texto.length() - 2);
    }

    public void vaciar() {
        this.alimentos.vaciar();
    }

    public double totalCalorias(){
        double total=0;

        for(int i =0; i<alimentos.size(); i++){
            Alimento alimento= alimentos.getValorPorPosicion(i);

            int caloria= Informacion.getDatos(alimento.getNombre()).getCalorias();
            total += caloria>=0 ? caloria*alimento.getGramos()/100 :0;
        }
        return total;
    }

    public double totalGrasas(){
        double total=0;

        for(int i =0; i<alimentos.size(); i++){
            Alimento alimento= alimentos.getValorPorPosicion(i);

            int caloria= Informacion.getDatos(alimento.getNombre()).getGrasas();
            total += caloria>=0 ? caloria*alimento.getGramos()/100 :0;
        }
        return total;
    }

    public double totalAzucar(){
        double total=0;

        for(int i =0; i<alimentos.size(); i++){
            Alimento alimento= alimentos.getValorPorPosicion(i);

            int caloria= Informacion.getDatos(alimento.getNombre()).getAzucar();
            total += caloria>=0 ? caloria*alimento.getGramos()/100 :0;
        }
        return total;
    }

    public double totalProteinas(){
        double total=0;

        for(int i =0; i<alimentos.size(); i++){
            Alimento alimento= alimentos.getValorPorPosicion(i);

            int caloria= Informacion.getDatos(alimento.getNombre()).getProteinas();
            total += caloria>=0 ? caloria*alimento.getGramos()/100 :0;
        }
        return total;
    }

    public int totalTipo(){
        int cantidad=0;
        
         for(int i=0; i< this.getAlimentos().size(); i++){
            Alimento alimento= alimentos.getValorPorPosicion(i);
            String tipo= Informacion.getDatos(alimento.getNombre()).getTipo();

            if (tipo.equalsIgnoreCase(tipo)) {
                cantidad++;
            }
        }
        return cantidad;
    }
}
