import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ordenador {
    private Scanner input = new Scanner(System.in);
    private List<Paciente> pacientes;

    public Ordenador() {
        this.pacientes = new ArrayList<>();
    }

    public void menu0(){
        System.out.println("__________Sistema de Encuestas Dieteticas__________");
        System.out.println();
        System.out.println("1. Introducir nuevo paciente");
        System.out.println("2. Pacientes previos");
        System.out.println();
        System.out.println("3. Terminar sesion");
        switch (input.nextInt()){
            case 1 :
                menuIntroducirPaciente();
                break;
            case 2 :
                menuPacientes(this.pacientes);
                break;
            case 3 :
                System.exit(0);

        }
    }

    public void menuIntroducirPaciente(){
        System.out.println("__________Introduccion de paciente__________");
            System.out.print("Introdusca nombre del paciente : ");
            input.nextLine();
            pacientes.add(new Paciente(input.nextLine()));
                System.out.println("Desea introducir otro paciente?");
                System.out.println("1. Si");
                System.out.println("2. No");
                int choice = input.nextInt();
                switch (choice){
                    case 1 :
                        menuIntroducirPaciente();
                        break;
                    case 2 :
                        menu0();
                        break;
                    }

        if (input.nextInt()==1){
            menuIntroducirPaciente();
        } else if (input.nextInt()==2){
            menu0();
        }
    }

    public Paciente getPaciente(int i) {
        return pacientes.get(i);
    }

    public void menuPacientes(List<Paciente> pacientes) {
        System.out.println("__________Seleccion de pacientes__________");
        System.out.println("Seleccione paciente:");
        int i = 0;
        for (Paciente paciente : pacientes) {
            System.out.println(i+". " +paciente.getNombre());
            i++;
        }
        System.out.println();
        System.out.println(i+". Volver");
        int seleccion = input.nextInt();
        if (seleccion<i){
            getPaciente(seleccion).seleccionEncuestas();
            menuPacientes(pacientes);
        } else {
            menu0();
        }

    }



    public void pacienteCero(String nombre){
        pacientes.add(new Paciente(nombre));
        getPaciente(0).iniciarEncuesta("24/01/2024",5);
        for (int j=0;j<getPaciente(0).getEncuesta(0).getDiasTotales();j++){
            for(int k=0; k<5; k++){
                getPaciente(0).getEncuesta(0).getDia(j).getIngestas(k).anotarAlimento("pancakes");
                getPaciente(0).getEncuesta(0).getDia(j).getIngestas(k).anotarAlimento("jugo de naranja");
            }
        }
    }

    public void introducirAlimento(Paciente p, int e, int d, int i){
        p.getEncuesta(e).getDia(d).getIngestas(i).anotarAlimento(input.nextLine());
    }

}
