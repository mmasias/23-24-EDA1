package com.escuela;

class Dia {
    int numeroDia;
    Ingesta raiz;

    Dia izquierda;
    Dia derecha;

    public Dia(int numeroDia) {
        this.numeroDia = numeroDia;
        this.raiz = null;
        this.izquierda = null;
        this.derecha = null;
    }

    public void registrarAlimento(String tipoIngesta, String nombreAlimento) {
        if (raiz == null) {
            raiz = new Ingesta(tipoIngesta);
        }
        raiz.registrarAlimento(nombreAlimento);
    }

    public void mostrarDia() {
        System.out.println("\nDía " + numeroDia + ":");
        if (raiz != null) {
            mostrarIngesta(raiz);
        } else {
            System.out.println("   Sin datos de ingesta para mostrar.");
        }
    }

    private void mostrarIngesta(Ingesta nodo) {
        if (nodo != null) {
            mostrarIngesta(nodo.izquierda);
            nodo.mostrarIngesta();
            mostrarIngesta(nodo.derecha);
        }
    }
}
