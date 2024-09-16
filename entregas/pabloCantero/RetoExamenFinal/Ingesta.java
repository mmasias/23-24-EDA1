public class Ingesta implements Comparable<Ingesta>, DatosLista{
    private Horario horario;
    private GenericList<Alimento> listaAlimentos;

    public Ingesta(Horario horario) {
        this.horario = horario;
        this.listaAlimentos = new GenericList<>();
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public GenericList<Alimento> getAlimentos() {
        return listaAlimentos;
    }

    public void insertarAlimento(Alimento alimento){
        this.listaAlimentos.insertarEnOrden(alimento);
    }

    @Override
    public int compareTo(Ingesta o){
        if(this.horario.getCodigo()<o.horario.getCodigo()){
            return 1;
        }else if (this.horario.getCodigo()>o.horario.getCodigo()){
            return -1;
        }else{
            return 0;
        }
    }

    public String getInformacion(){
        String texto ="\t"+horario.getDescription();
        for (int i = 0; i < listaAlimentos.size(); i++) {
            texto+=listaAlimentos.getObjeto(i).toString();
        }
        return texto;
    }
    public void vaciar (){
        this.listaAlimentos.vaciar();
    }
}

