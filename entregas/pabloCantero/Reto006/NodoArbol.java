package Reto006;

public  class NodoArbol {
    private int valor;
    private NodoArbol nodoIzquierdo;
    private NodoArbol nodoDerecho;
    public NodoArbol(int valor) {
        this.valor = valor;
        this.nodoIzquierdo = null;
        this.nodoIzquierdo = null;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public NodoArbol getNodoIzquierdo() {
        return nodoIzquierdo;
    }
   
    public NodoArbol getNodoDerecho() {
        return nodoDerecho;
    }
    public void insertar(int valor){
        if(valor <this.valor){
            if(this.nodoIzquierdo == null){
                this.nodoIzquierdo = new NodoArbol(valor);
            }else{
                this.nodoIzquierdo.insertar(valor);
            } 
        }else{
            if(this.nodoDerecho == null){
                this.nodoDerecho = new NodoArbol(valor);
            }else{
                this.nodoDerecho.insertar(valor);
            }
        }
    }


    

    
}