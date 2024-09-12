public class Ingesta implements Comparable<Ingesta> {
    private Horario horario;
    private List<Alimento> alimentos;

    public Ingesta(Horario horario) {
        this.horario = horario;
        this.alimentos = new List<Alimento>();
    }

    public void setHorario(String nombre) {
        this.horario = Horario.getHorarioPorNombre(nombre);
    }

    public Horario getHorario() {
        return this.horario;
    }
    
    public List<Alimento> getAlimentos() {
        return alimentos;
    }
    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
    public void addAlimento(Alimento alimento) {
        this.alimentos.insertarOrdenado(alimento);
    }
    public void insertarAlimento(Alimento alimento) {
        this.alimentos.insertarOrdenado(alimento);
    }

    @Override
    public int compareTo(Ingesta o) {
        if (this.horario.getCode() < o.horario.getCode()) {
            return 1;
        } else if (this.horario.getCode() > o.horario.getCode()) {
            return -1;
        } else {
            return 0;
        }
    }

    public String getInformacion() {
        String texto = "";
        if (this.getHorario() != null) {
            texto = this.getHorario().getDescription() + ":";
        } else {
            texto = "Horario no especificado:";
        }
        
        for (int i = 0; i < alimentos.size(); i++) {
            Alimento alimento = alimentos.getValorPorPosicion(i);
            texto += alimento.getNombre() + "(" + alimento.getGramos() + "g), ";
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                int caloria = Informacion.getDatos(alimento.getNombre()).getCalorias();
                int grasa = Informacion.getDatos(alimento.getNombre()).getGrasas();
                int proteina = Informacion.getDatos(alimento.getNombre()).getProteinas();
                int azucar = Informacion.getDatos(alimento.getNombre()).getAzucar();
    
                texto += "Calorias: " + (caloria * alimento.getGramos()) / 100 + " Grasas: "
                        + (grasa * alimento.getGramos()) / 100 + " Proteinas: "
                        + (proteina * alimento.getGramos()) / 100 + " Azucar: " + (azucar * alimento.getGramos()) / 100 + "\n";
            } else {
                texto += "Faltan valores nutricionales. ";
            }
        }
        return texto.substring(0, texto.length() - 2);
    }
    

    public void vaciar() {
        this.alimentos.vaciar();
    }

    public int totalTipoI(String nombreTipo) {
        int cantidad = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = alimentos.getValorPorPosicion(i);
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                String tipo = Informacion.getDatos(alimento.getNombre()).getTipo();
                if (nombreTipo.equalsIgnoreCase(tipo)) {
                    cantidad++;
                }
            }

        }
        return cantidad;
    }

    public double totalCaloriasI() {
        double total = 0;
        for (int i = 0; i < this.alimentos.size(); i++) {
            Alimento alimento = alimentos.getValorPorPosicion(i);
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                int caloria = Informacion.getDatos(alimento.getNombre()).getCalorias();
                total += caloria >= 0 ? caloria * alimento.getGramos() / 100 : 0;
            }

        }
        return total;
    }
}
