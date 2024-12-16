package miJava;

public class HojaCalculo {
    private int posX;
    private int posY;
    private int filas;
    private int columnas;
    private String[][] hojaCalculo;

    public HojaCalculo(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.hojaCalculo = new String[filas][columnas];
        this.posX = 0;
        this.posY = 0;
        inicializarHojaCalculo();
    }

    private void inicializarHojaCalculo() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                hojaCalculo[i][j] = "       ";
            }
        }
    }

    public void mostrarHojaCalculo() {
        System.out.println("    A       B       C       D       E       F       G       H       I       J");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        for (int i = 0; i < filas; i++) {
            System.out.print("|");
            for (int j = 0; j < columnas; j++) {
                if (i == posX && j == posY) {
                    System.out.print("[     ]");
                } else {
                    System.out.print(hojaCalculo[i][j]);
                }
                if (j < columnas - 1) {
                    System.out.print("|");
                }
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("Celda actual --> " + (posX + 1) + "-" + (posY + 1));
    }

    public void moverCelda(char direccion) {
        switch (direccion) {
            case 'a':
                if (posY > 0)
                    posY--;
                break;
            case 'w':
                if (posX > 0)
                    posX--;
                break;
            case 'd':
                if (posY < columnas - 1)
                    posY++;
                break;
            case 's':
                if (posX < filas - 1)
                    posX++;
                break;
        }
    }

    public void ingresarValor(String valor) {
        valor = valor.length() > 7 ? valor.substring(0, 7) : valor;
        hojaCalculo[posX][posY] = String.format("%7s", valor);
    }
}

