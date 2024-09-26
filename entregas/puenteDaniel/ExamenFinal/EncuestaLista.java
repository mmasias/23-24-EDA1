package entregas.puenteDaniel.ExamenFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EncuestaLista {
    private List<EncuestaLista> encuestas;

    public EncuestaLista() {
        encuestas = new ArrayList<>();
    }

    public void agregarEncuesta(LocalDate fecha) {
        EncuestaLista encuesta = new EncuestaLista();
        encuestas.add(encuesta);
    }

    public void eliminarEncuesta(LocalDate fecha) {
        EncuestaLista encuestaAEliminar = null;
        for (EncuestaLista encuesta : encuestas) {
            if (encuesta.getFecha().equals(fecha)) {
                encuestaAEliminar = encuesta;
                break;
            }
        }
        if (encuestaAEliminar != null) {
            encuestas.remove(encuestaAEliminar);
        }
    }

    public EncuestaLista buscarEncuesta(LocalDate fecha) {
        for (EncuestaLista encuesta : encuestas) {
            if (encuesta.getFecha().equals(fecha)) {
                return encuesta;
            }
        }
        return null;
    }

    private Object getFecha() {
        throw new UnsupportedOperationException("Unimplemented method 'getFecha'");
    }

    public List<EncuestaLista> obtenerTodasLasEncuestas() {
        return encuestas;
    }

    public static void main(String[] args) {
        EncuestaLista listaEncuestas = new EncuestaLista();

        LocalDate fecha1 = LocalDate.of(2022, 1, 15);
        LocalDate fecha2 = LocalDate.of(2022, 2, 20);
        LocalDate fecha3 = LocalDate.of(2022, 3, 25);

        listaEncuestas.agregarEncuesta(fecha1);
        listaEncuestas.agregarEncuesta(fecha2);
        listaEncuestas.agregarEncuesta(fecha3);

        // Buscar una encuesta por fecha
        LocalDate fechaBuscada = LocalDate.of(2022, 2, 20);
        EncuestaLista encuestaEncontrada = listaEncuestas.buscarEncuesta(fechaBuscada);

        if (encuestaEncontrada != null) {
            System.out.println(encuestaEncontrada.getInformacion());
        } else {
            System.out.println("Encuesta no encontrada para la fecha: " + fechaBuscada);
        }

        // Obtener todas las encuestas
        List<EncuestaLista> todasLasEncuestas = listaEncuestas.obtenerTodasLasEncuestas();
        for (EncuestaLista encuesta : todasLasEncuestas) {
            System.out.println(encuesta.getInformacion());
        }
    }

    private char[] getInformacion() {

        throw new UnsupportedOperationException("Unimplemented method 'getInformacion'");
    }

    public void insertarDia(Dia d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertarDia'");
    }

    public Dia obtenerDiaPorNumero(int dia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDiaPorNumero'");
    }
}