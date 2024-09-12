import java.util.Date;
import java.util.ArrayList;
/**
 * Clase Paciente que contiene todos los atributos y métodos correpondientes
 * a un Paciente registrado en el sistema
 */
public class Paciente {
	
	private static int contadorId = 0; 
    private int id;
	private String nombre;
    private Date fechaAlta;
    private ArrayList<Encuesta> encuestas;
    
    /**
     * Constructor de la clase Paciente
     * @param nombre
     * @param fechaAlta
     */
	public Paciente(String nombre, Date fechaAlta) {
		this.id = ++contadorId;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.encuestas = new ArrayList<Encuesta>() ;
	}
	
	/**
	 * Devuelve el id asociado al paciente
	 * @return
	 */
	public int getId() {
        return id;
    }

	/**
	 * Devuelve el nombre asociado al paciente
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del paciente
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la fecha de alta del paciente en el sistema
	 * @return
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * Establece la fecha de alta del paciente en el sistema
	 * @return
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Devuelve el historial de encuesttas del paciente 
	 * @return
	 */
	public ArrayList<Encuesta> getEncuestas() {
		return encuestas;
	}

	/**
	 * Establece el historial de encuesttas del paciente 
	 * @return
	 */
	public void setEncuestas(ArrayList<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}
	
	@Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", encuestas=" + encuestas +
                '}';
    }
}
