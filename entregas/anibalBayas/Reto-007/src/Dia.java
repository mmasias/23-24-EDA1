import java.time.LocalDate;

public class Dia implements DatosArbol {
    private int dia;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Dia(int dia) {
        this.dia = dia;
    }

    @Override
    public String getInfo() {
        return "El dia de la encuesta es: " + this.dia;
    }
}
