package com.examen;

import java.util.ArrayList;
import java.util.List;

class EncuestaNutricional {

  String nombrePaciente;
  List<Dia> diasEncuestados;

  public EncuestaNutricional(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
    this.diasEncuestados = new ArrayList<>();
  }

  public void agregarDia(int numeroDia) {
    if (diasEncuestados.size() < 5) {
      Dia dia = new Dia(numeroDia);
      diasEncuestados.add(dia);
    } else {
      System.out.println("No se pueden agregar más de 5 días a la encuesta.");
    }
  }
  public void registrarAlimento(int numeroDia, String tipoIngesta, String nombreAlimento) {
    for (Dia dia : diasEncuestados) {
      if (dia.numeroDia == numeroDia) {
        for (Ingesta ingesta : dia.ingestas) {
          if (ingesta.tipo.equals(tipoIngesta)) {
            ingesta.agregarAlimento(nombreAlimento);
            return;
          }
        }

        Ingesta ingesta = dia.agregarIngesta(tipoIngesta);
        ingesta.agregarAlimento(nombreAlimento);
        return;
      }
    }
    System.out.println("No se encontró el día o tipo de ingesta especificado.");
  }

  public void mostrarEncuesta() {
    if (diasEncuestados.isEmpty()) {
      System.out.println("No hay datos de encuesta para mostrar.");
      return;
    }

    System.out.println("Encuesta Nutricional para " + nombrePaciente + ":");

    for (Dia dia : diasEncuestados) {
      System.out.println("\nDía " + dia.numeroDia + ":");

      if (dia.ingestas.isEmpty()) {
        System.out.println("   Sin datos de ingesta para mostrar.");
      } else {
        for (Ingesta ingesta : dia.ingestas) {
          System.out.println("  " + ingesta.tipo + ":");
          if (ingesta.alimentos.isEmpty()) {
            System.out.println("      Sin alimentos registrados.");
          } else {
            for (Alimento alimento : ingesta.alimentos) {
              System.out.println("      " + alimento.nombre);
            }
          }
        }
      }
    }
  }
}
