public class Main {
    public static void main(String[] args) {
        Empleado[] empresa = {
                new Empleado (2800, "Pelayo"),
                new Empleado (350, "Anibal"),
                new Empleado (1000, "Mariete"),
                new Empleado (2000, "Lostal"),
                new Empleado (2900, "David"),
                new Empleado (1600, "Dani"),
                new Empleado (780, "Chema"),
                new Empleado (2000, "Diego")

        };
        BinaryTree <Empleado> b = new BinaryTree<>();

        for (Empleado e : empresa) {
            b.insert(e);
        }

        b.inOrden();
    }

}