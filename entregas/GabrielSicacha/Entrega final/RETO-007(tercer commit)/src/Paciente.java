
public class Paciente {
    private final String nombre;
    private Encuesta primera;
    private Paciente siguiente;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.primera=null;
    }

    public void anadirEncuesta(String fechaDeToma, int diasTotales){
        Encuesta nuevaEncuesta = new Encuesta(fechaDeToma, diasTotales);
        if(this.primera==null){
            this.primera=nuevaEncuesta;
        } else {
            Encuesta iterador = primera;
            while (iterador.getSiguiente()!=null){
                iterador=iterador.getSiguiente();
            }
            iterador.setSiguiente(nuevaEncuesta);
        }
    }

    public Paciente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Paciente siguiente) {
        this.siguiente = siguiente;
    }

    public String getNombre() {
        return nombre;
    }

    public Encuesta getEncuesta(int i){
        Encuesta iterador = this.primera;
        int j=1;
        while (iterador!=null && j<i){
            iterador=iterador.getSiguiente();
            j++;
        }
        return iterador;
    }
}
