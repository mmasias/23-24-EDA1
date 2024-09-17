package src;

public class Arbol<T extends DatosArbol>{
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
    public void preOrden(NodoArbol<T> raiz){
        if (raiz!=null) {
            System.out.println(raiz.getValue().getInformacion());
            for (int i = 0;i<raiz.getHijos().size(); i++) {
                preOrden(raiz.getHijos().getObjeto(i));
            }
        }
    }
    public void postOrden(NodoArbol<T> raiz){
        if (raiz!=null) {
            for(int i = 0; i<raiz.getHijos().size(); i++){
                postOrden(raiz.getHijos().getObjeto(i));
            }
            System.out.println(raiz.getValue().getInformacion());
        }
    }
}
