import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Aplicacion aplicacion = new Aplicacion(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		cargarDatosDeEjemplo(aplicacion );

		while (true) {

			mostrarMenu();

			int opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				agregarPaciente(aplicacion, scanner);
				break;
			case 2:
				agregarAlimento(aplicacion, scanner);
				break;
			case 3:
				aplicacion.iniciarEncuesta();
				break;
			case 4:
				aplicacion.listarPacientes();
				break;
			case 5:
				aplicacion.listarAlimentos();
				break;
			case 6:
				aplicacion.listarEncuestas();
				break;
			case 7:
				System.out.println("Saliendo del programa...");
				scanner.close();
				return;
			default:
				System.out.println("Opción no válida. Por favor, intente de nuevo.");
				break;
			}
		}
	}

	/**
	 * Muestra por pantalla el menú de opciones
	 */
	private static void mostrarMenu() {

		System.out.println("\nMenú Principal:");
		
		System.out.println("1. Agregar Paciente");
		System.out.println("2. Agregar Alimento");
		System.out.println("3. Iniciar Encuesta");
		System.out.println("4. Listar Pacientes");
		System.out.println("5. Listar Alimentos");
		System.out.println("6. Listar Encuestas");
		System.out.println("7. Salir");
		
		System.out.print("Seleccione una opción: ");

	}

	/**
	 * Registra en el sistema a un nuevo paciente
	 * @param aplicacion
	 * @param scanner
	 */
	private static void agregarPaciente(Aplicacion aplicacion, Scanner scanner) {

		System.out.print("Ingrese el nombre del paciente: ");

		String nombre = scanner.next();

		java.util.Date fechaAlta = new java.util.Date();
		Paciente nuevoPaciente = new Paciente(nombre, fechaAlta);
		aplicacion.agregarPaciente(nuevoPaciente);

		System.out.println("Paciente agregado con éxito.");
	}

	/**
	 * Registra en el sistema un nuevo alimento
	 * @param aplicacion
	 * @param scanner
	 */
	private static void agregarAlimento(Aplicacion aplicacion, Scanner scanner) {
		
		System.out.print("Ingrese el nombre del alimento: ");
		String nombre = scanner.next();
		System.out.print("Ingrese la cantidad (gramos): ");
		double cantidad = scanner.nextDouble();
		System.out.print("Ingrese la marca: ");
		String marca = scanner.next();

		Alimento alimento = new Alimento(nombre, cantidad, marca);
		aplicacion.agregarAlimento(alimento);

		System.out.println("Alimento agregado con éxito.");
	}

	/**
	 * Simula el ingreso de pacientes, encuestas y alimentos en el sistema.
	 * @param aplicacion
	 */
	private static void cargarDatosDeEjemplo(Aplicacion aplicacion) {

		//Alimentos
		ArrayList<Alimento> alimentos = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {

			Alimento alimento = new Alimento("Alimento " + i, 100.0 + i, "Marca " + i);
			alimentos.add(alimento);

			aplicacion.agregarAlimento(alimento);
		}

		//Pacientes 
		for (int i = 1; i <= 5; i++) {

			Paciente paciente = new Paciente("Paciente " + i, new Date());
			aplicacion.agregarPaciente(paciente);

			//Registra una encuesta para cada paciente
			HashMap<String, ArrayList<String>> contenidoEncuesta = new HashMap<>();
			contenidoEncuesta.put("Desayuno", new ArrayList<>(Arrays.asList(alimentos.get(i * 2 - 2).getNombre(), alimentos.get(i * 2 - 1).getNombre())));

			Encuesta encuesta = new Encuesta(paciente, new Date());
			encuesta.setContenido(contenidoEncuesta);

			aplicacion.agregarEncuesta(encuesta);

			paciente.getEncuestas().add(encuesta);
		}
	}

}
