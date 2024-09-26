
class DiaAlimentos {
    ArbolBinarioBusqueda arbol;

    public DiaAlimentos() {
        this.arbol = new ArbolBinarioBusqueda();
    }

    public void agregarAlimento(Alimento alimento) {
        arbol.insertar(alimento);
    }

    public void listarAlimentos() {
        System.out.println("Alimentos ingresados:");
        arbol.inOrden();
    }
}