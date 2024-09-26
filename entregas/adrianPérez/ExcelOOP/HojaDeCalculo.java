import java.util.Scanner;

public class HojaDeCalculo {
    private String[][] texto;
    private int x;
    private int y;

    public HojaDeCalculo() {
        texto = new String[15][10];
        x = 0;
        y = 0;
    }

    public void mostrarHoja() {
        System.out.println("         A         B         C         D         E         F         G         H         I         J");
        System.out.println("\t+---------+---------+---------+---------+---------+---------+---------+---------+---------+---------+");
        for (int i = 0; i < texto.length; i++) {
            for (int j = 0; j < texto[i].length; j++) {
                if (j == 0 && i < 9) {
                    System.out.print(i + 1 + "       |");
                } else if (j == 0 && i >= 9) {
                    System.out.print(i + 1 + "      |");
                }

                if (texto[i][j] != null && i == y && j == x) {
                    System.out.print("[" + texto[i][j] + " ".repeat(7 - texto[i][j].length()) + "]|");
                } else if (texto[i][j] != null) {
                    System.out.print(" " + texto[i][j] + " ".repeat(7 - texto[i][j].length()) + " |");
                } else if (i == y && j == x) {
                    System.out.print("[       ]|");
                } else {
                    System.out.print("         |");
                }
            }
            System.out.println();
        }
        System.out.println("\t+---------+---------+---------+---------+---------+---------+---------+---------+---------+---------+");
    }

    public void mover(String direccion) {
        switch (direccion) {
            case "w":
                if (y > 0) {
                    y--;
                }
                break;
            case "a":
                if (x > 0) {
                    x--;
                }
                break;
            case "s":
                if (y < 14) {
                    y++;
                }
                break;
            case "d":
                if (x < 9) {
                    x++;
                }
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void editar(Scanner sc) {
        System.out.println("Introduce el valor de la celda (máximo 7 caracteres): ");
        String textoTemp = sc.nextLine();

        textoTemp = textoTemp.length() > 7 ? textoTemp.substring(0, 7) : textoTemp;

        grabarTexto(textoTemp);
    }

    private void grabarTexto(String textoTemp) {
        texto[y][x] = textoTemp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}