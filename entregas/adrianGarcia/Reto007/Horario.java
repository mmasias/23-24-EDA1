import java.time.LocalTime;
import java.util.Comparator;
import java.util.function.Consumer;

public class Horario {
    private Arbol<Evento> eventos;

    public Horario() {
        this.eventos = new Arbol<>(Comparator.comparing(Evento::getHora));
    }

    public void agregarEvento(Evento evento) {
        eventos.insertar(evento);
    }

    public Evento buscarEvento(LocalTime hora) {
        return eventos.buscar(new Evento(hora, ""));
    }

    public void recorrerEventos(Consumer<Evento> accion) {
        eventos.recorrerInOrden(accion);
    }

}
