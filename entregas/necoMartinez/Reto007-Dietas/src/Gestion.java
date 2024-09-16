package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestion {
    private Arbol<DatosArbol> arbol;
    private Scanner sc;
    private DateTimeFormatter formato;

    public Gestion() {
        this.arbol = new Arbol<>(null);
        this.sc = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void insertarPaciente() {
        String nombre = "";
        LocalDate fechaDeAlta = null;
        System.out.println("Introduce el nombre del paciente");
        nombre = sc.nextLine();
        boolean ok = true;
        do {
            ok = true;
            System.out.println("Introduce la fecha de alta del paciente (dd/mm/aaaa)");
            try {
                fechaDeAlta = LocalDate.parse(sc.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Fecha incorrecta");
                ok = false;
            }

        } while (!ok);

        Paciente paciente = new Paciente(nombre, fechaDeAlta);
        NodoArbol<DatosArbol> nodoPaciente = new NodoArbol<DatosArbol>(paciente);
        arbol.setRaiz(nodoPaciente);
    }

    public void insertarEncuesta() {
        LocalDate fecha = null;
        boolean ok = true;
        do {
            ok = true;
            System.out.println("Introduce la fecha de la encuesta (dd/mm/aaaa)");
            try {
                fecha = LocalDate.parse(sc.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Fecha incorrecta");
                ok = false;
            }

        } while (!ok);
        Encuesta encuesta = new Encuesta(fecha);
        NodoArbol<DatosArbol> nodoEncuesta = new NodoArbol<DatosArbol>(encuesta);
        arbol.getRaiz().insertarHijo(nodoEncuesta);
    }

    public void insertarDia() {
        NodoArbol<DatosArbol> nodoEncuesta = arbol.getRaiz().getHijos().getObjeto(0);
        for (int i = 1; i <= 5; i++) {
            Dia dia = new Dia(i);
            nodoEncuesta.insertarHijo(new NodoArbol<DatosArbol>(dia));
        }
    }

    public void insertarIngesta() {

        boolean ok = true;
        int dia = 0;
        Ingesta ing = null;
        int opcion = 0;
        String opcion2 = "";
        Horario horario = null;
        do {
            do {
                System.out.println("Seleccione el dia: (1/5) / (0 para salir)");
                try {
                    dia = sc.nextInt();
                } catch (NumberFormatException e) {
                    dia = -1;
                    System.out.println("Dia no existente");
                }
            } while (dia < 0 || dia > arbol.getRaiz().getHijos().getObjeto(0).getHijos().size());
            if (dia == 0) {
                break;
            }
            NodoArbol<DatosArbol> nodoDia = arbol.getRaiz().getHijos().getObjeto(0).getHijos().getObjeto(dia - 1);
            if (ok) {

                do {
                    ok = true;
                    System.out.println(
                            "Selecciona la ingesta: 1. (Desayuno) / 2. (Media mañana) / 3. (Almuerzo) / 4. (Merienda) / 5. (Cena) / -1. (Menu anterior)");
                    try {
                        opcion = sc.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println("Opcion incorrecta");
                        ok = false;
                    }
                    switch (opcion) {
                        case 1:
                            horario = Horario.DESAYUNO;
                            break;
                        case 2:
                            horario = Horario.MEDIA_MAÑANA;
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
                            ok = false;
                            System.out.println("Opcion incorrecta");
                            break;
                    }
                } while (!ok);
                // Compruebo si con anterioridad hemos añadido ese tipo de ingesta. En caso
                // afirmativo la recuperamos
                if (opcion != -1) {

                    NodoArbol<DatosArbol> nodoIngesta = comprobarSiExiste(dia, horario);
                    if (nodoIngesta != null) {
                        ing = (Ingesta) nodoIngesta.getValue();
                    } else {
                        ing = new Ingesta(horario);
                    }
                    do {
                        System.out.println("Ingrese un alimento del " + ing.getHorario().getDescription() + " del dia "
                                + dia
                                + ". (-1 para terminar) / (-2 para listar alimentos ingresados) / (-3 para borrar todos los alimentos)");
                        sc = new Scanner(System.in);
                        opcion2 = sc.nextLine(); // alimento o opcion escogida
                        if (opcion2.equals("-2")) {
                            System.out.println("Los alimentos son: " + ing.getInformacion());
                        } else if (opcion2.equals("")) {
                            System.out.println("Alimento no valido");

                        } else if (opcion2.equals("-3")) {
                            ing.vaciar();
                        } else if (!opcion2.equals("-1")) {
                            do {
                                ok = true;
                                System.out.println("Introduce los gramos del alimento: ");
                                try {
                                    sc = new Scanner(System.in);
                                    int gramos = sc.nextInt();
                                    ing.insertarAlimento(new Alimento(opcion2, gramos));
                                } catch (InputMismatchException e) {
                                    System.out.println("Gramos incorrectos");
                                    ok = false;
                                }
                            } while (!ok);
                        }
                    } while (!opcion2.equals("-1"));

                    if (ing != null && nodoIngesta == null) {
                        nodoDia.insertarHijo(new NodoArbol<DatosArbol>(ing));
                    }
                    if (nodoIngesta != null) {
                        nodoIngesta.setValue(ing);
                    }
                }
            }
        } while (true);

    }

    public void capturarDatos() {
        insertarPaciente();
        insertarEncuesta();
        insertarDia();
        insertarIngesta();
    }

    public void mostrar() {
        arbol.preOrden(arbol.getRaiz());
    }

    public NodoArbol<DatosArbol> comprobarSiExiste(int dia, Horario horario) {
        NodoArbol<DatosArbol> resultado = null;
        NodoArbol<DatosArbol> nodoDia = arbol.getRaiz().getHijos().getValorPorPosicion(0).getHijos()
                .getValorPorPosicion(dia - 1);
        GenericList<NodoArbol<DatosArbol>> nodoIngesta = nodoDia.getHijos();
        for (int i = 0; i < nodoIngesta.size(); i++) {
            Ingesta ing = (Ingesta) nodoIngesta.getValorPorPosicion(i).getValue();
            if (ing.getHorario() == horario) {
                resultado = nodoIngesta.getValorPorPosicion(i);
                break;
            }
        }
        return resultado;
    }
}
