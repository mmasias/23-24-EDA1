package modelo.arbol;

import java.util.ArrayList;
import java.util.List;

import modelo.encuestas.Ingesta;

public class Arbol<T extends DatosArbol> {
    private List<NodoArbol<T>> hijos;
    private NodoArbol<T> raiz;

    public Arbol(NodoArbol<T> raiz) {
        this.hijos = new ArrayList<>();
        this.hijos.add(raiz);
    }

    public List<NodoArbol<T>> getHijos() {
        return hijos;
    }

    public void setHijos(List<NodoArbol<T>> hijos) {
        this.hijos = hijos;
    }

    public void preOrden(NodoArbol<T> raiz, String nivel) {
        if (raiz != null) {
            System.out.println(nivel + raiz.getValor().getInformacion());
            for (int i = 0; i < raiz.getHijos().size(); i++) {
                preOrden(raiz.getHijos().get(i), nivel + "    ");
            }
        }
    }

    public void postorden(NodoArbol<T> nodo) {
        if (nodo != null) {
            for (int i = 0; i < nodo.getHijos().size(); i++) {
                postorden(nodo.getHijos().get(i));
            }
            System.out.println(nodo.getValor().getInformacion());
        }
    }

    public int totalCaloriasEnc(NodoArbol<T> nodo) {
        if(nodo!=null) {
            int total = 0;
            if(nodo.getValor() instanceof Ingesta) {
                Ingesta ingesta = (Ingesta) nodo.getValor();
                total += ingesta.totalCalorias();
            }
            for(int i = 0; i < nodo.getHijos().size(); i++) {
                total += totalCaloriasEnc(nodo.getHijos().get(i));
            }
            return total;
        } else {
            return 0;
        }
    }

    public int totalTipoEnc(NodoArbol<T> nodo, String nombre) {
        if(nodo!=null) {
            int total = 0;
            if(nodo.getValor() instanceof Ingesta) {
                Ingesta ingesta = (Ingesta) nodo.getValor();
                total += ingesta.totalTipo(nombre);
            }
            for(int i = 0; i<nodo.getHijos().size(); i++) {
                total += totalTipoEnc(nodo.getHijos().get(i), nombre);
            }
            return total;
        } else {
            return 0;
        }
    }

    public int totalGrasasEnc(NodoArbol<T> nodo) {
        if(nodo!=null) {
            int total = 0;
            if(nodo.getValor() instanceof Ingesta) {
                Ingesta ingesta = (Ingesta) nodo.getValor();
                total += ingesta.totalGrasas();
            }
            for(int i = 0; i<nodo.getHijos().size(); i++) {
                total += totalGrasasEnc(nodo.getHijos().get(i));
            }
            return total;
        } else {
            return 0;
        }
    }

    public int totalProteinasEnc(NodoArbol<T> nodo) {
        if(nodo!=null) {
            int total = 0;
            if(nodo.getValor() instanceof Ingesta) {
                Ingesta ingesta = (Ingesta) nodo.getValor();
                total += ingesta.totalProteinas();
            }
            for(int i = 0; i<nodo.getHijos().size(); i++) {
                total += totalProteinasEnc(nodo.getHijos().get(i));
            }
            return total;
        } else {
            return 0;
        }
    }

    public int totalAzucarEnc(NodoArbol<T> nodo) {
        if(nodo!=null) {
            int total = 0;
            if(nodo.getValor() instanceof Ingesta) {
                Ingesta ingesta = (Ingesta) nodo.getValor();
                total += ingesta.totalAzucar();
            }
            for(int i = 0; i<nodo.getHijos().size(); i++) {
                total += totalAzucarEnc(nodo.getHijos().get(i));
            }
            return total;
        } else {
            return 0;
        }
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }
}