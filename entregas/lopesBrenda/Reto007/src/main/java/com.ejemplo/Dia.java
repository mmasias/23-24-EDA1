import java.util.ArrayList;
import java.util.List;

class Dia {

  int numeroDia;
  List<Ingesta> ingestas;

  public Dia(int numeroDia) {
    this.numeroDia = numeroDia;
    this.ingestas = new ArrayList<>();
  }

  public Ingesta agregarIngesta(String tipo) {
    Ingesta ingesta = new Ingesta(tipo);
    ingestas.add(ingesta);
    return ingesta;
  }
}
