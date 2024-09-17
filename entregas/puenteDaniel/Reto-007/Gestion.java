import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Gestion {

    private Scanner escaner;
    private Arbol<DatosArbol> arbol;
    private DateTimeFormatter formato;

    public Gestion() {
        this.arbol = new Arbol<DatosArbol>(null);
        this.escaner = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void insertarPaciente() {
        String nombre;
        LocalDate fecha = null;
        boolean ok = true;
        System.out.println("Introduzca el nombre: ");
        nombre = escaner.nextLine();
        do {
            System.out.println("Introduzca la fecha de alta con el siguiente formato (dd/MM/yyyy): ");
            try {
                ok = true;
                fecha = LocalDate.parse(escaner.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Fecha incorrecta, escriba una valida");
                ok = false;
            }
        } while (!ok);

        Paciente p = new Paciente(fecha, nombre);

        NodoArbol<DatosArbol> Nodopaciente = new NodoArbol<>(p);
        arbol.setRaiz(Nodopaciente);
    }

    public void insertarEncuesta() {
        LocalDate fecha = null;
        boolean ok = true;
        do {
            System.out.println("Introduzca la fecha de la encuesta con el siguiente formato (dd/MM/yyyy): ");
            try {
                ok = true;
                fecha = LocalDate.parse(escaner.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Fecha incorrecta, escriba una valida");
                ok = false;
            }
        } while (!ok);

        Encuesta e = new Encuesta(fecha);
        arbol.getRaiz().insertarHijos(new NodoArbol<>(e));
    }

    public void insertarDias() {
        NodoArbol<DatosArbol> nodoEncuesta = arbol.getRaiz().getHijos().getObjeto(0);
        for (int i = 1; i <= 5; i++) {
            Dia d = new Dia(i);
            nodoEncuesta.insertarHijos(new NodoArbol<DatosArbol>(d));
        }
    }

    public void insertarIngestas() {
        int dia = 0;
        boolean ok = true;
        String opcion2 = null;
        Ingesta ing = null;

        do {
            do {
                System.out.println("Seleccione dia (1-5) (0) para salir: ");
                try {
                    dia = escaner.nextInt();
                } catch (NumberFormatException e) {
                    dia = -1;
                    System.out.println("Ese numero de dia no existe");
                    ok = false;
                }

            } while (dia < 0 || dia > arbol.getRaiz().getHijos().getObjeto(0).getHijos().size());
            if (dia == 0) {
                break;
            }
            NodoArbol<DatosArbol> nodoDia = arbol.getRaiz().getHijos().getObjeto(0).getHijos().getObjeto(dia - 1);
            int opcion = 0;
            do {
                ok = true;
                System.out.println(
                        "Seleccione ingesta: 1-(Desayuno) / 2-Media Mañana / 3-Almuerzo /4-Merienda / 5-Cena/ -1 - (Menu Anterior)");
                try {
                    opcion = escaner.nextInt();

                } catch (NumberFormatException e) {
                    System.out.println("Inserte un numero no una letra");
                    ok = false;
                }
                switch (opcion) {
                    case 1:
                        ing = new Ingesta(Horario.DESAYUNO);

                        break;
                    case 2:
                        ing = new Ingesta(Horario.MEDIAMAÑANA);

                        break;

                    case 3:
                        ing = new Ingesta(Horario.ALMUERZO);

                        break;
                    case 4:
                        ing = new Ingesta(Horario.MERIENDA);

                        break;
                    case 5:
                        ing = new Ingesta(Horario.CENA);

                        break;
                    case -1:
                        break;

                    default:
                        System.out.println("Opcion incorrecta, elige otra");
                        ok = false;
                        break;
                }
            } while (!ok);

            do {
                System.out.println("Inserte un alimento del " + ing.getHorario().getDescription() + " del dia " + dia
                        + " (-1 para terminar / -2 para listar alimentos ingresados / -3 para vaciar)");
                escaner = new Scanner(System.in);
                opcion2 = escaner.nextLine();
                if (opcion2.equals("-2")) {
                    System.out.println("Los alimentos ya ingresados son: " + ing.getInformacion());
                }else if (opcion2.equals("-3")){
                    ing.vaciar();
                } else if (!opcion2.equals("-1")) {
                    System.out.println("Introduzca la cantidad de gramos: ");
                    int gramos = escaner.nextInt();
                    ing.insertarAlimento(new Alimento(opcion2, gramos));
                }
            } while (!opcion2.equals("-1"));

            if (ing != null) {
                nodoDia.insertarHijos(new NodoArbol<DatosArbol>(ing));
            }

        } while (true);
    }

    public void capturarDatos() {
        insertarPaciente();
        insertarEncuesta();
        insertarDias();
        insertarIngestas();

    }

    public void mostrar() {
        arbol.preOrden(arbol.getRaiz());
    }
}
