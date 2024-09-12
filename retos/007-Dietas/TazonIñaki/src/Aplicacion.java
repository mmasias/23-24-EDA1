import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import java.util.HashMap;

/**
 * Clase Aplicación encargada de la gestión de los pacientes, encuestas y alimentos
 * registrados
 */
public class Aplicacion {

	private ArrayList<Paciente> pacientes;
	private ArrayList<Encuesta> encuestas;
	private ArrayList<Alimento> alimentos;

	/**
	 * Constructor de clase
	 * @param pacientes
	 * @param encuestas
	 * @param alimentos
	 */
	public Aplicacion(ArrayList<Paciente> pacientes, ArrayList<Encuesta> encuestas, ArrayList<Alimento> alimentos) {
		this.pacientes = pacientes;
		this.encuestas = encuestas;
		this.alimentos = alimentos;
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public ArrayList<Encuesta> getEncuestas() {
		return encuestas;
	}

	public void setEncuestas(ArrayList<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}

	public ArrayList<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(ArrayList<Alimento> alimentos) {
		this.alimentos = alimentos;
	}
	
	/**
	 * Busca a un determinado paciente (dado su identificador) dentro del registro de pacientes
	 * @param id
	 * @return
	 */
	public Paciente buscaPaciente(int id) {
		
		Paciente paciente = null;
		
		for(Paciente p: pacientes) {
			if(p.getId() == id) {
				paciente = p;
			}
		}
		
		return paciente;
	}

	
	/**
	 * Elimina del registro de pacientes al paciente dado su identificador
	 * @param idPaciente
	 */
	public void eliminarPaciente(int idPaciente) {

		int posEliminar = 0;
		for(Paciente p: pacientes) {

			if(p.getId() == idPaciente){
				this.pacientes.remove(posEliminar);
			}

			posEliminar++;
		}
	}

	/**
	 * Muestra el listado de pacientes registrados
	 */
	public void listarPacientes() {
		for (Paciente p: pacientes) {
			System.out.println(p.toString());
		}
	}
	
	/**
	 * Muestra el listado de encuestas registradas
	 */
	public void listarEncuestas() {
		for (Encuesta e: encuestas) {
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

	/**
	 * Realiza la entrevista con el paciente donde se incluye las comidas realizadas por el paciente
	 * en las últimas 24h.
	 */
	public void iniciarEncuesta() {
		
		Scanner scanner = new Scanner(System.in);

		listarPacientes();
		System.out.print("Seleccione el ID del paciente para la encuesta: ");
		int idPaciente = scanner.nextInt();
		Paciente paciente = buscaPaciente(idPaciente);

		if (paciente == null) {
			System.out.println("Paciente no encontrado.");
			return;
		}

		System.out.println("Paciente: " + paciente.getNombre());

		// Seleccionar un día para la encuesta
		System.out.print("Seleccione día: ");
		int dia = scanner.nextInt();

		// Continuar con la encuesta hasta que el usuario decida volver al menú anterior
		int tipoIngesta;
		do {
			System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)");
			tipoIngesta = scanner.nextInt();

			if (tipoIngesta != -1) {
				registrarIngesta(paciente, dia, tipoIngesta, scanner);
			}
		} while (tipoIngesta != -1);
	}

	/**
	 * Registra una ingesta para un paciente y día determinados
	 * @param paciente
	 * @param dia
	 * @param tipoIngesta
	 * @param scanner
	 */
	public void registrarIngesta(Paciente paciente, int dia, int tipoIngesta, Scanner scanner) {
		
		String tipoIngestaStr = obtenerTipoIngestaStr(tipoIngesta);
		ArrayList<String> alimentosIngesta = new ArrayList<>();

		System.out.println("Registrando " + tipoIngestaStr + " para el día " + dia);
		String alimento;
		
		do {
			
			System.out.print("Ingrese un alimento para " + tipoIngestaStr + " (-1 para terminar / -2 para listar alimentos ingresados): ");
			alimento = scanner.next();

			if (alimento.equals("-1")) {
				break;
			} else if (alimento.equals("-2")) {
				listarAlimentosIngesta(alimentosIngesta);
				
			} else {
				alimentosIngesta.add(alimento);
			}
		} while (true);

		// Agrega la lista de alimentos a la encuesta del paciente
		if (!alimentosIngesta.isEmpty()) {
			agregarAlimentosAEncuesta(paciente, dia, tipoIngestaStr, alimentosIngesta);
		}
	}

	/**
	 * Muestra un listado de los alimentos añadidos a la ingesta durante la encuesta
	 * @param alimentos
	 */
	private void listarAlimentosIngesta(ArrayList<String> alimentos) {
		if (alimentos.isEmpty()) {
			System.out.println("No se han ingresado alimentos aún.");
		} else {
			System.out.println("Alimentos ingresados: " + alimentos);
		}
	}

	/**
	 * Asocia un código número a las diferentes ingestas realizadas en las últimas 24h.
	 * @param tipoIngesta
	 * @return
	 */
	private String obtenerTipoIngestaStr(int tipoIngesta) {
		switch (tipoIngesta) {
		case 1:
			return "Desayuno";
		case 2:
			return "Media mañana";
		case 3:
			return "Almuerzo";
		case 4:
			return "Merienda";
		case 5:
			return "Cena";
		default:
			return "Ingesta desconocida";
		}
	}

	/**
	 * Agrega todos los alimentos proporcionados por el paciente a lo largo de la encuesta
	 * @param paciente
	 * @param dia
	 * @param tipoIngesta
	 * @param alimentos
	 */
	public void agregarAlimentosAEncuesta(Paciente paciente, int dia, String tipoIngesta, ArrayList<String> alimentos) {
		
		Encuesta encuesta = obtenerEncuestaPorPacienteYDia(paciente, dia);

		if (encuesta == null) {
			
			encuesta = crearNuevaEncuesta(paciente, dia);
			this.encuestas.add(encuesta);
			paciente.getEncuestas().add(encuesta);
		}

		HashMap<String, ArrayList<String>> contenido = (HashMap<String, ArrayList<String>>) encuesta.getContenido();
		
		if (!contenido.containsKey(tipoIngesta)) {
			contenido.put(tipoIngesta, new ArrayList<>());
		}
		
		contenido.get(tipoIngesta).addAll(alimentos);
	}

	/**
	 * Obtiene la encuesta correspondiente al paciente dado un día
	 * @param paciente
	 * @param dia
	 * @return
	 */
	private Encuesta obtenerEncuestaPorPacienteYDia(Paciente paciente, int dia) {
		
		Calendar cal = Calendar.getInstance();

		for (Encuesta encuesta : paciente.getEncuestas()) {
			
			cal.setTime(encuesta.getFecha());
			int diaEncuesta = cal.get(Calendar.DAY_OF_MONTH);

			if (diaEncuesta == dia) {
				return encuesta;
			}
		}
		
		return null; // No se encontró una encuesta para ese día
	}

	/**
	 * Crea una nueva encuesta para un paciente en un día específico
	 * @param paciente
	 * @param dia
	 * @return
	 */
	private Encuesta crearNuevaEncuesta(Paciente paciente, int dia) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, dia);

		Date fechaEncuesta = cal.getTime();
		Encuesta nuevaEncuesta = new Encuesta(paciente, fechaEncuesta);
		
		return nuevaEncuesta;
	}

}

