import java.util.Date;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase Encuesta que contiene todos los atributos y métodos correpondientes
 * a una encuesta registrada en el sistema
 */
public class Encuesta { 
	
	private static int contadorId = 0; 
    private int id;
	private Paciente paciente;
	private Map<String, TreeSet<String>> contenido;
	private Date fecha;
	
	/**
	 * Constructor de la clase Encuesta
	 * @param paciente
	 * @param fecha
	 */
	public Encuesta(Paciente paciente, Date fecha) {
		
		this.id = ++contadorId;
		this.paciente = paciente;
		this.contenido = new HashMap<String, TreeSet<String>>();
		this.fecha = fecha;
	}

	/**
	 * Devuelve el Paciente asociado a la encuesta
	 * @return
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * Modifica el Paciente asociado a la encuesta
	 * @return
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * Devuelve el contenido de la encuesta
	 * @return
	 */
	public Map<String, TreeSet<String>> getContenido() {
		return contenido;
	}

	/**
	 * Establece el contenido de la encuesta
	 * @param contenido
	 */
	public void setContenido(Map<String, TreeSet<String>> contenido) {
		this.contenido = contenido;
	}

	/**
	 * Devuelve la fecha correspondiente a la encuesta
	 * @return
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece la fecha correspondiente a la encuesta
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Devuelve el id asociado a la encuesta
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	@Override
    public String toString() {
        return "Encuesta{" +
                "id=" + id +
                "Paciente=" + paciente.getNombre() +
                ", fecha=" + fecha +
                ", contenido=" + contenido +
                '}';
    }
}
