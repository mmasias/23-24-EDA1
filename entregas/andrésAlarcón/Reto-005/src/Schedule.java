public class Schedule implements ScheduleInterface {
  private int hours = 0;
  private int minutes = 0;
  private boolean stillOpen = true;

  private void close() {
    System.out.println("End of the day");
    stillOpen = false;
  }

  public boolean isOpen() {
    return stillOpen;
  }

  public void clock() {
    minutes++;
    if (minutes == 60) {
      hours++;
      minutes = 0;
    }
  }

  public void checkTime() {
    if (hours == 12) {
      close();
    }
  }
}
