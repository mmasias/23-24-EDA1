import java.time.LocalDate;

public class Encuesta implements DatosLista{
    private GenericList<Dia> dias;
    private LocalDate fecha;
    public Encuesta(LocalDate fecha){
        this.fecha= fecha;
        this.dias = new GenericList<Dia>();
        
    }
    public Encuesta(){
        this.dias = new GenericList<Dia>();
        
    }

    public LocalDate getFecha() {
        return this.fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public GenericList<Dia> getDias() {
        return dias;
    }
    public void setDias(GenericList<Dia> dias) {
        this.dias = dias;
    }
    @Override
    public String getInformacion() {
        return "Fecha de la encuesta: "+fecha.toString();
        
    }
    
    public void insertarDias(Dia d) {
        

        dias.insertEnd(d);
    }
    
    
}

