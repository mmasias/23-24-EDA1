package entregas.puenteDaniel.ExamenFinal;

public enum Horario {

    DESAYUNO (1, "Desayuno"),
    MEDIAMAÑANA (2, "Media mañana"),
    ALMUERZO (3, "Almuerzo"),
    MERIENDA (4, "Merienda"),
    CENA (5, "Cena");

    private int codigo;
    private String description;
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    private Horario(int codigo, String description) {
        this.codigo = codigo;
        this.description = description;
    }
}