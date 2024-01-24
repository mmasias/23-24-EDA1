package RetoExamenFinal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Gestion {

    private Scanner escaner;
    private List<DatosLista> listaPrimaria;
    private DateTimeFormatter formato;

    public Gestion() {
        this.listaPrimaria = new ArrayList<>();
        this.escaner = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void insertarPaciente() {
        String nombre;
        LocalDate fechaAlta = null;
        boolean ok = true;
        System.out.println("Introduzca el nombre: ");
        nombre = escaner.nextLine();
        do {
            System.out.println("Introduzca la fecha de alta con el siguiente formato (dd/MM/yyyy): ");
            try {
                ok = true;
                fechaAlta = LocalDate.parse(escaner.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Fecha incorrecta, escriba una valida");
                ok = false;
            }
        } while (ok == false);

        Paciente p = new Paciente(fechaAlta, nombre);

        listaPrimaria.add(p);
        
        
    }

    public void insertarEncuesta() {
        LocalDate fechaEncuesta = null;
        boolean ok = true;
        LocalDate fechaAlta = ((Paciente) listaPrimaria.get(0)).getFechaDeAlta();

        do {
            System.out.println("Introduzca la fecha de la encuesta con el siguiente formato (dd/MM/yyyy): ");
            try {
                ok = true;
                fechaEncuesta = LocalDate.parse(scanner.nextLine(), formato);
                if (fechaEncuesta.isBefore(fechaAlta)) {
                    System.out.println("Error: La fecha de la encuesta no puede ser anterior a la fecha de alta.");
                    ok = false;
                }
            } catch (Exception e) {
                System.out.println("Fecha incorrecta, escriba una válida");
                ok = false;
            }
        } while (!ok);

        Encuesta e = new Encuesta(fechaEncuesta);
        ((Paciente) listaPrimaria.get(0)).setEncuesta(e);
    }

    public void insertarDias() {
        List<DatosLista> hijosEncuesta = ((Encuesta) ((Paciente) listaPrimaria.get(0)).getEncuesta()).getDias();
        for (int i = 1; i <= 5; i++) {
            Dia d = new Dia(i);
            hijosEncuesta.add(d);
        }
    }

    public void insertarIngestas() {
        int dia = 0;
        boolean ok = true;
        String opcionAlimento = null;
        Ingesta ing = null;

        do {
            do {
                System.out.println("Seleccione dia (1-5) (0) para salir: ");
                try {
                    dia = escaner.nextInt();
                    ok = true;
                } catch (InputMismatchException e) {
                    escaner.nextLine();
                    dia=-1;
                    System.out.println("Ese numero de dia no existe");
                    ok = false;
                }
                if (dia < 0 || dia > 5) {
                    System.out.println("Número fuera del rango. Por favor, ingrese un dia entre 1 y 5, o pulse 0 para finalizar la encuesta.");
                    ok = false;  
                }
            

            } while (dia < 0 || dia > ((Encuesta) ((Paciente) listaPrimaria.get(0)).getEncuesta()).getDias().size());
            if (dia == 0) {
                break;
            }
            List<DatosLista> hijosDia = ((Dia) ((Encuesta) ((Paciente) listaPrimaria.get(0)).getEncuesta()).getDias().get(dia - 1)).getIngestas();
            int opcion = 0;
            do {
                ok = true;
                System.out.println(
                        "Seleccione ingesta: 1-Desayuno / 2-Media Mañana / 3-Almuerzo /4-Merienda / 5-Cena/ -1 - (Menu Anterior)");
                try {
                    opcion = escaner.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println("Inserte un número, no una letra");
                    escaner.nextLine();
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
                opcionAlimento = escaner.nextLine();

                if (opcionAlimento.equals("-2")) {
                    System.out.println("Los alimentos ya ingresados son: \n" + ing.getInformacion());
                } else if (opcionAlimento.equals("-3")){
                    ing.vaciar();
                } else if (!opcionAlimento.equals("-1")) {
                    boolean isNumeric = true;
                    int gramos= 0;
                    do {
                        try {
                            System.out.println("Introduzca la cantidad de gramos: ");
                            gramos = Integer.parseInt(escaner.nextLine());
                            if(gramos <= 0){
                                System.out.println("Error: La cantidad de gramos no puede ser negativa.");
                                isNumeric = false;
                            } else {
                                isNumeric = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingrese solo números para la cantidad de gramos.");
                            isNumeric = false;
                        }
                    } while (!isNumeric);
            
                    ing.insertarAlimento(new Alimento(opcionAlimento, gramos));
                }
            } while (!opcionAlimento.equals("-1"));

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


