package Reto005;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Caja {

    int tiempoRestante;

    public Caja() {
        this.tiempoRestante = 0;
    }

    public boolean estaOcupada() {
        return tiempoRestante > 0;
    }

    public void atenderCliente(Cliente cliente) {
        tiempoRestante = cliente.getItems();
    }

    public void reducirTiempo() {
        if (tiempoRestante > 0) {
            tiempoRestante--;
        }
    }
}
