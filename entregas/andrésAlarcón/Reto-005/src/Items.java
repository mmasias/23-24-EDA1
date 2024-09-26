public class Items implements ItemsInterface {
  private int size;

  public Items(int size) {
    this.size = size;
  }

  public int getSize() {
    return size;
  }

  public void reduceSize() {
    size--;
  }
}