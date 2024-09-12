import java.util.Scanner;

public class visicalc {

    // Const generales
    private static final int ROWS = 15;
    private static final int COLUMNS = 10;

    private static final Scanner INPUT = new Scanner(System.in);

    // Const para el render
    private static final String HEADER = """
                                  +------------------------------------------------------------------------+
                                  |  |   A  |   B  |   C  |   D  |   E  |   F  |   G  |   H  |   I  |   J  |
                                  |--+------+------+------+------+------+------+------+------+------+------+""";

    private static final String TABLE_END = "|--+------+------+------+------+------+------+------+------+------+------|";

    private static final String DIVIDER = "|------------------------------------------------------------------------|";

    private static final String HELP = "CMDs: [W] Arriba, [S] Abajo, [A] Izquierda, [D] Derecha, [E] Editar celda, [F] Salir";

    // Spreadsheet data
    private static String[][] data = new String[ROWS][COLUMNS];

    private static int cursorX = 1,
            cursorY = 1;

    // Renderer
    private static void renderUI(String[][] data, int cursorX, int cursorY) {
        String render = "",
                temp = "",
                tempColm = "";

        // Añadir cabecera
        render += HEADER;

        for (int i = 0; i < ROWS; i++) {
            // Añadir número de fila
            temp = String.format("|%2d|", i + 1);

            // Añadir cada columna
            for (int j = 0; j < COLUMNS; j++) {
                tempColm = data[i][j];

                // Renderizar cursor
                if (cursorX - 1 == i && cursorY - 1 == j) {
                    // Incluir contenido de la celda en el cursor
                    if (tempColm.length() > 4) {
                        tempColm = tempColm.substring(0, 4);
                    }

                    temp += String.format("[%4s]|", tempColm);

                    // Renderizar celda sin cursor
                } else {
                    // Si la entrada es mayor de 6 chars, recortarla
                    if (tempColm.length() > 6) {
                        tempColm = tempColm.substring(0, 6);
                    }

                    temp += String.format("%6s|", tempColm);
                }
            }

            render += "\n" + temp;
        }

        render += "\n" + TABLE_END;

        // Añadir coordenadas
        render += "\n" + String.format("|  | X: %d | Y: %d |", cursorX, cursorY);

        render += "\n" + DIVIDER + "\n" + HELP;

        System.out.println(render);
    }

    private static void processInput() {
        String cmd;
        int error = 0;

        do {
            // Mostrar error
            if (error == 1) {
                System.out.println("Introduce un comando válido");
            }

            // Tomar entrada
            System.out.print("Ingrese comando: ");
            cmd = INPUT.next().toLowerCase();

            switch (cmd.charAt(0)) {
                case 'f' -> { // Salir
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                }
                case 'e' -> { // Editar
                    error = 0;
                    System.out.print("Introduce el nuevo contenido de la celda: ");

                    // Limpiar buffer
                    INPUT.nextLine();

                    // Tomar entrada y modificar datos
                    data[cursorX - 1][cursorY - 1] = INPUT.nextLine();
                }
                case 'w' -> { // Mover arriba
                    error = 0;
                    if (cursorX > 1) {
                        cursorX--;
                    } else {
                        cursorX = 1;
                    }
                }
                case 's' -> { // Mover abajo
                    error = 0;
                    if (cursorX < 15) {
                        cursorX++;
                    } else {
                        cursorX = 15;
                    }
                }
                case 'a' -> { // Mover izq
                    error = 0;
                    if (cursorY > 1) {
                        cursorY--;
                    } else {
                        cursorY = 0;
                    }
                }
                case 'd' -> { // Mover derecha
                    error = 0;
                    if (cursorY < 10) {
                        cursorY++;
                    } else {
                        cursorY = 10;
                    }
                }
                default -> {
                    error = 1;
                }
            }
        } while (error != 0);
    }

    private static void initData() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = "";
            }
        }
    }

    // Main loop
    public static void main(String[] args) {
        // Inicializar array a espacios
        initData();

        // Loop principal
        while (true) {
            renderUI(data, cursorX, cursorY);
            processInput();
        }
    }
}