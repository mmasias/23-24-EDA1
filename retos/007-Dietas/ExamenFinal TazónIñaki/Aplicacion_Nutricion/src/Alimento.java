
/**
 * Clase que contiene todos los atributos y métodos correspondientes
 * a los alimentos registrados en el sistema
 */
public class Alimento {

	private static int contadorId = 0; 
    private int id;
	private String nombre;
	private Double cantidad;
	private String marca;
	
	/**
	 * Constructor de la clase Alimento
	 * @param nombre
	 * @param cantidad
	 * @param marca
	 */
	public Alimento(String nombre, Double cantidad, String marca) {
		this.id = ++contadorId;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.marca = marca;
	}
	
	/**
	 * Devuelve el id asociado al alimento
	 * @return
	 */
	public int getId() {
        return id;
    }
	
	/**
	 * Devuelve el nombre asociado al alimento
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Establece el nombre del alimento
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve la cantidad ingerida del alimento
	 * @return
	 */
	public Double getCantidad() {
		return cantidad;
	}
	
	/**
	 * Establece la cantidad ingerida del alimento
	 * @return
	 */
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * Devuelve la marca correspondiente al alimento
	 * @return
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * Establece la marca correspondiente al alimento
	 * @return
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Override
	public String toString() {
        return "Alimento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", marca='" + marca + '\'' +
                '}';
    }
}
