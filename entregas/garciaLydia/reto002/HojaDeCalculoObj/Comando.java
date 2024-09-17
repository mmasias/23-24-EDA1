package entregas.garciaLydia.reto002.HojaDeCalculoObj;

import java.util.Scanner;
public enum Comando {
    ARRIBA('W') {
        @Override
        void ejecutar(HojaDeCalculo hoja, Scanner scanner) {
            hoja.moverArriba();
        }
    },
    IZQUIERDA('A') {
        @Override
        void ejecutar(HojaDeCalculo hoja, Scanner scanner) {
            hoja.moverIzquierda();
        }
    },
    ABAJO('S') {
        @Override
        void ejecutar(HojaDeCalculo hoja, Scanner scanner) {
            hoja.moverAbajo();
        }
    },
    DERECHA('D') {
        @Override
        void ejecutar(HojaDeCalculo hoja, Scanner scanner) {
            hoja.moverDerecha();
        }
    },
    FINALIZAR('Q') {
        @Override
        void ejecutar(HojaDeCalculo hoja, Scanner scanner) {
            System.out.println("Finalizando el programa.");
            System.exit(0);
        }
    },
    EDITAR('E') {
        @Override
        void ejecutar(HojaDeCalculo hoja, Scanner scanner) {
            hoja.setModoEdicion(!hoja.isModoEdicion());
            if (hoja.isModoEdicion()) {
                System.out.println("Modo de edición activado. Ingresa el valor de la celda:");
                String valor = scanner.nextLine();
                hoja.setCelda(hoja.getFilaActual(), hoja.getColumnaActual(), valor);
                System.out.println("Celda editada.");
                hoja.setModoEdicion(false); // Desactivar el modo de edición después de editar una celda
            }
        }
    };

    private final char codigo;

    Comando(char codigo) {
        this.codigo = codigo;
    }

    abstract void ejecutar(HojaDeCalculo hoja, Scanner scanner);

    static Comando fromChar(char codigo) {
        for (Comando comando : values()) {
            if (comando.codigo == codigo) {
                return comando;
            }
        }
        return null;
    }
}



