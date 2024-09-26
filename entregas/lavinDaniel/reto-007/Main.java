import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Encuesta24Horas encuesta = new Encuesta24Horas("Jose Manuel R.");
        encuesta.realizarEncuesta(scanner);
    }
}