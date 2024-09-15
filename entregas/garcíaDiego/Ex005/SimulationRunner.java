package entregas.garcíaDiego.Ex005;

public class SimulationRunner {
    public static void main(String[] args) {
        Supermarket simulation = new Supermarket(5);
        simulation.simulate();
        simulation.finalReport();
    }
}
