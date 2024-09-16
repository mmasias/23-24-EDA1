package entregas.sergioMayen.Reto7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ingestas { 
    private static final int MAX_DIAS = 5;

    Map<String, List<Alimento>> comidas;

    public Ingestas() {
        this.comidas = new HashMap<>();
        comidas.put("Desayuno", new ArrayList<>());
        comidas.put("Media mañana", new ArrayList<>());
        comidas.put("Almuerzo", new ArrayList<>());
        comidas.put("Merienda", new ArrayList<>());
        comidas.put("Cena", new ArrayList<>());
    }

    public static int validarNumeroDias(Scanner scanner) {
        int numDias;
        do {
            System.out.print("Ingrese la cantidad de días para la encuesta (máximo " + MAX_DIAS + "): ");
            numDias = scanner.nextInt();

            if (numDias > MAX_DIAS) {
                System.out.println("Error: La cantidad de días no puede ser más de " + MAX_DIAS);
            }
        } while (numDias > MAX_DIAS);
        return numDias;
    }

    public void agregarAlimento(String comida, Alimento alimento) {
        List<Alimento> alimentos = comidas.get(comida);
        if (alimentos != null) {
            alimentos.add(alimento);
        } else {
            System.out.println("Tipo de comida no válido: " + comida);
        }
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (Map.Entry<String, List<Alimento>> entry : comidas.entrySet()) {
            resultado.append(entry.getKey()).append(": ");
            if (!entry.getValue().isEmpty()) {
                resultado.append(entry.getValue());
            } else {
                resultado.append("Sin datos");
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }
}