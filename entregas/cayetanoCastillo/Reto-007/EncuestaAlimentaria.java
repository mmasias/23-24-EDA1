package ProyectoFinal;

import java.util.Scanner;

public class EncuestaAlimentaria {
    private Paciente paciente;
    private Scanner scanner;
    private double altura;
    private double peso;
    private String sexo;
    private int edad;
    private String frecuenciaEjercicio;

    public EncuestaAlimentaria(String nombrePaciente, double altura, double peso, String sexo, int edad,
            String frecuenciaEjercicio) {
        this.paciente = new Paciente(nombrePaciente);
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.edad = edad;
        this.frecuenciaEjercicio = frecuenciaEjercicio;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarEncuesta() {
        int seleccionDia;
        int seleccionIngesta;
        String seleccionAlimento;

        while (true) {
            System.out.println("Seleccione día (1-5) o -1 para terminar:");
            seleccionDia = scanner.nextInt();
            if (seleccionDia == -1) {
                break;
            }

            // Validar que la selección del día esté en el rango permitido
            if (seleccionDia < 1 || seleccionDia > 5) {
                System.out.println("Por favor, ingrese un número entre 1 y 5 para el día.");
                continue; // Vuelve al inicio del bucle
            }

            DiaAlimentacion dia = paciente.buscarDiaAlimentacion(seleccionDia);
            if (dia == null) {
                dia = new DiaAlimentacion(seleccionDia);
                paciente.agregarDiaAlimentacion(dia);
            }

            while (true) {
                System.out.println(
                        "Seleccione ingesta: 1 (Desayuno), 2 (Media mañana), 3 (Almuerzo), 4 (Merienda), 5 (Cena), -1 (Menú anterior):");
                seleccionIngesta = scanner.nextInt();
                if (seleccionIngesta == -1) {
                    break;
                }

                // Validar que la selección de la ingesta esté en el rango permitido
                if (seleccionIngesta < 1 || seleccionIngesta > 5) {
                    System.out.println("Por favor, ingrese un número entre 1 y 5 para la ingesta.");
                    continue; // Vuelve al inicio del bucle de ingesta
                }

                Ingesta ingesta = dia.buscarIngesta(seleccionIngesta);
                if (ingesta == null) {
                    ingesta = new Ingesta(seleccionIngesta);
                    dia.agregarIngesta(ingesta);
                }

                while (true) {
                    System.out.println("Ingrese un alimento del " + tipoIngesta(seleccionIngesta) + " del día "
                            + seleccionDia + " (-1 para terminar, -2 para listar alimentos ingresados):");
                    seleccionAlimento = scanner.next();
                    if (seleccionAlimento.equals("-1")) {
                        break;
                    } else if (seleccionAlimento.equals("-2")) {
                        listarAlimentos(ingesta);
                    } else {
                        ingesta.agregarAlimento(new Alimento(seleccionAlimento));
                    }
                }

            }
        }

        mostrarResumen();
    }

    private void listarAlimentos(Ingesta ingesta) {
        System.out.println("Alimentos ingresados en " + ingesta.getTipoIngesta() + ":");
        for (Alimento alimento : ingesta.getAlimentos()) {
            System.out.println(alimento.getNombre());
        }
    }

    private String tipoIngesta(int seleccionIngesta) {
        switch (seleccionIngesta) {
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
                return "Desconocido";
        }
    }

    public void mostrarResumen() {
        System.out.println("Resumen de la encuesta alimentaria para: " + paciente.getNombre());
        System.out.println("Edad: " + edad + " años");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Altura: " + altura + " cm");
        System.out.println("Sexo: " + sexo);
        System.out.println("Frecuencia de ejercicio: " + frecuenciaEjercicio);
        for (DiaAlimentacion dia : paciente.getDiasAlimentacion().getAllData()) {
            System.out.println("Día: " + dia.getNumeroDia());
            for (Ingesta ingesta : dia.getIngestas().getAllData()) {
                System.out.println("  Ingesta: " + tipoIngesta(ingesta.getTipoIngesta()));
                for (Alimento alimento : ingesta.getAlimentos()) {
                    System.out.println("    Alimento: " + alimento.getNombre());
                }
            }
        }
    }
}
