package Reto006;



public class Arbol {
    NodoArbol inicioArbol;
    public Arbol(){
        this.inicioArbol = null;
    }
    public void insertar(int valor){
        if(this.inicioArbol == null){
            this.inicioArbol = new NodoArbol(valor);
        }else{
            this.inicioArbol.insertar(valor);
        }
    }
    public void dispararPreorden(){
        this.preorden(this.inicioArbol);

    }
    public void preorden(NodoArbol nodo){
        if(nodo == null){
            return;
            
        }else{
            System.out.print(nodo.getValor() + ", ");
            preorden(nodo.getNodoIzquierdo());
            preorden(nodo.getNodoDerecho());
        }
         

    }
    public void dispararInorden(){
        this.inorden(this.inicioArbol);

    }
    public void inorden(NodoArbol nodo){
        if(nodo == null){
            return;
            
        }else{
            inorden(nodo.getNodoIzquierdo());
            System.out.print(nodo.getValor() + ", ");
            inorden(nodo.getNodoDerecho());
        }
         

    }
    public void dispararPostorden(){
        this.postorden(this.inicioArbol);

    }
    public void postorden(NodoArbol nodo){
        if(nodo == null){
            return;
            
        }else{
            postorden(nodo.getNodoIzquierdo());
            postorden(nodo.getNodoDerecho());
            System.out.print(nodo.getValor() + ", ");
        }
         

    }
}
