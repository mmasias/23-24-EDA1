public class Arbol<T extends DatosArbol> {
    private NodoArbol<T> raiz;

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public Arbol(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public void preOrden(NodoArbol<T> nodo){
        if(nodo!=null){
            System.out.println(nodo.getValor().getInformacion());
            for(int i=0;i<nodo.getHijos().size();i++){
                preOrden(nodo.getHijos().getObjeto(i));
            }
        }
    }

    public void postOrden(NodoArbol<T> nodo){
        if(nodo!=null){
            for(int i=0;i<nodo.getHijos().size();i++){
                postOrden(nodo.getHijos().getObjeto(i));
            }
            System.out.println(nodo.getValor().getInformacion());
        }
    }
    
}
