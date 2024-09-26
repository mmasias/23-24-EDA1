import java.util.HashMap;
import java.util.Map;

class EncuestasNutricionales {

  String nombrePaciente;
  Map<Integer, Dia> diasEncuestados;

  public EncuestasNutricionales(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
    this.diasEncuestados = new HashMap<>();
  }

  public void agregarDia(int numeroDia) {
    if (diasEncuestados.size()< 5){
      Dia dia = new Dia(numeroDia);
      diasEncuestados.put(numeroDia, dia);
    }else{
      System.out.println("No se pueden agregar mas de 5 dias a la encuesta.");
    }
  }

  public void registrarAlimento(int numeroDia, String tipoIngesta, String nombreAlimento) {
    Dia dia = diasEncuestados.get(numeroDia);
    if (dia != null) {
      Dias.registrarAlimento(tipoIngesta, nombreAlimento);
    } else {
      System.out.println("No se encontró el día especificado.");
    }
  }

  public void mostrarEncuesta() {
    if (diasEncuestados.isEmpty()) {
      System.out.println("No hay datos de encuesta para mostrar.");
      return;
    }

    System.out.println("Encuesta Nutricional para " + nombrePaciente + ":");

    for (Dia dia : diasEncuestados.values()) {
      System.out.println("\nDía " + dia.numeroDia + ":");
      Dias.mostrarIngestas();
    }
  }
}
