import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gestion {
    private Scanner sc;
    private DateTimeFormatter formato;
    private Paciente paciente;
    private Encuesta encuesta;
    private List<Dia> dias;

    public Gestion() {
        this.sc = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dias = new List<>();
        this.encuesta = null;
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

        this.paciente = new Paciente(nombre, fechaDeAlta);
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

        // Solo crear una instancia de Encuesta si no existe
        if (this.encuesta == null) {
            this.encuesta = new Encuesta(fecha);
        } else {
            // Si ya existe una encuesta, establecer la nueva fecha
            this.encuesta.setFecha(fecha);
        }
    }

    public void insertarDia() {
        for (int i = 0; i < 5; i++) {
            this.dias.insertEnd(new Dia(i + 1));
        }
    }

    public void insertarIngesta() {
        boolean ok = true;
        int dia = 0;
        int opcion = 0;
        String opcion2 = "";
        do {
            do {
                System.out.println("Seleccione el dia: (1/5) / (0 para salir)");
                try {
                    sc = new Scanner(System.in);
                    dia = sc.nextInt();
                } catch (Exception e) {
                    dia = -1;
                    System.out.println("Dia no existente");
                }
            } while (dia < 0 || dia > 5);
            if (dia == 0) {
                break;
            }
            if (ok) {
                Ingesta ing = new Ingesta(null);
                do {
                    ok = true;
                    System.out.println("Selecciona la ingesta: 1. (Desayuno) / 2. (Media mañana) / 3. (Almuerzo) / 4. (Merienda) / 5. (Cena) / -1. (Menu anterior)");
                    sc.nextLine();
                    try {
                        opcion = sc.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println("Opcion incorrecta");
                        ok = false;
                    }
                    switch (opcion) {
                        case 1:
                            ing.setHorario(Horario.DESAYUNO.getDescription());
                            break;
                        case 2:
                            ing.setHorario(Horario.MEDIA_MAÑANA.getDescription());
                            break;
                        case 3:
                            ing.setHorario(Horario.ALMUERZO.getDescription());
                            break;
                        case 4:
                            ing.setHorario(Horario.MERIENDA.getDescription());
                            break;
                        case 5:
                            ing.setHorario(Horario.CENA.getDescription());
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
                    do {
                        System.out.println("Ingrese un alimento del " + ing.getHorario() + " del dia " + dia + ". (-1 para terminar) / (-2 para listar alimentos ingresados) / (-3 para borrar todos los alimentos)");
                        sc.nextLine();
                        opcion2 = sc.nextLine(); // alimento o opcion escogida
                        if (opcion2.equals("-1")) {
                            break;
                        } else if (opcion2.equals("-2")) {
                            System.out.println("Los alimentos son: " + ing.getInformacion());
                        } else if (opcion2.equals("-3")) {
                            ing.vaciar();
                        } else {
                            ok = true;
                            System.out.println("Introduce los gramos del alimento: ");
                            int gramos = sc.nextInt();
                            ing.insertarAlimento(new Alimento(opcion2, gramos));
                        }
                    } while (true);
                }
                this.dias.getValorPorPosicion(dia - 1).addIngesta(ing);
            }
        } while (true);
    }

    public void listarResultados() {
        System.out.println("Resultados: ");
        System.out.println(paciente.getInformacion());
        System.out.println(encuesta.getInformacion());
        System.out.println("Total de dias: " + dias.size());
        for (int i = 0; i < dias.size(); i++) {
            Dia dia = dias.getValorPorPosicion(i);
            System.out.println("Dia " + dia.getFecha());
            System.out.println(dia.getInformacion());
        }
        
    }
    public void capturarDatos() {
        insertarPaciente();
        insertarEncuesta();
        insertarDia();
        insertarIngesta();
    }
}
