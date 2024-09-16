public class Arbol<T extends DatosArbol> implements DatosArbol {
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

    public void preOrden(NodoArbol<T> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getValor().getInfo());
            for (int i = 0; i < nodo.getHijos().size(); i++) {
                preOrden(nodo.getHijos().getObjeto(i));
            }
        }
    }

    public void postOrden(NodoArbol<T> nodo) {
        if (nodo != null) {
            for (int i = 0; i < nodo.getHijos().size(); i++) {
                postOrden(nodo.getHijos().getObjeto(i));
            }
            System.out.println(nodo.getValor().getInfo());
        }
    }

    @Override
    public String getInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInfo'");
    }


    public int totalCaloriasEnc(NodoArbol<T> nodo){
        if (nodo!= null) {
            int total=0;
            if (nodo.getValor() instanceof Ingesta) {
                Ingesta ingesta= (Ingesta) nodo.getValor();
                total +=ingesta.totalCalorias();
            }

            for(int i=0; i<nodo.getHijos().size(); i++){
                total=+ totalCaloriasEnc(nodo.getHijos().getValorPorPosicion(i));
            }
            return total;
        }else{
            return 0;
        }
    }

    public int totalAzucarEnc(NodoArbol<T> nodo){
        if (nodo!= null) {
            int total=0;
            if (nodo.getValor() instanceof Ingesta) {
                Ingesta ingesta= (Ingesta) nodo.getValor();
                total +=ingesta.totalAzucar();
            }

            for(int i=0; i<nodo.getHijos().size(); i++){
                total=+ totalAzucarEnc(nodo.getHijos().getValorPorPosicion(i));
            }
            return total;
        }else{
            return 0;
        }
    }

    public int totalGrasasEnc(NodoArbol<T> nodo){
        if (nodo!= null) {
            int total=0;
            if (nodo.getValor() instanceof Ingesta) {
                Ingesta ingesta= (Ingesta) nodo.getValor();
                total +=ingesta.totalGrasas();
            }

            for(int i=0; i<nodo.getHijos().size(); i++){
                total=+ totalGrasasEnc(nodo.getHijos().getValorPorPosicion(i));
            }
            return total;
        }else{
            return 0;
        }
    }

    public int totalProteinasEnc(NodoArbol<T> nodo){
        if (nodo!= null) {
            int total=0;
            if (nodo.getValor() instanceof Ingesta) {
                Ingesta ingesta= (Ingesta) nodo.getValor();
                total +=ingesta.totalProteinas();
            }

            for(int i=0; i<nodo.getHijos().size(); i++){
                total=+ totalProteinasEnc(nodo.getHijos().getValorPorPosicion(i));
            }
            return total;
        }else{
            return 0;
        }
    }

    public int totalTipoEnc(NodoArbol<T> nodo, String nombre){
        if (nodo!= null) {
            int total=0;
            if (nodo.getValor() instanceof Ingesta) {
                Ingesta ingesta= (Ingesta) nodo.getValor();
                total +=ingesta.totalTipo();
            }

            for(int i=0; i<nodo.getHijos().size(); i++){
                total=+ totalTipoEnc(nodo.getHijos().getValorPorPosicion(i), nombre);
            }
            return total;
        }else{
            return 0;
        }
    }

}
