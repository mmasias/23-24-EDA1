public class Cliente {
    private int items;

    public Cliente(int items) {
        this.items = items;
    }

    public void atenderUnItem() {
        if (items > 0) {
            items--;
        }
    }

    public boolean terminado() {
        return items == 0;
    }

    public int getItems() {
        return items;
    }
}
