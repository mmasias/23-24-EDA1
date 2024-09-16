import java.util.ArrayList;
import java.util.List;

class DiaAlimentos {
    List<Alimento> alimentos;

    public DiaAlimentos() {
        this.alimentos = new ArrayList<>();
    }

    public void agregarAlimento(Alimento alimento) {
        alimentos.add(alimento);
    }

    public void listarAlimentos() {
        System.out.println("Alimentos ingresados:");
        for (Alimento alimento : alimentos) {
            System.out.println("- " + alimento.nombre + ": " + alimento.cantidad + " " + alimento.unidad);
        }
    }
}