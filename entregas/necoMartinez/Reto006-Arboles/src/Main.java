package src;

public class Main {
    public static void main(String[] args) {
        Empleado ceo = new Empleado("Juan Pérez", "CEO");
        ArbolEmpresa empresa = new ArbolEmpresa(ceo);

        empresa.agregarEmpleado("Juan Pérez", new Empleado("Ana Gómez", "CTO"));
        empresa.agregarEmpleado("Juan Pérez", new Empleado("Roberto Jiménez", "CFO"));
        empresa.agregarEmpleado("Ana Gómez", new Empleado("María Sánchez", "Desarrollador"));
        empresa.agregarEmpleado("Ana Gómez", new Empleado("Carlos Rodríguez", "Desarrollador"));
        empresa.agregarEmpleado("Roberto Jiménez", new Empleado("Elena Martínez", "Contador"));



        System.out.println("Jerarquía de la Empresa:");
        recorrerJerarquia(empresa.ceo, 0);
    }

    private static void recorrerJerarquia(NodoEmpleado nodo, int nivel) {
        for (int i = 0; i < nivel; i++) {
            System.out.print("\t");
        }
        System.out.println(nodo.getEmpleado().getNombre() + " - " + nodo.getEmpleado().getCargo());
        for (NodoEmpleado subordinado : nodo.getSubordinados()) {
            recorrerJerarquia(subordinado, nivel + 1);
        }
    }
}