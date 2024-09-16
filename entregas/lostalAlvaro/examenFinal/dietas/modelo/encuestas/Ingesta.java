package modelo.encuestas;

import java.util.ArrayList;
import java.util.List;

import modelo.Horario;
import modelo.alimentos.Alimento;
import modelo.alimentos.Informacion;
import modelo.arbol.DatosArbol;

public class Ingesta implements Comparable<Ingesta>, DatosArbol {
    private Horario horario;
    private List<Alimento> alimentos;

    public Ingesta(Horario horario) {
        this.horario = horario;
        this.alimentos = new ArrayList<>();
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void insertarAlimento(Alimento alimento) {
        this.alimentos.add(alimento);
    }

    @Override
    public int compareTo(Ingesta o) {
        if (this.horario.getCodigo() < o.horario.getCodigo()) {
            return 1;
        } else if (this.horario.getCodigo() > o.horario.getCodigo()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String getInformacion() {
        String RESET = "\u001B[0m";
        String ROJO = "\u001B[31m";

        String texto = this.getHorario().getDescription() + ": ";
        for (int i = 0; i < alimentos.size(); i++) {
            Alimento al = alimentos.get(i);
            texto += ROJO + al.getNombre() + RESET + ": " + al.getGramos() + "gr | ";
            if (Informacion.getDatos(al.getNombre()) != null) {
                int caloria = Informacion.getDatos(al.getNombre()).getCalorias();
                int grasa = Informacion.getDatos(al.getNombre()).getGrasas();
                int proteina = Informacion.getDatos(al.getNombre()).getProteinas();
                int azucar = Informacion.getDatos(al.getNombre()).getAzucar();

                texto += "Calorias: " + (caloria * al.getGramos() / 100) + "gr | " +
                        "Grasas: " + (grasa * al.getGramos() / 100) + "gr | " +
                        "Proteinas: " + (proteina * al.getGramos() / 100) + "gr | " +
                        "Azucar: " + (azucar * al.getGramos() / 100) + "gr | ";
            } else {
                texto += "Faltan valores nutricionales  ";
            }
        }
        return texto.substring(0, texto.length() - 2);
    }

    public void vaciar() {
        this.alimentos.clear();
    }

    public double totalCalorias() {
        double total = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = alimentos.get(i);
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                int caloria = Informacion.getDatos(alimento.getNombre()).getCalorias();
                total += caloria >= 0 ? caloria * alimento.getGramos() / 100 : 0;
            }

        }
        return total;
    }

    public int totalTipo(String nombreTipo) {
        int cantidad = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = alimentos.get(i);
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                String tipo = Informacion.getDatos(alimento.getNombre()).getTipo();
                if (nombreTipo.equalsIgnoreCase(tipo)) {
                    cantidad++;
                }
            }

        }
        return cantidad;
    }

    public int totalGrasas() {
        int total = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = alimentos.get(i);
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                int grasa = Informacion.getDatos(alimento.getNombre()).getGrasas();
                total += grasa >= 0 ? grasa * alimento.getGramos() / 100 : 0;
            }

        }
        return total;
    }

    public int totalProteinas() {
        int total = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = alimentos.get(i);
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                int proteina = Informacion.getDatos(alimento.getNombre()).getProteinas();
                total += proteina >= 0 ? proteina * alimento.getGramos() / 100 : 0;
            }

        }
        return total;
    }

    public int totalAzucar() {
        int total = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = alimentos.get(i);
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                int azucar = Informacion.getDatos(alimento.getNombre()).getAzucar();
                total += azucar >= 0 ? azucar * alimento.getGramos() / 100 : 0;
            }

        }
        return total;
    }
}
