package entregas.garciaLydia.reto002.HojaDeCalculoObj;

import entregas.garciaLydia.reto002.HojaDeCalculoObj.Acciones;
import entregas.garciaLydia.reto002.HojaDeCalculoObj.HojaDeCalculo;

public class Impresion implements Acciones {
    private final HojaDeCalculo hoja;

    public Impresion(HojaDeCalculo hoja) {
        this.hoja = hoja;
    }

    @Override
    public void ejecutar() {
        // Implementación para imprimir la hoja de cálculo
    }
}