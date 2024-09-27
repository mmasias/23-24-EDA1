import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class NodoFamilia<T> implements TreeNode {

    private T dato;
    private NodoFamilia<T> hijoIzquierdo;
    private NodoFamilia<T> hijoDerecho;

    public NodoFamilia(T dato) {
        this.dato = dato;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public T getDato() {
        return dato;
    }

    public NodoFamilia<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoFamilia<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoFamilia<T> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoFamilia<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        if (childIndex == 0) {
            return hijoIzquierdo;
        } else if (childIndex == 1) {
            return hijoDerecho;
        }
        return null;
    }

    @Override
    public int getChildCount() {
        int count = 0;
        if (hijoIzquierdo != null) {
            count++;
        }
        if (hijoDerecho != null) {
            count++;
        }
        return count;
    }

    @Override
    public TreeNode getParent() {
        return null; // You might need to modify this based on your requirements
    }

    @Override
    public int getIndex(TreeNode node) {
        if (node == hijoIzquierdo) {
            return 0;
        } else if (node == hijoDerecho) {
            return 1;
        }
        return -1;
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return getChildCount() == 0;
    }

    @Override
    public Enumeration children() {
        List<TreeNode> children = new ArrayList<>();
        if (hijoIzquierdo != null) {
            children.add(hijoIzquierdo);
        }
        if (hijoDerecho != null) {
            children.add(hijoDerecho);
        }
        return new Enumeration<TreeNode>() {
            int index = 0;

            @Override
            public boolean hasMoreElements() {
                return index < children.size();
            }

            @Override
            public TreeNode nextElement() {
                return children.get(index++);
            }
        };
    }
}
