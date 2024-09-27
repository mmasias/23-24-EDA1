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

    public void menu0(){
        System.out.println("__________Sistema de Encuestas Dieteticas__________");
        System.out.println();
        System.out.println("1. Introducir nuevo paciente");
        System.out.println("2. Pacientes");
        System.out.println();
        System.out.println("3. Terminar sesion");
        switch (input.nextInt()){
            case 1 :
                input.nextLine();
                System.out.println("Introdusca nombre del nuevo paciente");
                anadirPaciente(input.nextLine());
                menu0();
                break;
            case 2 :
                menuSeleccionPacientes();
                break;
            case 3 :
                System.exit(0);

        }

    }

    public void menuSeleccionPacientes() {
        Paciente iterador = this.primero;
        int i = 0;

        if (iterador == null) {
            System.out.println("No hay pacientes registrados");
            menu0();
            return;
        }

        while (iterador != null) {
            i++;
            System.out.println(i + ". " + iterador.getNombre());
            iterador = iterador.getSiguiente();
        }

        System.out.println();
        System.out.println(i + 1 + ". Volver al inicio");

        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        iterador = this.primero;

        while (userInput > 1 && iterador != null) {
            iterador = iterador.getSiguiente();
            userInput--;
        }

        if (iterador != null) {
            iterador.listaEncuestas();
        } else {
            System.out.println("opcion invalida");
            menu0();
        }


    }

    

}
