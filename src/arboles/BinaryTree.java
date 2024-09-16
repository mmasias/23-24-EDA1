public class BinaryTree<T> {

    private NodoTree<T> raiz;

    public BinaryTree() {
    }

    public NodoTree<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoTree<T> raiz) {

        this.raiz = raiz;
    }

    public void Insert(T dato) {
        NodoTree<T> nodoNuevo = new NodoTree<T>(dato);

        if (this.raiz == null)
            this.raiz = nodoNuevo;

        else {
            NodoTree<T> nodoAux = raiz;
            NodoTree<T> padre;
            while (true) {
                padre = nodoAux;
                if (new Integer((int) dato) < new Integer((int) nodoAux.getDato())) {
                    nodoAux = nodoAux.getIzquierdo();
                    if (nodoAux == null) {
                        padre.setIzquierdo(nodoNuevo);
                        return;
                    }
                } else {
                    nodoAux = nodoAux.getDerecho();
                    if (nodoAux == null) {
                        padre.setDerecho(nodoNuevo);
                        return;
                    }
                }

            }
        }
    }

    public void InOrden() {
        System.out.println("In Orden");
        this.InOrden(this.raiz);
    }

    // Izquierda raiz derecha
    public void PreOrden() {
        System.out.println("Pre Orden");
        this.PreOrden(this.raiz);
    }

    // Izquierda derecha raiz
    public void PostOrden() {
        System.out.println("Post Orden");
        this.PostOrden(this.raiz);
    }

    private void InOrden(NodoTree<T> raiz) {

        if (raiz != null) {
            InOrden(raiz.getIzquierdo());
            System.out.println(raiz.getDato());
            InOrden(raiz.getDerecho());
        }
    }

    private void PreOrden(NodoTree<T> raiz) {
        if (raiz != null) {
            System.out.println(raiz.getDato());
            PreOrden(raiz.getIzquierdo());
            PreOrden(raiz.getDerecho());
        }
    }

    private void PostOrden(NodoTree<T> raiz) {
        if (raiz != null) {
            PostOrden(raiz.getIzquierdo());
            PostOrden(raiz.getDerecho());
            System.out.println(raiz.getDato());
        }
    }
}
