public class Day {
    String name;
    List<Intakes> intakes;

    public Day(String name) {
        this.name = name;
        intakes = new List<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Intakes> getIntakes() {
        return intakes;
    }

    public void setIntakes(List<Intakes> intakes) {
        this.intakes = intakes;
    }

    void addIntake(Intakes intake) {
        intakes.insert(intake, -1);
    }

    void showData() {
        System.out.println("  " + name);
        Node<Intakes> currentIntake = intakes.getFirst();
        while (currentIntake != null) {
            currentIntake.getData().showData();
            currentIntake = currentIntake.getNext();
        }
    }
}
