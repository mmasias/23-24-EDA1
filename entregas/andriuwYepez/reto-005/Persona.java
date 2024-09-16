import java.util.Random;

public class Persona {
    private int items;

    public Persona() {
        this.items = (int) ((Math.random() * (15 - 5)) + 5);
    }

    public int getItems() {
        return items;
    }
}
