import java.util.HashMap;
import java.util.Map;

class Dias {

  int numeroDia;
  static Map<String, Ingesta> ingestas;

  public Dias(int numeroDia) {
    this.numeroDia = numeroDia;
    this.ingestas = new HashMap<>();
  }

  public static void registrarAlimento(String tipoIngesta, String nombreAlimento) {
    Ingesta ingesta = ingestas.computeIfAbsent(tipoIngesta, Ingesta::new);
    ingesta.agregarAlimento(nombreAlimento);
  }

  public static void mostrarIngestas() {
    for (Ingesta ingesta : ingestas.values()) {
      System.out.println("  " + ingesta.tipo + ":");
      Ingestar.mostrarAlimentos();
    }
  }
}
