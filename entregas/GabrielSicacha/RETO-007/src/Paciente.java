import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paciente {
    private String nombre;
    private List<Encuesta> encuestas;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.encuestas = new ArrayList<>();
    }

    public void iniciarEncuesta(String fechaDeToma, int diasTotales){
        encuestas.add(new Encuesta(fechaDeToma, diasTotales));
        System.out.println("Se ha creado una nueva encuesta el dia " + fechaDeToma + " con la duracion de: " + diasTotales +" dias");
    }

    public Encuesta getEncuesta(int i) {
        return encuestas.get(i);
    }

    public void seleccionEncuestas(){
        Scanner input = new Scanner(System.in);
        System.out.println("Seleccione encuesta:");
        int i = 1;
        for (Encuesta encuesta : encuestas) {
            System.out.println(i+". " +encuesta.getFechaDeToma());
            i++;
        }
        System.out.println();
        System.out.println(i+". Nueva encuesta");
        System.out.println((i+1)+". Volver");
        int seleccion = input.nextInt();
        if(seleccion<i){
            getEncuesta(seleccion);
        } else if (seleccion==i) {
            System.out.println("Introdusca el dia toma:");
            String toma = input.nextLine();
            System.out.println("Introdusca la cantidad de dias");
            int dias = input.nextInt();
            iniciarEncuesta(toma,dias);

        }
    }

    public String getNombre() {
        return nombre;
    }

    public void vistaEncuesta(int i){
        System.out.println(nombre);
        System.out.print("    ");
        System.out.println(getEncuesta(i).getFechaDeToma());
        getEncuesta(i).listarDias();
    }


}
