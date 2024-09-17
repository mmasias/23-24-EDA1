package entregas.puenteDaniel.ExamenFinal;

import java.util.ArrayList;
import java.util.List;

public class Ingesta{
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

    public void agregarAlimento(Alimento alimento) {
        this.alimentos.add(alimento);
    }

    public void eliminarAlimento(Alimento alimento) {
        this.alimentos.remove(alimento);
    }

    public String getInformacion() {
        StringBuilder texto = new StringBuilder(horario.getDescription());
        for (Alimento alimento : alimentos) {
            texto.append(" ").append(alimento.toString());
        }
        return texto.toString();
    }

    public void vaciar() {
        this.alimentos.clear();
    }

    public static void main(String[] args) {
        Ingesta ingesta = new Ingesta(Horario.DESAYUNO);
        Alimento alimento1 = new Alimento("Cereal", 200);
        Alimento alimento2 = new Alimento("Leche", 150);

        ingesta.agregarAlimento(alimento1);
        ingesta.agregarAlimento(alimento2);

        System.out.println("Información de la ingesta:");
        System.out.println(ingesta.getInformacion());

        ingesta.eliminarAlimento(alimento1);

        System.out.println("Información de la ingesta después de eliminar un alimento:");
        System.out.println(ingesta.getInformacion());
    }
}