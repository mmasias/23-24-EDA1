import java.util.ArrayList;
import java.util.List;

class Ingestar {

  String tipo;
  static List<Alimentos> alimentos;

  public Ingestar(String tipo) {
    this.tipo = tipo;
    this.alimentos = new ArrayList<>();
  }

  public void agregarAlimento(String nombre) {
    Alimentos nuevoAlimento = new Alimentos(nombre);
    alimentos.add(nuevoAlimento);
  }

  public static void mostrarAlimentos() {
    if (alimentos.isEmpty()) {
      System.out.println("      Sin alimentos registrados.");
    } else {
      for (Alimentos alimento : alimentos) {
        System.out.println(alimento.nombre);
      }
    }
  }
}
