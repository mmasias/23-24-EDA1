public class Main {
  public static void main(String[] args) {
    ScheduleInterface schedule = new Schedule();
    QueueInterface line = new Queue();
    CCCF cccf = new CCCF(schedule, line);
    cccf.openShop();
  }
}