package HojaDeCalculo;

public class Celda {
    private String contenido;

    // Constructor por defecto
    public Celda() {
        this("");
    }

    // Constructor con contenido inicial
    public Celda(String contenido) {
        this.contenido = contenido;
    }

    // Método para obtener el contenido
    public String getContenido() {
        return contenido;
    }

    // Método para establecer el contenido
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

