
public class Dia implements DatosLista {
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
    public String getInfo() {
        return "Dia de encuesta: " + this.dia;
    }

}
