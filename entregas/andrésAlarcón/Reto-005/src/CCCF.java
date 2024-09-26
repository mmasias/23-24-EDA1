public class CCCF {
  private ScheduleInterface schedule;
  private int availableCheckouts = 4;
  private CheckoutInterface[] checkouts = new CheckoutInterface[availableCheckouts];
  private QueueInterface line;

  public CCCF(ScheduleInterface schedule, QueueInterface line) {
    this.schedule = schedule;
    this.line = line;
    this.createCheckouts();
  }

  private void createCheckouts() {
    for (int i = 0; i < availableCheckouts; i++) {
      checkouts[i] = new Checkout();
    }
  }

  private void addCustomer() {
    CustomerInterface newCustomer = new Customer();
    line.newCustomer(newCustomer);
  }

  private void attendCustomer() {
    for (int i = 0; i < availableCheckouts; i++) {
      if (checkouts[i].isEmpty() && !line.isEmpty()) {
        checkouts[i].receiveCustomer(line.getFirst());
        line.removeCustomer();
      }
    }
  }

  private void printCustomerStatus() {
    System.out.println("Customers in line: " + line.size());
    for (int i = 0; i < availableCheckouts; i++) {
      System.out.print("Checkout " + (i + 1) + ": ");
      checkouts[i].printRemainingItems();
    }
    System.out.println("                                  ");
  }

  private void processItems() {
    for (int i = 0; i < availableCheckouts; i++) {
      if (!checkouts[i].isEmpty()) {
        checkouts[i].chargeItem();
      }
    }
  }

  public void openShop() {
    System.out.println("Start  of the day");
    while (schedule.isOpen()) {
      schedule.clock();
      int newCustomerProb = (int) (Math.random() * 100);
      if (newCustomerProb <= 40) {
        addCustomer();
      } else {
        System.out.println("No one has arrived");
      }
      attendCustomer();
      printCustomerStatus();
      processItems();
      schedule.checkTime();
    }
  }
}