import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Horario;
import modelo.alimentos.Alimento;
import modelo.arbol.Arbol;
import modelo.arbol.DatosArbol;
import modelo.arbol.NodoArbol;
import modelo.encuestas.Dia;
import modelo.encuestas.Encuesta;
import modelo.encuestas.Ingesta;
import modelo.estructuras.GenericList;
import modelo.pacientes.Paciente;

public class Gestion {
    private Arbol<DatosArbol> arbol;
    private Scanner sc;
    private DateTimeFormatter formato;

    public Gestion() {
        this.arbol = new Arbol<>(null);
        this.sc = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public void insertarPaciente() {
        String nombre;
        LocalDate fecha = null;
        System.out.println("Paciente: ");
        nombre = sc.nextLine();
        boolean ok = true;
        do {
            ok = true;
            System.out.println("Introduzca la fecha (dd-mm-aaaa): ");
            try {
                fecha = LocalDate.parse(sc.nextLine(), formato);

            } catch (Exception e) {
                System.out.println("Fecha incorrecta");
                ok = false;
            }
        } while (!ok);

        Paciente p = new Paciente(nombre, fecha);
        NodoArbol<DatosArbol> nodoPaciente = new NodoArbol<DatosArbol>(p);
        arbol.setRaiz(nodoPaciente);
    }

    public void insertarEncuesta() {
        LocalDate fecha = null;
        boolean ok = true;
        do {
            System.out.println("Introduzca la fecha de la encuesta (dd-mm-aaaa): ");
            try {
                fecha = LocalDate.parse(sc.nextLine(), formato);
                ok = true;
            } catch (Exception e) {
                System.out.println("Fecha incorrecta");
                ok = false;
            }
        } while (!ok);

        Encuesta encuesta = new Encuesta(fecha);
        arbol.getRaiz().insertarHijos(new NodoArbol<DatosArbol>(encuesta));

    }

    public void insertarDias() {
        NodoArbol<DatosArbol> nodoEncuesta = arbol.getRaiz().getHijos().getObjeto(0);
        for (int i = 1; i <= 5; i++) {
            Dia dia = new Dia(i);
            nodoEncuesta.insertarHijos(new NodoArbol<DatosArbol>(dia));
        }
    }

    public void insertarIngestas() {
        int dia;
        boolean salirIngesta = false;
        Ingesta ing = null;
        NodoArbol<DatosArbol> nodoIngesta = null;
    
        do {
            do {
                System.out.println("Seleccione día: [(0) para salir]");
                try {
                    dia = sc.nextInt();
                } catch (InputMismatchException e) {
                    dia = -1;
                    System.out.println("El día no existe");
                } finally {
                    sc.nextLine();
                }
            } while (dia < 0 || dia > arbol.getRaiz().getHijos().getValorPorPosicion(0).getHijos().size());
    
            if (dia == 0) {
                break;
            }
    
            NodoArbol<DatosArbol> nodoDia = arbol.getRaiz().getHijos().getValorPorPosicion(0).getHijos().getValorPorPosicion(dia - 1);
    
            int opcion = 0;
    
            // Inicializar salirIngesta dentro del bucle del día
            salirIngesta = false;
    
            do {
                System.out.println(
                        "Seleccione ingesta: [(1) Desayuno / (2) Media mañana / (3) Almuerzo / (4) Merienda / (5) Cena / (-1) Menu anterior]");
                try {
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Opción incorrecta");
                    opcion = -1;
                } finally {
                    sc.nextLine();
                }
    
                // Restablecer salirIngesta a false en cada iteración
                salirIngesta = false;
    
                Horario horario = null;
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
                        salirIngesta = true;
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        break;
                }
    
                // Compruebo si con anterioridad hemos añadido este tipo de ingesta. Es caso afirmativo lo recuperamos
                nodoIngesta = existeNodoIngesta(dia, horario);
                if (nodoIngesta != null) {
                    ing = (Ingesta) nodoIngesta.getValor();
                } else {
                    ing = new Ingesta(horario);
                }
    
                if (!salirIngesta && ing != null) {
                    do {
                        System.out.println(
                                "Ingrese un alimento del " + ing.getHorario().getDescription() + " del día " + dia
                                        + " [(-1) Menu anterior / (-2) Listar alimentos ingresados / (-3) Vaciar]");
    
                        sc = new Scanner(System.in);
                        String opcion2 = sc.nextLine();
    
                        if (opcion2.equals("-1")) {
                            break;
                        } else if (opcion2.equals("-2")) {
                            System.out.println(ing.getInformacion());
                        } else if (opcion2.equals("-3")) {
                            ing.vaciar();
                        } else {
                            System.out.println("Introduzca los gramos del alimento: ");
                            try {
                                int gramos = sc.nextInt();
                                ing.insertarAlimento(new Alimento(opcion2, gramos));
                            } catch (InputMismatchException e) {
                                System.out.println("Gramos no válidos");
                                sc.nextLine();
                            }
                        }
                    } while (true);
    
                    if (ing != null && nodoIngesta == null) {
                        nodoDia.insertarHijos(new NodoArbol<DatosArbol>(ing));
                    }
                    if (nodoIngesta != null) {
                        nodoIngesta.setValor(ing);
                    }
                }
            } while (!salirIngesta);
    
        } while (true);
    }
    

    public void capturarDatos() {
        insertarPaciente();
        insertarEncuesta();
        insertarDias();
        insertarIngestas();
    }

    public void mostrar() {
        arbol.preOrden(arbol.getRaiz(), "");
    }

    public NodoArbol<DatosArbol> existeNodoIngesta(int dia, Horario horario) {
        NodoArbol<DatosArbol> result = null;

        NodoArbol<DatosArbol> nodoDia = arbol.getRaiz().getHijos().getValorPorPosicion(0).getHijos()
                .getValorPorPosicion(dia - 1);
        GenericList<NodoArbol<DatosArbol>> nodoIngesta = nodoDia.getHijos();
        for (int i = 0; i < nodoIngesta.size(); i++) {
            Ingesta ing = (Ingesta) nodoIngesta.getValorPorPosicion(i).getValor();
            if (ing.getHorario() == horario) {
                result = nodoIngesta.getValorPorPosicion(i);
                break;
            }
        }
        return result;
    }

    public void estadisticas() {
        int total = arbol.totalCaloriasEnc(arbol.getRaiz());
        System.out.println("Total de calorias en 5 dias: " + total);
        System.out.println("Promedio diario: " + total / 5);

        if(total/5 < 1600) {
            System.out.println("El paciente no ha consumido las calorias necesarias");
        } else if (total/5 > 2000) {
            System.out.println("El paciente ha consumido demasiadas calorias");
        }
        System.out.println("Fruta: " + arbol.totalTipoEnc(arbol.getRaiz(), "Fruta"));
    }
}
