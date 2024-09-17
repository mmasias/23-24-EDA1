package Reto005
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Cliente {
    int items;

    public Cliente() {
        this.items = new Random().nextInt(11) + 5;
    }

    public int getItems() {
        return items;
    }
}
