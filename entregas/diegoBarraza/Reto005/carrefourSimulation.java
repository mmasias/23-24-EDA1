package Reto005;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class carrefourSimulation {
    public static void main(String[] args) {
        int simulationDuration = 60;
        int numberOfCheckouts = 4;
        Queue<customer> customerQueue = new LinkedList<>();
        int noQueueMinutes = 0;
        int totalItemsSold = 0;
        int customersServed = 0;

        checkout[] checkouts = new checkout[numberOfCheckouts];
        for (int i = 0; i < numberOfCheckouts; i++) {
            checkouts[i] = new checkout();
        }

        Random random = new Random();

        for (int minute = 1; minute <= simulationDuration; minute++) {
            System.out.print("Minute " + minute);

            if (random.nextDouble() <= customer.ARRIVAL_PROBABILITY) {
                customer customer = new customer();
                customerQueue.offer(customer);
                System.out.println(" - A customer arrived with " + customer.getItemsInCart() + " items.");
            } else {
                System.out.println(" - No one arrived.");
            }

            System.out.println("> Customers in the queue: " + customerQueue.size());

            for (int i = 0; i < numberOfCheckouts; i++) {
                if (!customerQueue.isEmpty() && checkouts[i].isAvailable()) {
                    customer customer = customerQueue.poll();
                    checkouts[i].serveCustomer(customer);
                    System.out.println("  > Checkout " + (i + 1) + " serves a customer with " + customer.getItemsInCart() + " items.");
                    customersServed++;
                    totalItemsSold += customer.getItemsInCart();
                }
                checkouts[i].processItem();
            }

            if (customerQueue.isEmpty()) {
                noQueueMinutes++;
            }
        }

        System.out.println("Summary:");
        System.out.println("========================================");
        System.out.println("Minutes with no queue          : " + noQueueMinutes);
        System.out.println("Customers in the queue at closing: " + customerQueue.size());
        System.out.println("Customers served in the day    : " + customersServed);
        System.out.println("Items sold in the day          : " + totalItemsSold);
        System.out.println("End of the simulation");
    }
}
