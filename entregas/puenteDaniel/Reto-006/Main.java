public class Main {
    public static void main(String[] args) {
            Empleado[] empresa = {
                new Empleado (3000, "Casemiro"),
                new Empleado (550, "Alicia"),
                new Empleado (1500, "Yanira"),
                new Empleado (1200, "Estrella"),
                new Empleado (2800, "Francisco"),
                new Empleado (1700, "Javier"),
                new Empleado (890, "Jorge"),
                new Empleado (2305, "Vinicius")

            };
            BinaryTree <Empleado> b = new BinaryTree<>();

           for (Empleado e : empresa) {
            b.insert(e);
           }
           b.inOrden();
    }
}