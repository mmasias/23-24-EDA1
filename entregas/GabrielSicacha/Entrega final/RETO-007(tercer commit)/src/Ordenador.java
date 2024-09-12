import java.util.Scanner;

public class Ordenador {
    private Scanner input = new Scanner(System.in);
    private Paciente primero;

    public Ordenador() {
        this.primero = null;
    }


    public Paciente getPaciente(int i){
        Paciente iterador = this.primero;
        int j=1;
        while (iterador!=null && j<i){
            iterador=iterador.getSiguiente();
            j++;
        }
        return iterador;
    }

    public void anadirPaciente(String nombre){
        Paciente nuevoPaciente = new Paciente(nombre);
        if(this.primero==null){
            this.primero=nuevoPaciente;
        } else {
            Paciente iterador = primero;
            while (iterador.getSiguiente()!=null){
                iterador=iterador.getSiguiente();
            }
            iterador.setSiguiente(nuevoPaciente);
        }
    }
    public void vistaCompleta(int p, int e){
        System.out.println(getPaciente(p).getNombre());
        System.out.println("    Encuesta "+getPaciente(p).getEncuesta(e).getFechaDeToma());
        getPaciente(p).getEncuesta(e).listarDias();
    }
}
