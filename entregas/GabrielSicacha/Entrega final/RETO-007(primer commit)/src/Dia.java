
public class Dia {
    private final int numDia;
    private final Ingesta primera;

    private Dia siguiente;


    public Dia(int numDia) {
        this.numDia = numDia;
        this.primera = new Ingesta("Desayuno");
        Ingesta iterador = primera;
        iterador.setSiguiente(new Ingesta("Media mañana"));
        iterador=iterador.getSiguiente();
        iterador.setSiguiente(new Ingesta("Almuerzo"));
        iterador=iterador.getSiguiente();
        iterador.setSiguiente(new Ingesta("Merienda"));
        iterador=iterador.getSiguiente();
        iterador.setSiguiente(new Ingesta("Cena"));
    }

    public Dia getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Dia siguiente) {
        this.siguiente = siguiente;
    }

    public int getNumDia() {
        return numDia;
    }

    public void listarIngestas(){
        Ingesta iterador = this.primera;
        while (iterador!=null){
            System.out.print("            ");
            System.out.println(iterador.getTiempoIngesta());
            iterador.listarAlimentos();
            iterador = iterador.getSiguiente();
        }
    }

}
