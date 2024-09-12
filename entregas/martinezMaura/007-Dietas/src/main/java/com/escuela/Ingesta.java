package com.escuela;

class Ingesta {
    String tipo;
    Alimento raiz;

    Ingesta izquierda;
    Ingesta derecha;

    public Ingesta(String tipo) {
        this.tipo = tipo;
        this.raiz = null;
        this.izquierda = null;
        this.derecha = null;
    }

    public void registrarAlimento(String nombre) {
        if (raiz == null) {
            raiz = new Alimento(nombre);
        } else {
         
            System.out.println("Ya hay un alimento registrado en esta ingesta.");
        }
    }

    public void mostrarIngesta() {
        System.out.println("  " + tipo + ":");
        if (raiz != null) {
            mostrarAlimento(raiz);
        } else {
            System.out.println("      Sin alimentos registrados.");
        }
    }

    private void mostrarAlimento(Alimento nodo) {
        if (nodo != null) {
            mostrarAlimento(nodo.izquierda);
            System.out.println("      " + nodo.nombre);
            mostrarAlimento(nodo.derecha);
        }
    }
}
