package entregas.garcíaDiego.Ex005;

import java.util.Random;

public class Supermarket {
    private final double simulationHours = 3.33;
    private final Checkout[] checkouts;
    private final QueueManager queueManager = new QueueManager();
    private final Random random = new Random();
    private int emptyQueue = 0;
    private int totalCustomers = 0;

    public Supermarket(int checkoutCount) {
        checkouts = new Checkout[checkoutCount];
        for (int i = 0; i < checkoutCount; i++) {
            checkouts[i] = new Checkout();
        }
    }

    private void QueueReport() {

        System.out.println("--> Queue size: " + queueManager.getQueueSize());

        if (queueManager.getQueueSize() == 0) {
            emptyQueue += 1;
        }

    }

    private void customerAssignation() {
        for (Checkout checkout : checkouts) {
            if (checkout.isAvailable()) {
                totalCustomers += 1;
                System.out.println(" -> A customer goes to checkout " + checkout);
                checkout.setCustomer(queueManager.getNextCustomer());
            }
            System.out.print(" --> Checkout " + checkout + " takes 1 item ");
            checkout.processOneMinute();

        }
    }

    public void simulate() {
        for (int minute = 0; minute < simulationHours * 60; minute++) {

            System.out.println("Minute " + minute);

            QueueReport();

            if (minute >= 120 && minute < 240 || minute >= 480 && minute < 600) {
                System.out.println(" ES HORA PUNTA");

                if (random.nextDouble() <= 0.7) {
                    System.out.println(" ---> A new customer arrives");
                    queueManager.addCustomerToQueue(new Customer());
                }
            } else {
                if (random.nextDouble() < 0.4) {

                    System.out.println(" ---> A new customer arrives");
                    queueManager.addCustomerToQueue(new Customer());
                }
            }
            customerAssignation();

        }
    }

    public void finalReport() {
        System.out.println("-".repeat(15) + "Simulation finished" + "-".repeat(15));
        System.out.println("At the end of the simulation , there were " + queueManager.getQueueSize()
                + " customers in the queue");
        System.out.println("Total customers: " + totalCustomers);
        System.out.println("Empty queue: " + emptyQueue);
    }
}