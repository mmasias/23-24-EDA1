package Reto005.src;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class retoSupermercado {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        for (int minuto = 1; minuto <= 12 * 60; minuto++) {
            supermercado.procesarMinuto();
        }
        supermercado.imprimirResumen();
    }
}

class Supermercado {
    Scanner sc = new Scanner (System.in);
    private int[] cajas;
    private int cola;
    private int colaCero;
    private int clientesTotales;
    private int productosVendidosTotales;

    public Supermercado() {
        cajas = new int[6]; 
        cola = 0;
        colaCero = 0;
        clientesTotales = 0;
        productosVendidosTotales = 0;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "sc=" + sc +
                ", cajas=" + Arrays.toString(cajas) +
                ", cola=" + cola +
                ", colaCero=" + colaCero +
                ", clientesTotales=" + clientesTotales +
                ", productosVendidosTotales=" + productosVendidosTotales +
                '}';
    }

    public void procesarMinuto() {
        
        Random random = new Random();
        double cliente = random.nextDouble();
        if (cliente <= 0.4) {
            System.out.println("Llega una persona");
            cola++;
            clientesTotales++;
        } else {
            System.out.println("No llega nadie");
        }


        
        for (int i = 0; i < cajas.length; i++) {
            if (cajas[i] == 0 && cola > 0) {
                cola--;
                int objetos = random.nextInt(11) + 5;
                cajas[i] = objetos;
                productosVendidosTotales += objetos;
            } else if (cajas[i] > 0) {
                cajas[i]--;
            }
        }

        
        if (cola == 0) {
            colaCero++;
        }
    }

    public void imprimirResumen() {
        
        System.out.println(" Esperando: " + cola);
        System.out.println("\nResumen de la Simulación:");
        System.out.println("Minutos sin nadie en la cola: " + colaCero);
        System.out.println("Personas en la cola al final del día: " + cola);
        System.out.println("Total de clientes atendidos: " + clientesTotales);
        System.out.println("Total de productos vendidos: " + productosVendidosTotales);
        System.out.println("----------------------------------------");
        String input ;
    }
}