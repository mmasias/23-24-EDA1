package miJava;

public class GestorHojaCalculo {
    private Celda[][] hojaCalculo;
    private int filas;
    private int columnas;

    public GestorHojaCalculo(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.hojaCalculo = new Celda[filas][columnas];
        inicializarHojaCalculo();
    }

    private void inicializarHojaCalculo() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                hojaCalculo[i][j] = new Celda(i, j);
            }
        }
    }

    public void mostrarHojaCalculo(int posX, int posY) {
        System.out.println("    A       B       C       D       E       F       G       H       I       J");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        for (int i = 0; i < filas; i++) {
            System.out.print("|");
            for (int j = 0; j < columnas; j++) {
                if (hojaCalculo[i][j].esCeldaActual(posX, posY)) {
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

    public void ingresarValor(int posX, int posY, String valor) {
        valor = valor.length() > 7 ? valor.substring(0, 7) : valor;
        hojaCalculo[posX][posY].setValor(String.format("%7s", valor));
    }
}
