package entregas.sergioMayen.Reto7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Encuesta {
    List<Ingestas> dias;

    public Encuesta(int numDias) {
        this.dias = new ArrayList<>();
        for (int i = 0; i < numDias; i++) {
            dias.add(new Ingestas());
        }
    }

    public void realizarEncuesta(Scanner scanner) {
        for (int dia = 1; dia <= dias.size(); dia++) {
            for (String comida : new String[]{"Desayuno", "Media mañana", "Almuerzo", "Merienda", "Cena"}) {
                System.out.println("Ingrese alimentos para el " + comida + " del día " + dia );

                String[] alimentosInput = scanner.next().split(",");
                for (String nombreAlimento : alimentosInput) {
                    Alimento alimento = new Alimento(nombreAlimento.trim());
                    agregarAlimento(dia, comida, alimento, scanner);
                }
            }
        }
    }

    private void agregarAlimento(int dia, String comida, Alimento alimento, Scanner scanner) {
        if (dia >= 1 && dia <= dias.size()) {
            do {
                dias.get(dia - 1).agregarAlimento(comida, alimento);
                System.out.println("Ingrese otro alimento para " + comida + " o escriba 'fin' para dejar de agregar: ");
                String siguienteAlimento = scanner.next();
                if (siguienteAlimento.equalsIgnoreCase("fin")) {
                    break;
                } else {
                    alimento = new Alimento(siguienteAlimento.trim());
                }
            } while (true);
        } else {
            System.out.println("Día no válido: " + dia);
        }
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < dias.size(); i++) {
            resultado.append("Dia ").append(i + 1).append(":\n");
            resultado.append(dias.get(i)).append("\n");
        }
        return resultado.toString();
    }
}
