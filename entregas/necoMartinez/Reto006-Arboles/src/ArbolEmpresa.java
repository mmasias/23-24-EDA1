package src;

class ArbolEmpresa {
    NodoEmpleado ceo;

    public ArbolEmpresa(Empleado ceo) {
        this.ceo = new NodoEmpleado(ceo);
    }

    public void agregarEmpleado(String nombreJefe, Empleado nuevoEmpleado) {
        NodoEmpleado jefe = buscarNodo(ceo, nombreJefe);
        if (jefe != null) {
            NodoEmpleado nuevoNodo = new NodoEmpleado(nuevoEmpleado);
            jefe.agregarSubordinado(nuevoNodo);
        } else {
            System.out.println("Nodo jefe no encontrado: " + nombreJefe);
        }
    }

    private NodoEmpleado buscarNodo(NodoEmpleado nodo, String nombre) {
        if (nodo.getEmpleado().getNombre().equals(nombre)) {
            return nodo;
        } else {
            for (NodoEmpleado subordinado : nodo.getSubordinados()) {
                NodoEmpleado resultado = buscarNodo(subordinado, nombre);
                if (resultado != null) {
                    return resultado;
                }
            }
            return null;
        }
    }
}