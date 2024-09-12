package Hashmaps.model;
import java.util.HashMap;
import java.util.Map;

public class Paciente {
  public String nombre;
  public Map<String, Encuesta> encuestas;

  public Paciente(String nombre) {
    this.nombre = nombre;
    this.encuestas = new HashMap<>();
  }

  public void agregarEncuesta(String fecha, Encuesta encuesta) {
    this.encuestas.put(fecha, encuesta);
  }
}

