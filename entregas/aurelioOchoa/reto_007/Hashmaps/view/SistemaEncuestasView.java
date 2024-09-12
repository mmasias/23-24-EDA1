package Hashmaps.view;
import Hashmaps.model.*;
import java.util.*;

public class SistemaEncuestasView {

  public static void mostrarDatosAlmacenados(Paciente paciente) {
    System.out.println(paciente.nombre);
    System.out.println("    Encuesta");
    for (Map.Entry<String, Encuesta> entry : paciente.encuestas.entrySet()) {

      Encuesta encuesta = entry.getValue();

      for (Map.Entry<Integer, Dia> diaEntry : encuesta.dias.entrySet()) {
        int numeroDia = diaEntry.getKey();
        Dia dia = diaEntry.getValue();

        System.out.println("    ".repeat(2) + "Dia " + numeroDia);

        for (Map.Entry<String, Ingesta> ingestaEntry : dia.ingestas.entrySet()) {
          String tipoIngesta = obtenerNombreIngesta(ingestaEntry.getKey());
          Ingesta ingesta = ingestaEntry.getValue();

          System.out.println("    ".repeat(3) + tipoIngesta);

          for (Alimento alimento : ingesta.alimentos) {
              System.out.println("    ".repeat(4) + alimento.nombre);
          }
        }
      }
    }
  }

  private static String obtenerNombreIngesta(String tipo) {
    switch (tipo) {
        case "1":
            return "Desayuno";
        case "2":
            return "Media mañana";
        case "3":
            return "Almuerzo";
        case "4":
            return "Merienda";
        case "5":
            return "Cena";
        default:
            return "Tipo de ingesta no válido";
    }
}
}
