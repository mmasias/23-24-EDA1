package ExamenFinal;

import ExamenFinal.utils.generica.GenericList;
import java.util.Scanner;

public class EncuestaNutricional {
    GenericList<Comida> comidasDelDia = new GenericList<>();
    Comida comida = new Comida();

    public void creaEncuestaNutricional() {
        System.out.println("¡Bienvenido a la Encuesta Nutricional del UNEATLANTICO!");
        System.out.print("Indique su nombre o el del paciente: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Vamos a realizarle la Encuesta Nutricional a " + nombre);
        añadeDias();
        sc.close();
    }

    public void añadeDias() {
        System.out.print("Seleccione un día (1-5): ");
        Scanner sc = new Scanner(System.in);
        int dia = sc.nextInt();
        comida.dia = dia;
        switch (dia) {
            case 1:
                System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú Anterior)");
                int ingesta = sc.nextInt();
                switch (ingesta) {
                    case 1:
                        comida.creaDesayuno();
                        break;
                    case 2:
                        comida.creaMedia();
                        break;
                    case 3:
                        comida.creaAlmuerzo();
                        break;
                    case 4:
                        comida.creaMerienda();
                        break;
                    case 5:
                        comida.creaCena();
                        break;
                    case -1:
                        System.out.println("Menú anterior");
                        creaEncuestaNutricional();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        añadeDias();
                        break;
                }
                break;
            case 2:
                System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú Anterior)");
                int ingesta2 = sc.nextInt();
                switch (ingesta2) {
                    case 1:
                        comida.creaDesayuno();
                        break;
                    case 2:
                        comida.creaMedia();
                        break;
                    case 3:
                        comida.creaAlmuerzo();
                        break;
                    case 4:
                        comida.creaMerienda();
                        break;
                    case 5:
                        comida.creaCena();
                        break;
                    case -1:
                        System.out.println("Menú anterior");
                        creaEncuestaNutricional();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        añadeDias();
                        break;
                }
                break;
            case 3:
            System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú Anterior)");
            int ingesta3 = sc.nextInt();
            switch (ingesta3) {
                case 1:
                    comida.creaDesayuno();
                    break;
                case 2:
                    comida.creaMedia();
                    break;
                case 3:
                    comida.creaAlmuerzo();
                    break;
                case 4:
                    comida.creaMerienda();
                    break;
                case 5:
                    comida.creaCena();
                    break;
                case -1:
                    System.out.println("Menú anterior");
                    creaEncuestaNutricional();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    añadeDias();
                    break;
            }
                break;
            case 4:
            System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú Anterior)");
            int ingesta4 = sc.nextInt();
            switch (ingesta4) {
                case 1:
                    comida.creaDesayuno();
                    break;
                case 2:
                    comida.creaMedia();
                    break;
                case 3:
                    comida.creaAlmuerzo();
                    break;
                case 4:
                    comida.creaMerienda();
                    break;
                case 5:
                    comida.creaCena();
                    break;
                case -1:
                    System.out.println("Menú anterior");
                    creaEncuestaNutricional();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    añadeDias();
                    break;
            }
                break;
            case 5:
            System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú Anterior)");
            int ingesta5 = sc.nextInt();
            switch (ingesta5) {
                case 1:
                    comida.creaDesayuno();
                    break;
                case 2:
                    comida.creaMedia();
                    break;
                case 3:
                    comida.creaAlmuerzo();
                    break;
                case 4:
                    comida.creaMerienda();
                    break;
                case 5:
                    comida.creaCena();
                    break;
                case -1:
                    System.out.println("Menú anterior");
                    creaEncuestaNutricional();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    añadeDias();
                    break;
            }
                break;
            default:
                System.out.println("Día no válido");
                añadeDias();
                break;
        }
        sc.close();
    }
    
}
