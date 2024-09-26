import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EncuestaNutricional {
  DiaNode raiz;
  DiaNode ultimoDia;

  public EncuestaNutricional(int numDias) {
      this.raiz = null;
      this.ultimoDia = null;
      for (int i = 1; i <= numDias; i++) {
          insertarDia(i);
      }
  }

  private void insertarDia(int numeroDia) {
      DiaNode nuevoDia = new DiaNode(numeroDia);
      if (raiz == null) {
          raiz = nuevoDia;
          ultimoDia = nuevoDia;
      } else {
          ultimoDia.siguiente = nuevoDia;
          ultimoDia = nuevoDia;
      }
  }

  public void agregarAlimento(int dia, String comida, Alimento alimento) {
      DiaNode diaNode = encontrarDia(dia);
      if (diaNode != null) {
          ComidaNode comidaNode = new ComidaNode(comida, alimento);
          insertarComida(diaNode, comidaNode);
      }
  }

  private void insertarComida(DiaNode diaNode, ComidaNode nuevaComida) {
      switch (nuevaComida.nombre) {
          case "Desayuno":
              diaNode.desayuno = insertarAlimentoEnLista(diaNode.desayuno, nuevaComida);
              break;
          case "Medio día":
              diaNode.mediodia = insertarAlimentoEnLista(diaNode.mediodia, nuevaComida);
              break;
          case "Merienda":
              diaNode.merienda = insertarAlimentoEnLista(diaNode.merienda, nuevaComida);
              break;
          case "Cena":
              diaNode.cena = insertarAlimentoEnLista(diaNode.cena, nuevaComida);
              break;
          default:
              System.out.println("Comida no válida: " + nuevaComida.nombre);
      }
  }

  private ComidaNode insertarAlimentoEnLista(ComidaNode lista, ComidaNode nuevaComida) {
      if (lista == null) {
          return nuevaComida;
      } else {
          ComidaNode ultimo = encontrarUltimaComida(lista);
          ultimo.siguiente = nuevaComida;
          return lista;
      }
  }

  private ComidaNode encontrarUltimaComida(ComidaNode lista) {
      ComidaNode actual = lista;
      while (actual.siguiente != null) {
          actual = actual.siguiente;
      }
      return actual;
  }

  private DiaNode encontrarDia(int numeroDia) {
      DiaNode actual = raiz;
      while (actual != null && actual.numeroDia != numeroDia) {
          actual = actual.siguiente;
      }
      return actual;
  }

  @Override
  public String toString() {
      StringBuilder resultado = new StringBuilder();
      DiaNode actual = raiz;
      while (actual != null) {
          resultado.append("Día ").append(actual.numeroDia).append(":\n");
          resultado.append("Desayuno: ").append(obtenerComidas(actual.desayuno)).append("\n");
          resultado.append("Medio día: ").append(obtenerComidas(actual.mediodia)).append("\n");
          resultado.append("Merienda: ").append(obtenerComidas(actual.merienda)).append("\n");
          resultado.append("Cena: ").append(obtenerComidas(actual.cena)).append("\n\n");
          actual = actual.siguiente;
      }
      return resultado.toString();
  }

  private String obtenerComidas(ComidaNode lista) {
      StringBuilder resultado = new StringBuilder();
      ComidaNode actual = lista;
      while (actual != null) {
          resultado.append(actual.alimento).append(", ");
          actual = actual.siguiente;
      }
      return resultado.length() > 2 ? resultado.substring(0, resultado.length() - 2) : "Sin datos";
  }
}
