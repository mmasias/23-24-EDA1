package com.escuela;

class EncuestaNutricional {
    String nombrePaciente;
    Dia raiz;

    public EncuestaNutricional(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
        this.raiz = null;
    }

    public void agregarDia(int numeroDia) {
        if (raiz == null) {
            raiz = new Dia(numeroDia);
        } else {
            System.out.println("Ya existe un día en la encuesta. No se pueden agregar más.");
        }
    }

    public void registrarAlimento(int numeroDia, String tipoIngesta, String nombreAlimento) {
        if (raiz != null) {
            Dia dia = buscarDia(raiz, numeroDia);
            if (dia != null) {
                dia.registrarAlimento(tipoIngesta, nombreAlimento);
            } else {
                System.out.println("No se encontró el día especificado.");
            }
        } else {
            System.out.println("No hay días en la encuesta. Primero, agregue un día.");
        }
    }

    public void mostrarEncuesta() {
        if (raiz != null) {
            System.out.println("Encuesta Nutricional para " + nombrePaciente + ":");
            mostrarDia(raiz);
        } else {
            System.out.println("No hay datos de encuesta para mostrar.");
        }
    }

    private Dia buscarDia(Dia nodo, int numeroDia) {
        if (nodo == null) {
            return null;
        }

        if (nodo.numeroDia == numeroDia) {
            return nodo;
        }

        Dia izquierda = buscarDia(nodo.izquierda, numeroDia);
        Dia derecha = buscarDia(nodo.derecha, numeroDia);

        return (izquierda != null) ? izquierda : derecha;
    }

    private void mostrarDia(Dia nodo) {
        if (nodo != null) {
            mostrarDia(nodo.izquierda);
            nodo.mostrarDia();
            mostrarDia(nodo.derecha);
        }
    }
}
