import java.util.TreeSet;


/**
 * Clase Aplicación encargada de la gestión de los pacientes, encuestas y alimentos registrados
 */
public class Aplicacion {

    private TreeSet<Paciente> pacientes;
    private TreeSet<Encuesta> encuestas;
    private TreeSet<Alimento> alimentos;

    /**
     * Constructor de clase
     * @param pacientes
     * @param encuestas
     * @param alimentos
     */
    public Aplicacion(TreeSet<Paciente> pacientes, TreeSet<Encuesta> encuestas, TreeSet<Alimento> alimentos) {
        this.pacientes = pacientes;
        this.encuestas = encuestas;
        this.alimentos = alimentos;
    }

    // Resto del código...

    /**
     * Muestra el listado de pacientes registrados
     */
    public void listarPacientes() {
        for (Paciente p : pacientes) {
            System.out.println(p.toString());
        }
    }

    /**
     * Muestra el listado de encuestas registradas
     */
    public void listarEncuestas() {
        for (Encuesta e : encuestas) {
            System.out.println(e.toString());
        }
    }

    /**
     * Muestra el listado de alimentos registrados
     */
    public void listarAlimentos() {

        if (alimentos.isEmpty()) {
            System.out.println("No hay alimentos registrados.");
        } else {
            for (Alimento alimento : alimentos) {
                System.out.println(alimento);
            }
        }
    }

    // Resto del código...

    /**
     * Registra el paciente indicado en el sistema
     * @param paciente
     */
    public void agregarPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

    /**
     * Registra la encuesta indicada en el sistema
     * @param paciente
     */
    public void agregarEncuesta(Encuesta encuesta) {
        this.encuestas.add(encuesta);
    }

    /**
     * Registra el alimento indicado en el sistema
     * @param paciente
     */
    public void agregarAlimento(Alimento alimento) {
        this.alimentos.add(alimento);
    }

    // Resto del código...
}