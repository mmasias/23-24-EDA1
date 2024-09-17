public class Main {
    public static void main(String[] args) {
        Empleado[] empresa = {
                new Empleado(500, "Pelayo"),
                new Empleado(3500, "Anibal"),
                new Empleado(1750, "Mariete"),
                new Empleado(1680, "Lostal"),
                new Empleado(950, "Txema"),
                new Empleado(2800, "Diego"),
                new Empleado(1250, "David"),
                new Empleado(3000, "Marcos"),

        };
        BinaryTree<Empleado> b = new BinaryTree<>();

        for (Empleado e : empresa) {
            b.insert(e);
        }

        b.inOrden();
    }

}