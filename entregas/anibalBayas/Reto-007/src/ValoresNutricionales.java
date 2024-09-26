public class ValoresNutricionales implements Comparable<ValoresNutricionales> {
    public int calorias;
    public int azucar;
    public int proteinas;
    public int grasas;
    public String tipo;

    public ValoresNutricionales(int calorias, int azucar, int proteinas, int grasas, String tipo) {
        this.calorias = calorias;
        this.azucar = azucar;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.tipo = tipo;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getAzucar() {
        return azucar;
    }

    public void setAzucar(int azucar) {
        this.azucar = azucar;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public int getGrasas() {
        return grasas;
    }

    public void setGrasas(int grasas) {
        this.grasas = grasas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int compareTo(ValoresNutricionales o) {
        return 0;
    }
}
