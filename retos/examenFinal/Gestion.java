import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Gestion {
    private List<Lista<DatosLista>> lista;
    private Scanner sc;
    private DateTimeFormatter formato;

    public Gestion(List<Lista<DatosLista>> elementos) {
        this.lista = elementos;
        this.sc = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public Lista<DatosLista> existeNodoIngesta(int dia, Horario horario) {
        Lista<DatosLista> result = null;
  

        List<Lista<DatosLista>> nodoIngesta = (List<Lista<DatosLista>>) nodoDia.getHijos();

        for (int i = 0; i < nodoIngesta.size(); i++) {
            Ingesta ing = (Ingesta) nodoIngesta.get(i).getValor();

            if (ing.getHorario() == horario) {
                result = nodoIngesta.get(i);
                break;
            }
        }

        return result;
    }

    public void Estadisticas() {
        int total = lista.get(0).totalCaloriasEnc();
        System.out.println("Total calorias en cinco dias " + total);
        System.out.println("Promedio diario: " + total / 5);

        if (total / 5 < 1600) {
            System.out.println(" Consumo de calorias por debajo de las recomendadas ");
        } else if (total / 5 > 2000) {
            System.out.println(" Consumo de calorias excesivo. Se recomienda aumentar el ejercicio fisico ");
        }
        System.out.println("Fruta: " + lista.get(0).totalTipoEnc("Fruta"));
    }

    public void capturarDatos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'capturarDatos'");
    }

    public void mostrar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrar'");
    }
}