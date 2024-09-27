import java.time.LocalTime;
import java.util.function.Consumer;

public class Horario {
    private GenericList<Evento> eventos;

    public Horario() {
        this.eventos = new GenericList<>();
    }

    public void agregarEvento(Evento evento) {
        eventos.insertEnd(evento);
    }

    public Evento buscarEvento(LocalTime hora) {
        GenericNode<Evento> current = eventos.getFirst();
        while (current != null) {
            Evento evento = current.getValue();
            if (evento.getHora().equals(hora)) {
                return evento;
            }
            current = current.getNext();
        }
        return null;
    }

    public void recorrerEventos(Consumer<Evento> accion) {
        GenericNode<Evento> current = eventos.getFirst();
        while (current != null) {
            Evento evento = current.getValue();
            accion.accept(evento);
            current = current.getNext();
        }
    }

    // Getters and Setters
    public GenericList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(GenericList<Evento> eventos) {
        this.eventos = eventos;
    }
}

