/*
public class Arbol<T extends DatosArbol> {
    private NodoArbol<T> raiz;

    public Arbol(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public void preOrden(NodoArbol<T> raiz, String nivel) {
        if (raiz != null) {
            System.out.println(nivel + raiz.getValue().getInformacion());
            for (int i = 0; i < raiz.getHijos().size(); i++) {
                preOrden(raiz.getHijos().getObjeto(i), nivel + "    ");
            }
        }
    }

    public void postOrden(NodoArbol<T> raiz) {
        if (raiz != null) {
            for (int i = 0; i < raiz.getHijos().size(); i++) {
                postOrden(raiz.getHijos().getObjeto(i));
            }
            System.out.println(raiz.getValue().getInformacion());
        }
    }

    public int totalCalorias(NodoArbol<T> nodo) {
        if (nodo != null) {
            int total = 0;
            if (nodo.getValue() instanceof Ingesta) {
                Ingesta ingesta = (Ingesta) nodo.getValue();
                total += ingesta.totalCaloriasI();
            }
            for (int i = 0; i < nodo.getHijos().size(); i++) {
                total += totalCalorias(nodo.getHijos().getValorPorPosicion(i));
            }
            return total;
        } else {
            return 0;
        }
    }
    public int totalTipo(NodoArbol<T> nodo, String nombre){
        if (nodo!=null) {
            int total=0;
            if (nodo.getValue() instanceof Ingesta) {
                Ingesta ingesta =(Ingesta) nodo.getValue();
                total+= ingesta.totalTipoI(nombre);
            }
            for(int i=0; i<nodo.getHijos().size(); i++){
                total += totalTipo(nodo.getHijos().getValorPorPosicion(i), nombre);
            }
            return total;
        }else{
            return 0;
        }
    }
}
*/