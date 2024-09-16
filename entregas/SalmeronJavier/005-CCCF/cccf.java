import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class CashRegister {
    private int itemsLeft;

    public CashRegister() {
        this.itemsLeft = 0;
    }

    public boolean isAvailable() {
        return itemsLeft == 0;
    }

    public void addClient(int items) {
        this.itemsLeft = items;
    }

    public void processItem() {
        if (itemsLeft > 0) {
            itemsLeft--;
        }
    }

    public int getItemsLeft() {
        return itemsLeft;
    }
}

class StoreSimulation {
    private List<CashRegister> cashRegisters;
    private int totalClients;
    private int totalSold;
    private int queue;
    private int timeOutOfQueue;
    private final int jornada = 12 * 60; // 12 hours to minutes

    public StoreSimulation(int numberOfCashRegisters) {
        cashRegisters = new ArrayList<>();
        for (int i = 0; i < numberOfCashRegisters; i++) {
            cashRegisters.add(new CashRegister());
        }
        this.totalClients = 0;
        this.totalSold = 0;
        this.queue = 0;
        this.timeOutOfQueue = 0;
    }

    public void simulateDay() {
        Random rand = new Random();
        int itemsCliente;

        for (int time = 0; time < jornada; time++) {
            System.out.println("Time: " + time);

            // Process each cash register
            for (CashRegister c : cashRegisters) {
                c.processItem();
            }

            // Queue system
            if (queue == 0) {
                timeOutOfQueue++;
            } else {
                for (CashRegister icr : cashRegisters) { // icr is the iterated cash register
                    if (icr.isAvailable()) {
                        queue--;
                        itemsCliente = rand.nextInt(11) + 5; // 5 to 15 items
                        icr.addClient(itemsCliente);
                        totalSold += itemsCliente;
                        break;
                    }
                }
            }

            // Generate new clients
            int probCliente = rand.nextInt(100);
            if (probCliente <= 40) {
                itemsCliente = rand.nextInt(11) + 5; // 5 to 15 items
                System.out.println("Nuevo cliente! Items:" + itemsCliente);
                totalClients++;

                boolean clientAdded = false;
                for (CashRegister icr : cashRegisters) {
                    if (icr.isAvailable()) {
                        icr.addClient(itemsCliente);
                        totalSold += itemsCliente;
                        clientAdded = true;
                        break;
                    }
                }

                if (!clientAdded) {
                    queue++;
                }
            }

            // Real-time info
            System.out.println("Queue: " + queue);
            for (int i = 0; i < cashRegisters.size(); i++) {
                System.out.println("C" + (i + 1) + ": " + cashRegisters.get(i).getItemsLeft());
            }
            System.out.println();
        }
    }

    public void printStats() {
        // Stats
        System.out.println("\n----- Resumen: -----");
        System.out.println("Tiempo sin cola: " + timeOutOfQueue);
        System.out.println("Clientes restantes en cola: " + queue);
        System.out.println("Clientes totales: " + totalClients);
        System.out.println("Objetos vendidos: " + totalSold);
    }
}

public class cccf {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Login: (user/admin) ");
        String user = userInput.nextLine();

        int enCaja = 4;
        if (user.equals("admin")) {
            System.out.print("Numero de cajas: ");
            enCaja = userInput.nextInt();
        }

        StoreSimulation simulation = new StoreSimulation(enCaja);
        simulation.simulateDay();
        simulation.printStats();

        userInput.close();
    }
}
