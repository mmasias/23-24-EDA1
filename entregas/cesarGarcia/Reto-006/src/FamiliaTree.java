import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class FamiliaTree<T> implements IDataStructure<T> {

    private NodoFamilia<T> raiz;

    public FamiliaTree() {
    }

    @Override
    public int size() {
        return contarNodos(raiz);
    }

    @Override
    public TreeNode getFirst() {
        return (TreeNode) raiz;
    }

    @Override
    public boolean isEmpty() {
        return raiz == null;
    }

    @Override
    public Object[] listData() {
        List<T> lista = new ArrayList<>();
        listarNodos(raiz, lista);
        return lista.toArray();
    }

    public void agregarMiembro(T dato, T padre, boolean esHijoIzquierdo) {
        NodoFamilia<T> nuevoMiembro = new NodoFamilia<>(dato);
        if (raiz == null) {
            raiz = nuevoMiembro;
        } else {
            NodoFamilia<T> nodoPadre = buscarNodo(raiz, padre);
            if (nodoPadre != null) {
                if (esHijoIzquierdo) {
                    nodoPadre.setHijoIzquierdo(nuevoMiembro);
                } else {
                    nodoPadre.setHijoDerecho(nuevoMiembro);
                }
            } else {
                System.out.println("No se encontró al padre en el árbol.");
            }
        }
    }

    public void imprimirArbol() {
        System.out.println("Representación de la familia:");
        imprimirArbol(raiz, 0);
    }

    private void imprimirArbol(NodoFamilia<T> nodo, int nivel) {
        if (nodo != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nivel; i++) {
                sb.append("  ");
            }
            System.out.println(sb.toString() + nodo.getDato());
            imprimirArbol(nodo.getHijoIzquierdo(), nivel + 1);
            imprimirArbol(nodo.getHijoDerecho(), nivel + 1);
        }
    }

    private int contarNodos(NodoFamilia<T> nodo) {
        if (nodo == null) {
            return 0;
        }

        int izquierdo = contarNodos(nodo.getHijoIzquierdo());
        int derecho = contarNodos(nodo.getHijoDerecho());

        return izquierdo + derecho + 1;
    }

    private void listarNodos(NodoFamilia<T> nodo, List<T> lista) {
        if (nodo != null) {
            listarNodos(nodo.getHijoIzquierdo(), lista);
            lista.add(nodo.getDato());
            listarNodos(nodo.getHijoDerecho(), lista);
        }
    }

    private NodoFamilia<T> buscarNodo(NodoFamilia<T> raiz, T dato) {
        if (raiz == null || raiz.getDato().equals(dato)) {
            return raiz;
        }

        NodoFamilia<T> izquierdo = buscarNodo(raiz.getHijoIzquierdo(), dato);
        if (izquierdo != null) {
            return izquierdo;
        }

        return buscarNodo(raiz.getHijoDerecho(), dato);
    }
}
