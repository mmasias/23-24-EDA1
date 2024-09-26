public class CentroComercial {

    private Horario schedule;
    private int availableCashiers = 4;
    private Caja[] cajas = new Caja[availableCashiers];
   
    private static final int CLIENT_PROBABILITY_THRESHOLD = 40;

    public CentroComercial() {
        this.schedule = new Horario();
        createCashiers();
    }

    public CentroComercial(int numCajas) {
    }

    public void openShop(int duracionSimulacion) {
        while (schedule.isOpen()) {
            schedule.clock();
            manageClients();
            manageCashiers();
            printStatus();
            schedule.checkTime();
        }
    }

    private void createCashiers() {
        for (int i = 0; i < availableCashiers; i++) {
            cajas[i] = new Caja();
        }
    }

    private boolean shouldAddClient() {
        int newClientProb = (int) (Math.random() * 100);
        return newClientProb <= CLIENT_PROBABILITY_THRESHOLD;
    }
    
    private void manageClients() {
        if (shouldAddClient()) {
            addClient();
        } else {
            System.out.print("No llega nadie - ");
        }
    }

    private void addClient() {
        Client newClient = new Client(availableCashiers);
        line.newClient(newClient);
    }

    private void manageCashiers() {
        for (int i = 0; i < availableCashiers; i++) {
            if (cajas[i].isEmpty() && !line.isEmpty()) {
                cajas[i].receiveClient(line.getFirst());
                line.removeClient();
            }
            processItems(cajas[i]);
        }
    }

    private void processItems(Caja caja) {
        if (!caja.isEmpty()) {
            caja.chargeItem();
        }
    }

    private void printStatus() {
        System.out.println("En cola: " + line.size());
        for (int i = 0; i < availableCashiers; i++) {
            System.out.print("Caja " + (i + 1) + ": ");
            cajas[i].printRemainingItems();
        }
        System.out.println("===============================================");
    }
}
