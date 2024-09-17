package com.escuela;

class Alimento {
    String nombre;

    Alimento izquierda;
    Alimento derecha;

    public Alimento(String nombre) {
        this.nombre = nombre;
        this.izquierda = null;
        this.derecha = null;
    }
}

