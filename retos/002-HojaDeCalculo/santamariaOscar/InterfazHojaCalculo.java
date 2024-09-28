import java.util.Scanner;

public class InterfazHojaCalculo {
    private HojaCalculo hojaCalculo;
    private int filaActual;
    private int columnaActual;
    private Scanner scanner;

    public InterfazHojaCalculo(HojaCalculo hojaCalculo) {
        this.hojaCalculo = hojaCalculo;
        filaActual = 0;
        columnaActual = 0;
        scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        boolean salir = false;

        while (!salir) {
            mostrarHojaCalculo();
            System.out.println("Ingresa un comando para moverte (W/A/S/D)");
            System.out.println("Ingresa el comando 'E' para ingresar texto");
            System.out.println("Ingresa el comando 'Q' para salir");
            System.out.println();
            System.out.println("Estás en la celda " + (char) ('A' + columnaActual) + (filaActual + 1) );
            String comando = scanner.nextLine().toUpperCase();

            switch (comando) {
                case "W":
                    if (filaActual > 0) {
                        filaActual--;
                    }
                    break;
                case "A":
                    if (columnaActual > 0) {
                        columnaActual--;
                    }
                    break;
                case "S":
                    if (filaActual < hojaCalculo.obtenerFilas() - 1) {
                        filaActual++;
                    }
                    break;
                case "D":
                    if (columnaActual < hojaCalculo.obtenerColumnas() - 1) {
                        columnaActual++;
                    }
                    break;
                case "E":
                    System.out.print("Ingresa el texto para la celda: ");
                    String texto = scanner.nextLine();
                    Celda celda = hojaCalculo.obtenerCelda(filaActual, columnaActual);
                    if (celda != null) {
                        if (texto.length() > 7) {
                            texto = texto.substring(0, 7);
                        } else if (texto.length() < 7) {
                            while (texto.length() < 7) {
                                texto += " ";
                            }
                        }
                        celda.establecerContenido(texto);
                    }
                    break;
                case "Q":
                    salir = true;
                    System.out.println("¡Programa finalizado!");
                    break;
                default:
                    System.out.println("Comando no válido. Usa W/A/S/D/E/Q.");
            }
        }
    }

    public void mostrarHojaCalculo() {
        int filas = hojaCalculo.obtenerFilas();
        int columnas = hojaCalculo.obtenerColumnas();

        System.out.println("\nHoja de Cálculo:");

        System.out.print("   ");
        for (int j = 0; j < columnas; j++) {
            System.out.print((char) ('A' + j) + "      ");
        }
        System.out.println();

        System.out.print("   ");
        for (int j = 0; j < columnas; j++) {
            System.out.print("-------");
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            System.out.print(String.format("%2d ", i + 1));
            for (int j = 0; j < columnas; j++) {
                Celda celda = hojaCalculo.obtenerCelda(i, j);
                String contenido = (celda != null) ? celda.obtenerContenido() : "";

                // Si el texto es más largo de 7 caracteres, lo muestra completo
                if (i == filaActual && j == columnaActual) {
                    if (contenido.length() > 7) {
                        System.out.print("[" + contenido + "] ");
                    } else {
                        System.out.print("[" + contenido + "]  ");
                    }
                } else {
                    System.out.print(" " + contenido + "  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
