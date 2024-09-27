import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Ordenador ordenadorDeEncuestas = new Ordenador();
        ordenadorDeEncuestas.pacienteCero("Gabriel Sicacha");
        ordenadorDeEncuestas.introducirAlimento(ordenadorDeEncuestas.getPaciente(0),0,0,0);
        ordenadorDeEncuestas.getPaciente(0).vistaEncuesta(0);
        ordenadorDeEncuestas.menu0();


    }

}