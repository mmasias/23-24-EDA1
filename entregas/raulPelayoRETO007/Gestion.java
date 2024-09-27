
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestion {
    private Arbol<DatosArbol> arbol;
    private Scanner sc;
    private DateTimeFormatter formato;

    public Gestion() {
        this.arbol = new Arbol<DatosArbol>(null);
        this.sc = new Scanner(System.in);
        // Define el formato en el que se va a meter la fecha
        this.formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    }

    public void insertarPaciente() {
        String nombre = "";
        LocalDate fecha = null;
        boolean ok = true;

        System.out.println("Introduzca el nombre del paciente: ");
        nombre = sc.nextLine();

        System.out.println("Introduce la fecha de alta (dd-mm-aaaa): ");

        do {
            try {
                ok = true;
                fecha = LocalDate.parse(sc.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Fecha incorrecta");
                ok = false;
            }
        } while (!ok);

        Paciente paciente = new Paciente(nombre, fecha);
        NodoArbol<DatosArbol> nodoPaciente = new NodoArbol<DatosArbol>(paciente);
        arbol.setRaiz(nodoPaciente);
    }

    public void insertarEncuesta() {
        LocalDate fecha = null;
        boolean ok = true;

        System.out.println("Introduce la fecha de la encuesta (dd-mm-aaaa): ");
        do {
            try {
                ok = true;
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

        int dia = 0;
        boolean ok = true;
        Ingesta ingesta = null;
        String opcion2 = "";
        int opcion = 0;
        Horario horario= null;

        do {
            do {
                System.out.println("Indica el día en el que vas a evaluar la dieta: " + " (0 para salir)");
                try {
                    dia = sc.nextInt();
                } catch (NumberFormatException e) {
                    dia = -1;
                    System.out.println("Pon un número y no un texto anda");
                }
            } while (dia < 0 || dia > arbol.getRaiz().getHijos().getObjeto(0).getHijos().size());

            if (dia == 0) {
                break;
            }
            NodoArbol<DatosArbol> nodoDia = arbol.getRaiz().getHijos().getObjeto(0).getHijos().getObjeto(dia - 1);

            do {
                ok = true;
                System.out.println(
                        "Seleccione ingesta: 1(Desayuno) | 2(MediaMañana) | 3(Almuerzo) | 4(Merienda) | 5(Cena) | -1(Menu anterior)");

                try {
                    opcion = sc.nextInt();
                } catch (NumberFormatException e) {
                    ok = false;
                    System.out.println("Pon un número y no un texto anda");
                }

               

                switch (opcion) {
                    case 1:
                        horario = Horario.DESAYUNO;
                        break;
                    case 2:
                        horario = Horario.MEDIAMAÑANA;
                        break;
                    case 3:
                       horario= Horario.ALMUERZO;
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
                        System.out.println("Opción incorrecta");
                        ok = false;
                        break;
                }

            } while (!ok);

            NodoArbol<DatosArbol> nodoIngesta = existeNodoIngesta(dia, horario);
            if (nodoIngesta != null) {
                ingesta=(Ingesta) nodoIngesta.getValor();
            }else{
                ingesta = new Ingesta(horario);
            }

            do {
                System.out.println("Ingrese un alimento del " + ingesta.getHorario() + " del dia " + dia
                        + " (-1 para terminar | -2 para listar alimentos ingresados | -3 para borrar alimentos ingresados)");

                Scanner sc = new Scanner(System.in);
                opcion2 = sc.nextLine();

                if (opcion2.equals("-2")) {
                    System.out.println(ingesta.getInfo());
                } else if (opcion2.equals("-3")) {
                    ingesta.vaciar();
                } else if (!opcion2.equals("-1")) {
                    do {
                        System.out.println("Inserta los gramos de los alimentos");
                        try {
                            ok = true;
                            sc = new Scanner(System.in);
                            int gramos = sc.nextInt();

                            // La opcion2 puede ser o el nombre del alimento o la opción escogida
                            ingesta.insertarAlimento(new Alimento(opcion2, gramos));
                        } catch (InputMismatchException e) {
                            System.out.println("Gramos no válidos");
                            ok = false;
                        }
                    } while (!ok);
                }
            } while (!opcion2.equals("-1"));
            

            if (ingesta != null && nodoIngesta == null) {
                nodoDia.insertarHijo(new NodoArbol<DatosArbol>(ingesta));
            }
            if (nodoIngesta != null) {
                nodoIngesta.setValor(ingesta);
            }


            if (ingesta != null) {
                nodoDia.insertarHijo(new NodoArbol<DatosArbol>(ingesta));
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

    public NodoArbol<DatosArbol> existeNodoIngesta(int dia, Horario horario){
        NodoArbol<DatosArbol> result=null;
        NodoArbol<DatosArbol> nodoDia = arbol.getRaiz().getHijos().getValorPorPosicion(0).getHijos().getValorPorPosicion(dia -1);

        GenericList<NodoArbol<DatosArbol>> nodoIngesta = nodoDia.getHijos();

        for( int i =0; i< nodoIngesta.size(); i++){
            Ingesta ing= (Ingesta) nodoIngesta.getValorPorPosicion(i).getValor();

            if (ing.getHorario() == horario) {
                result= nodoIngesta.getValorPorPosicion(i);
                break;
            }
        }

        return result;
    }

    public void Estadisticas(){
        int total= arbol.totalCaloriasEnc(arbol.getRaiz());
        System.out.println("Total calorias en cinco dias " + total);
        System.out.println("Promedio diario: " + total/5);

        if (total/5<1600) {
            System.out.println(" Consumo de calorias por debajo de las recomendadas ");
        }else if (total/5>2000) {
            System.out.println(" Consumo de calorias excesivo. Se recomienda aumentar el ejercicio fisico ");
        }
        System.out.println("Fruta: " + arbol.totalTipoEnc(arbol.getRaiz(), "Fruta"));
    }


}