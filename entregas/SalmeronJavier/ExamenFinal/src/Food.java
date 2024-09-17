import java.time.LocalDate;

class Food {
    private List<String> food;
    private LocalDate date;

    public Food() {
        food = new List<>();
        this.date = LocalDate.now();
    }

    public void addItem(String item) {
        food.insert(item, -1);
    }

    public LocalDate getDate() {
        return date;
    }

    public List<String> getItems() {
        return food;
    }

    public void clearItems() {
        food.clear();

    }
}