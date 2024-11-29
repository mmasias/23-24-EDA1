public class Main {
    public static void main(String[] args) {
        Empleado[] empresa = {
                new Empleado (2800, "Juan"),
                new Empleado (350, "Iker"),
                new Empleado (1000, "Pepe"),
                new Empleado (2000, "Diego"),
                new Empleado (2900, "Sergio"),
                new Empleado (1600, "Pablo"),
                new Empleado (780, "Miguel"),
                new Empleado (2000, "Adrian")

        };
        BinaryTree <Empleado> b = new BinaryTree<>();

        for (Empleado e : empresa) {
            b.insert(e);
        }

        b.inOrden();
    }

}