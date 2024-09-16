public class Encuesta {
    private final String fechaDeToma;
    private final int diasTotales;
    private Encuesta siguiente;
    private Dia primero;

    public Encuesta(String fechaDeToma, int diasTotales) {
        this.fechaDeToma = fechaDeToma;
        this.diasTotales = diasTotales;
        primero = new Dia(1);
        inicializarDias(diasTotales);
    }

    public Encuesta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Encuesta siguiente) {
        this.siguiente = siguiente;
    }

    public String getFechaDeToma() {
        return fechaDeToma;
    }

    public int getDiasTotales() {
        return diasTotales;
    }

    public void inicializarDias(int i){
        for(int j=1;j<=i; j++){
            Dia nuevoDia = new Dia(j);
            if(this.primero==null){
                this.primero=nuevoDia;
            } else {
                Dia iterador = primero;
                while (iterador.getSiguiente()!=null){
                    iterador=iterador.getSiguiente();
                }
                iterador.setSiguiente(nuevoDia);
            }
        }
    }

    public void listarDias(){
        Dia iterador = this.primero;
        while (iterador!=null){
            System.out.print("        "+iterador.getNumDia());
            iterador.listarIngestas();
            iterador = iterador.getSiguiente();
        }
    }
}
