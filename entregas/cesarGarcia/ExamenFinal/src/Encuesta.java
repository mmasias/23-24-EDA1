import java.time.LocalDate;

public class Encuesta implements Comparable<Encuesta>{
    private LocalDate fecha;
    private List<Dia> dias;

    public Encuesta(LocalDate fecha) {
        this.fecha = fecha;
        this.dias = new List<>();
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }
    public List<Dia> getDias() {
        return dias;
    }
    public void setDias(List<Dia> dias) {
        this.dias = dias;
    }
    public void addDia(Dia dia) {
        this.dias.insertEnd(dia);
    }
    @Override
    public int compareTo (Encuesta o) {
        return this.fecha.compareTo(o.fecha);
    }
    public String getInformacion() {
        String texto = "";
        System.out.println("Fecha del inicio de la encuesta: " + this.fecha);
        return texto;
    }

}
