import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EncuestaNutricional {

    Arbol arbol = new Arbol("EncuestaNutricional");
    Nodo Nodo = new Nodo("EncuestaNutricional", null);

    List<Nodo> lista = new ArrayList<Nodo>();
    Comida Comida = new Comida();

    Nodo raiz=new Nodo("EncuestaNutricional",null);
    Nodo dia1=new Nodo("dia1",raiz);
    Nodo dia2=new Nodo("dia2",raiz);
    Nodo dia3=new Nodo("dia3",raiz);
    Nodo dia4=new Nodo("dia4",raiz);
    Nodo dia5=new Nodo("dia5",raiz);
    Nodo desa=new Nodo("Comida",dia1);
    Nodo media=new Nodo("almuerzo",dia1);
    Nodo almu=new Nodo("almuerzo",dia1);
    Nodo merienda=new Nodo("merienda",dia1);
    Nodo cena=new Nodo("cena",dia1);

    public EncuestaNutricional() {
        lista.add(Nodo);
    }

    public void añadirNodo(String dato, Nodo padre){
        Nodo hijo = new Nodo(dato, padre);
        lista.add(hijo);
    }
    public void añadirNodo(Nodo Nodo){
        lista.add(Nodo);
    }

    public void creaEncuestaNutricional() {
        System.out.println("EncuestaNutricional sobre alimentacion");
        System.out.println("Indique su nombre o el del paciente");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Se procede a realizar la EncuestaNutricional para " + nombre);
        arbol.creaRaiz("EncuestaNutricional");
        añadirNodo("EncuestaNutricional", null);
        rellenadias();
        sc.close();
    }
    public void rellenadias(){
        System.out.println("Indique que dia va ha añadir (1-5)");
        Scanner sc = new Scanner(System.in);
        int dia = sc.nextInt();
        arbol.setDias(dia);
        switch (dia) {
            case 1:
                System.out.println("Seleccione ingesta: 1 (Comida) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)/-1 (Menu Anterior)");
                int ingesta = sc.nextInt();
                switch (ingesta) {
                    case 1:
                        Comida.creaComida();
                        arbol.añaderama(Comida.getLista(), dia1);
                        break;
                    case 2:
                        Comida.creamedia();
                        arbol.añaderama(Comida.getLista(), dia1);
                        break;
                    case 3:
                        Comida.creaalmu();
                        arbol.añaderama(Comida.getLista(), dia1);
                        break;
                    case 4:
                        Comida.creamerienda();
                        arbol.añaderama(Comida.getLista(), dia1);
                        break;
                    case 5:
                        Comida.creacena();
                        arbol.añaderama(Comida.getLista(), dia1);
                        break;
                    case -1:
                        System.out.println("Menu anterior");
                        creaEncuestaNutricional();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        rellenadias();
                        break;



                }
            case 2:
                System.out.println("Seleccione ingesta: 1 (Comida) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)/-1 (Menu Anterior)");
                int ingesta2 = sc.nextInt();
                switch (ingesta2) {
                    case 1:
                        Comida.creaComida();
                        arbol.añaderama(Comida.getLista(), dia2);
                        break;
                    case 2:
                        Comida.creamedia();
                        arbol.añaderama(Comida.getLista(), dia2);
                        break;
                    case 3:
                        Comida.creaalmu();
                        arbol.añaderama(Comida.getLista(), dia2);
                        break;
                    case 4:
                        Comida.creamerienda();
                        arbol.añaderama(Comida.getLista(), dia2);
                        break;
                    case 5:
                        Comida.creacena();
                        arbol.añaderama(Comida.getLista(), dia2);
                        break;
                    case -1:
                        System.out.println("Menu anterior");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;



                }
            case 3:
                System.out.println("Seleccione ingesta: 1 (Comida) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)/-1 (Menu Anterior)");
                int ingesta3 = sc.nextInt();
                switch (ingesta3) {
                    case 1:
                        Comida.creaComida();
                        arbol.añaderama(Comida.getLista(), dia3);
                        break;
                    case 2:
                        Comida.creamedia();
                        arbol.añaderama(Comida.getLista(), dia3);
                        break;
                    case 3:
                        Comida.creaalmu();
                        arbol.añaderama(Comida.getLista(), dia3);
                        break;
                    case 4:
                        Comida.creamerienda();
                        arbol.añaderama(Comida.getLista(), dia3);
                        break;
                    case 5:
                        Comida.creacena();
                        arbol.añaderama(Comida.getLista(), dia3);
                        break;
                    case -1:
                        System.out.println("Menu anterior");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;



                }
            case 4:
                System.out.println("Seleccione ingesta: 1 (Comida) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)/-1 (Menu Anterior)");
                int ingesta4 = sc.nextInt();
                switch (ingesta4) {
                    case 1:
                        Comida.creaComida();
                        arbol.añaderama(Comida.getLista(), dia4);
                        break;
                    case 2:
                        Comida.creamedia();
                        arbol.añaderama(Comida.getLista(), dia4);
                        break;
                    case 3:
                        Comida.creaalmu();
                        arbol.añaderama(Comida.getLista(), dia4);
                        break;
                    case 4:
                        Comida.creamerienda();
                        arbol.añaderama(Comida.getLista(), dia4);
                        break;
                    case 5:
                        Comida.creacena();
                        arbol.añaderama(Comida.getLista(), dia4);
                        break;
                    case -1:
                        System.out.println("Menu anterior");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;



                }
            case 5:
                System.out.println("Seleccione ingesta: 1 (Comida) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)/-1 (Menu Anterior)");
                int ingesta5 = sc.nextInt();
                switch (ingesta5) {
                    case 1:
                        Comida.creaComida();
                        arbol.añaderama(Comida.getLista(), dia5);
                        break;
                    case 2:
                        Comida.creamedia();
                        arbol.añaderama(Comida.getLista(), dia5);
                        break;
                    case 3:
                        Comida.creaalmu();
                        arbol.añaderama(Comida.getLista(), dia5);
                        break;
                    case 4:
                        Comida.creamerienda();
                        arbol.añaderama(Comida.getLista(), dia5);
                        break;
                    case 5:
                        Comida.creacena();
                        arbol.añaderama(Comida.getLista(), dia5);
                        break;
                    case -1:
                        System.out.println("Menu anterior");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;



                }
            default:
                System.out.println("Opcion no valida");
                break;

        }
    }


}