package src;

public class Ingesta implements Comparable<Ingesta>, DatosArbol{
    private Horario horario;
    private GenericList<Alimento> alimentos;
    public Ingesta(Horario horario) {
        this.horario= horario;
        this.alimentos= new GenericList<Alimento>();
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
        if(this.horario.getCode()<o.horario.getCode()){
            return 1;
        }else if (this.horario.getCode()>o.horario.getCode()){
            return -1;
        }else {
            return 0;
        }
    }
    @Override
    public String getInformacion() {
        String texto = horario.getDescription();
        for(int i = 0; i < alimentos.size(); i++){
            texto += alimentos.getObjeto(i).toString();
        }
        return texto;
    }
    public void vaciar(){
        this.alimentos.vaciar();
    }
}
