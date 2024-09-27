public class Ingesta {
    private final String tiempoIngesta;
    private Alimento primero;
    private Ingesta siguiente;

    public Ingesta(String tiempoIngesta) {
        this.tiempoIngesta = tiempoIngesta;
        this.primero=null;
    }

    public String getTiempoIngesta() {
        return tiempoIngesta;
    }

    public Ingesta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Ingesta siguiente) {
        this.siguiente = siguiente;
    }

    public void anotarAlimento(String descripcion){
        Alimento nuevoAlimento = new Alimento(descripcion);
        if(this.primero==null){
            this.primero=nuevoAlimento;
        } else {
            Alimento iterador = primero;
            while (iterador.getSiguiente() !=null){
                iterador=iterador.getSiguiente();
            }
            iterador.setSiguiente(nuevoAlimento);
        }
    }

    public void listarAlimentos(){
        Alimento iterador = this.primero;
        while (iterador!=null){
            System.out.print("                ");
            System.out.println(iterador.getDescripcion());
            iterador = iterador.getSiguiente();
        }
    }


}
