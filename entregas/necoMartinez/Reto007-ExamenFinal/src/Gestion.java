package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestion {
    private Scanner sc;
    private DateTimeFormatter formato;

    public Gestion() {
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
        agregarEncuesta(paciente);
    }

    public void agregarEncuesta(Paciente paciente) {
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
        paciente.agregarEncuesta(encuesta);
        agregarDia(encuesta);
    }

    public void agregarDia(Encuesta encuesta) {
        for (int i = 1; i <= 5; i++) {
            Dia dia = new Dia(i);
            encuesta.agregarDia(dia);
            agregarIngesta(dia);
        }
    }

    public void agregarIngesta(Dia dia) {
        boolean ok = true;
        int opcion = 0;
        String opcion2 = "";
        Horario horario = null;
        do {
            do {
                System.out.println("Selecciona la ingesta: 1. (Desayuno) / 2. (Media mañana) / 3. (Almuerzo) / 4. (Merienda) / 5. (Cena) / -1. (Menu anterior)");
                try {
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
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

            if (opcion != -1) {
                Ingesta ing = new Ingesta(horario);
                do {
                    System.out.println("Ingrese un alimento del " + ing.getHorario().getDescription() + ". (-1 para terminar) / (-2 para listar alimentos ingresados) / (-3 para borrar todos los alimentos)");
                    sc.nextLine(); // Consumir la línea en blanco después del nextInt
                    opcion2 = sc.nextLine(); // alimento o opcion escogida
                    if (opcion2.equals("-2")) {
                        System.out.println("Los alimentos son: " + ing.getInformacion());
                    } else if (opcion2.equals("-3")) {
                        ing.vaciar();
                    } else if (!opcion2.equals("-1")) {
                        do {
                            ok = true;
                            System.out.println("Introduce los gramos del alimento: ");
                            try {
                                int gramos = sc.nextInt();
                                ing.insertarAlimento(new Alimento(opcion2, gramos));
                            } catch (InputMismatchException e) {
                                System.out.println("Gramos incorrectos");
                                ok = false;
                            }
                        } while (!ok);
                    }
                } while (!opcion2.equals("-1"));
                dia.agregarIngesta(ing);
            }
        } while (true);
    }

    public void capturarDatos() {
        insertarPaciente();
    }

}
