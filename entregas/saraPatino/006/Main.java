public class Main {
    public static void main(String[] args) {


        System.out.println("Hello world!");

        Empleado []em= {
                new Empleado(3800, "Ruben"),
                new Empleado(1000, "Francisco"),
                new Empleado(5070, "Maria"),
                new Empleado(2900, "Clara"),
                new Empleado(3950, "Manolo"),
                new Empleado(900, "Pat"),
                new Empleado(2300, "Jimena"),
                new Empleado(4200, "Alex"),
                new Empleado(1900, "Lara"),
                new Empleado(3500, "Pablo"),
                new Empleado(750, "Hector"),
                new Empleado(4359, "Carolina"),
        };

        BinaryTree <Empleado>b1 =new BinaryTree<>();
        for (int i = 0; i < em.length; i++) {
            b1.insert(em[i]);
        }

        b1.inorden();
    }
}