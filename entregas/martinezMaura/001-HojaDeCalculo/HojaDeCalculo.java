public class HojaDeCalculo {
    public static void main(String[] args) {
        final int Columnas = 10;
        final int Celdas = 15;
        final int EspacioCelda = 6;


        String[][] hoja = new String[15][10];
        int celdaActual = 0;
        int columnaActual = 0;

        Scanner input = new Scanner(System.in);
        char entradaUsuario;
        boolean salir = false;

        imprimeCabecera();
        muestraHoja(hoja, celdaActual, columnaActual);
        
        while (!salir) {
            System.out.println("Comandos: [W] Arriba, [S] Abajo, [A] Izquierda, [D] Derecha, [q] Salir, [e] Ingresar Texto");
            System.out.println("Ingrese Comando: ");
            entradaUsuario = input.nextLine().toUpperCase().charAt(0);

            switch (entradaUsuario) {
                case 'W':
                    if (celdaActual > 0) {
                        celdaActual--;
                    }
                    break;
                case 'S':
                    if (celdaActual < Celdas - 1) {
                        celdaActual++;
                    }
                    break;
                case 'A':
                    if (columnaActual > 0) {
                        columnaActual--;
                    }
                    break;
                case 'D':
                    if (columnaActual < columnaActual - 1) {
                        columnaActual++;
                    }
                    break;
                case 'q':
                    System.out.println("Adios");
                    salir= true;
                    break;
                case 'T':
                    System.out.println("Ingrese Texto:");
                    String content = input.nextLine();
                    content = content.length() > EspacioCelda ? content.substring(0, EspacioCelda) : content;
                    hoja[celdaActual][columnaActual] = content;
                    break;
                case 'e':
                    editSpreadSheet(hoja, input);
                    break;
                default:
                    System.out.println("Comando no válido.");
                    break;
            }
            imprimeCabecera();
            muestraHoja(hoja, celdaActual, columnaActual);
        }
    }

    private static void imprimeCabecera() {
        System.out.println("+--------------------------------------------------------------------------------------------------------+"); 
        System.out.println("| 0  |    A    |    B    |    C    |    D    |    E    |    F    |    G    |    H    |    I    |    J    |");
    }

    private static void muestraHoja(String[][] hoja, int celdaActual, int columnaActual) {
        final int Celdas = hoja.length;
        final int Columnas = hoja[0].length;
        final String TOP= "+--------------------------------------------------------------------------------------------------------+";
        System.out.println(TOP);

        for (int celda = 0; celda < Celdas; celda++) {
            if (celda <= 8) {
                System.out.print("|  " + (celda + 1) + " |");
            } else {
                System.out.print("| " + (celda + 1) + " |");
            }
            for (int columna = 0; columna <Columnas; columna++) {
                String content = hoja[celda][columna];
                if (content == null) {
                    content = "";
                }
                if (celda == celdaActual && columna == columnaActual) {
                    System.out.print(" [" + formatContent(content) + "] |");
                } else {
                    System.out.print("  " + formatContent(content) + " |");
                }
            }
            System.out.println();
        }

        System.out.println(TOP);
    }

    private static void editSpreadSheet(String[][] hoja, Scanner input) {
        boolean editar = true;
        while (editar) {
            System.out.println("Modo Edición - Ingrese Coordenadas (Ejemplo: A3) o [Q] para salir:");
            String editarComando = input.nextLine().toUpperCase();
            if (editarCommando.equals("Q")) {
                editar = false;
            } else {
                try {
                    int columna = editCommand.charAt(0) - 'A';
                    int celda = Integer.parseInt(editCommand.substring(1)) - 1;

                    if (celda >= 0 && celda < hoja.length && columna >= 0 && columna < hoja[0].length) {
                        System.out.println("Ingrese nuevo valor:");
                        String content = input.nextLine();
                        content = content.length() > 6 ? content.substring(0, 6) : content;
                        hoja[celda][columna] = content;
                    } else {
                        System.out.println("Coordenadas fuera de rango.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Formato de coordenadas incorrecto.");
                }
            }
        }
    }

    private static String formatContent(String content) {
        final int EspacioCelda = 6;
        if (content.length() > EspacioCelda) {
            return content.substring(0, EspacioCelda);
        } else {
            StringBuilder sb = new StringBuilder(content);
            while (sb.length() < EspacioCelda) {
                sb.insert(0, " ");
            }
            return sb.toString();
        }
    }
}