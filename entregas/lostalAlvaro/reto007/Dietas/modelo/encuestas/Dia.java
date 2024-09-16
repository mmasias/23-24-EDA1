package modelo.encuestas;

import modelo.arbol.DatosArbol;

public class Dia implements DatosArbol {
    private int dia;

    public Dia(int dia) {
        this.dia = dia;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String getInformacion() {
        return "Dia " + this.dia + ": ";
    }
}
