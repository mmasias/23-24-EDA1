import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestion {

    private Scanner sc;
    private Arbol<DatosArbol> arbol;
    DateTimeFormatter formato;

    public Gestion() {
        this.arbol = new Arbol<DatosArbol>(null);
        this.sc = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void insertarPaciente() {
        String nombre;
        LocalDate fecha = null;
        System.out.println("Introduzca el nombre: ");
        nombre = sc.nextLine();

        boolean okey = true;
        do {
            System.out.println("Introduzca la fecha(dd/MM/aaaa): ");
            try {
                fecha = LocalDate.parse(sc.nextLine(), formato);
                okey = true;
            } catch (Exception e) {
                System.out.println("Fecha incorrecta, escriba una valida(dd/MM/aaaa)");
                okey = false;
            }
        } while (!okey);

        Paciente p = new Paciente(nombre, fecha);
        NodoArbol<DatosArbol> nodoPaciente = new NodoArbol<>(p);
        arbol.setRaiz(nodoPaciente);
    }

    public void insertarEncuesta() {
        LocalDate fecha = null;
        boolean okey = true;

        do {
            System.out.println("Introduzca la fecha de la encuesta(dd/MM/aaaa): ");
            try {
                fecha = LocalDate.parse(sc.nextLine(), formato);
                okey = true;
            } catch (Exception e) {
                System.out.println("Fecha incorrecta, escriba una valida(dd/MM/aaaa)");
                okey = false;
            }
        } while (!okey);
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
        boolean okey = true;
        Ingesta ing = null;
        String opcion2 = null;
        int dia = 0;

        do {

            do {
                System.out.println("Seleccione dia(1-5): (0 para salir)");
                try {
                    dia = sc.nextInt();
                } catch (NumberFormatException e) {
                    dia = -1;
                    System.out.println("Seleccione un día válido(1-5)");
                }
            } while (dia < 0 || dia > arbol.getRaiz().getHijos().getObjeto(0).getHijos().size());

            if (dia == 0)
                break;

            NodoArbol<DatosArbol> nodoDia = arbol.getRaiz().getHijos().getObjeto(0).getHijos().getObjeto(dia - 1);
            int opcion = 0;
            Horario horario = null;
            do {
                okey = true;
                System.out.println(
                        "Seleccione ingesta: 1(Desayuno)/2(Mediamañana)/3(Almuerzo)/4(Merienda)/5(Cena)/-1(Menu Anterior)");
                try {
                    opcion = sc.nextInt();
                } catch (NumberFormatException e) {
                    okey = false;
                    System.out.println("Escoge una opción correcta");
                }

                switch (opcion) {
                    case 1:
                        horario = Horario.DESAYUNO;
                        break;
                    case 2:
                        horario = Horario.MEDIAMAÑANA;
                        break;
                    case 3:
                        horario = Horario.ALMUERZO;
                        break;
                    case 4:
                        horario = Horario.MERIENDA;
                        break;
                    case 5:
                        horario = Horario.CENA;
                        break;
                    case -1:
                        break;
                    default:
                        okey = false;
                        System.out.println("Opción incorrecta, elija otra opción");
                        break;

                }
            } while (!okey);

            NodoArbol<DatosArbol> nodoIngesta = existeNodoIngesta(dia, horario);
            if (nodoIngesta != null) {
                ing = (Ingesta) nodoIngesta.getValor();
            } else {
                ing = new Ingesta(horario);
            }

            do {
                int gramos = 0;
                System.out.println("Ingrese un alimento del " + ing.getHorario().getDescription() + " del dia " + dia
                        + " (-1 para terminar / -2 para listar alimentos ingresados / -3 para vaciar la lista)");
                sc = new Scanner(System.in);
                opcion2 = sc.nextLine();
                if (opcion2.equals("-2")) {
                    System.out.println(ing.getInfo());
                } else if (opcion2.equals("-3")) {
                    ing.vaciar();

                } else if (!opcion2.equals("-1")) {
                    try {
                        System.out.println("Introduzca la cantidad de gramos: ");
                        gramos = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Ingrese una cantidad válida");
                    }
                    ing.insertarAlimento(new Alimento(opcion2, gramos));
                }

            } while (!opcion2.equals("-1"));

            if (ing != null && nodoIngesta == null) {
                nodoDia.insertarHijos(new NodoArbol<DatosArbol>(ing));
            }
            if (nodoIngesta != null) {
                nodoIngesta.setValor(ing);
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

    public NodoArbol<DatosArbol> existeNodoIngesta(int dia, Horario horario) {
        NodoArbol<DatosArbol> result = null;
        NodoArbol<DatosArbol> nodoDia = arbol.getRaiz().getHijos().getValorPorPosicion(0).getHijos()
                .getValorPorPosicion(dia - 1);
        GenericList<NodoArbol<DatosArbol>> nodosIngesta = nodoDia.getHijos();
        for (int i = 0; i < nodosIngesta.size(); i++) {
            Ingesta ing = (Ingesta) nodosIngesta.getValorPorPosicion(i).getValor();
            if (ing.getHorario() == horario) {
                result = nodosIngesta.getValorPorPosicion(i);
                break;

            }

        }
        return result;
    }

    public void estadisticas() {
        int total = arbol.totalCaloriasEnc(arbol.getRaiz());
        System.out.println("Total calorias en cinco dias: " + total);
        System.out.println("Promedio diario: " + total / 5);
        if (total / 5 < 1600) {
            System.out.println("Consumo de calorias por debajo de las recomendadas");
        } else if (total / 5 > 3000) {
            System.out.println("Consumo de calorias excesivo. Se recomienda aumentar el ejercicio físico ");
        }
        int fruta = arbol.totalTipoEnc(arbol.getRaiz(), " Fruta: ");
        System.out.println(" Fruta " + fruta);
        if (fruta < 3) {
            System.out.println(" Deberias comer mas fruta ");
        }
        int Verdura = arbol.totalTipoEnc(arbol.getRaiz(), " Verdura: ");
        if (Verdura < 1) {
            System.out.println(" Sube el consumo de verdura ");
        }
        int dulce = arbol.totalTipoEnc(arbol.getRaiz(), " Dulce: ");
        if (dulce > 3) {
            System.out.println(" Baja el consumo de dulces ");
        }
        int Pescado = arbol.totalTipoEnc(arbol.getRaiz(), " Pescado: ");
        if (Pescado > 4) {
            System.out.println(" Estas tomando un exceso de pescado ");
        }
        int Carne = arbol.totalTipoEnc(arbol.getRaiz(), " Carne: ");
        if (Carne > 4) {
            System.out.println(" Estas tomando un exceso de carne ");
        }
    }
}