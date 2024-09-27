import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Ordenador ordenador = new Ordenador();
        ordenador.anadirPaciente("gabriel");
        ordenador.getPaciente(0).anadirEncuesta("24/01",2);
        ordenador.getPaciente(0).getEncuesta(0).getdia(0).getIngesta(1).agregarAlimento("Pancakes");
        ordenador.vistaCompleta(0,0);


    }

}