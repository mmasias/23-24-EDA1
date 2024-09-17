package com.examen;

import java.util.ArrayList;
import java.util.List;

class Ingesta {

  String tipo;
  List<Alimento> alimentos;

  public Ingesta(String tipo) {
    this.tipo = tipo;
    this.alimentos = new ArrayList<>();
  }

  public void agregarAlimento(String nombre) {
    Alimento alimento = new Alimento(nombre);
    alimentos.add(alimento);
  }
}
