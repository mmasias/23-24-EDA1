public class arbolBinario {
    private nodo raiz;

    public arbolBinario() {
        this.raiz = null;
    }

    public void insertar(int valor) {
        this.raiz = insertarRec(this.raiz, valor);
    }

    private nodo insertarRec(nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = insertarRec(raiz.derecho, valor);
        }

        return raiz;
    }

    public void recorrerInOrder() {
        recorrerInOrderRec(this.raiz);
        System.out.println();
    }

    private void recorrerInOrderRec(nodo raiz) {
        if (raiz != null) {
            recorrerInOrderRec(raiz.izquierdo);
            System.out.print(raiz.valor + " ");
            recorrerInOrderRec(raiz.derecho);
        }
    }

    public void recorrerPreOrder() {
        recorrerPreOrderRec(this.raiz);
        System.out.println();
    }

    private void recorrerPreOrderRec(nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            recorrerPreOrderRec(raiz.izquierdo);
            recorrerPreOrderRec(raiz.derecho);
        }
    }

    public void recorrerPostOrder() {
        recorrerPostOrderRec(this.raiz);
        System.out.println();
    }

    private void recorrerPostOrderRec(nodo raiz) {
        if (raiz != null) {
            recorrerPostOrderRec(raiz.izquierdo);
            recorrerPostOrderRec(raiz.derecho);
            System.out.print(raiz.valor + " ");
        }
    }
}
