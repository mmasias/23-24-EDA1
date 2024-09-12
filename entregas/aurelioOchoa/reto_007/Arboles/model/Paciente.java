package Arboles.model;

public class Paciente {
  public String nombre;
  public Encuesta encuesta;

  public Paciente(String nombre) {
    this.nombre = nombre;
    NaryTreeNode root = new NaryTreeNode(nombre, 1);
    this.encuesta = new Encuesta(root);
  }
}


