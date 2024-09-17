package ExamenFinal;

public class Encuesta {
    private List<Dias> diasList;

    public Encuesta() {
        this.diasList = new List<>();
        for (int i = 1; i <= 5; i++) {
            diasList.add(new Dias(i));
        }
    }

    public void agregarAlimento(Alimentos alimento, int dia, String tipoIngesta) {
        Dias diaObj = getDia(dia);
        if (diaObj != null) {
            diaObj.agregarAlimento(alimento, tipoIngesta);
        } else {
            System.out.println("Error: Día no válido.");
        }
    }

    public void obtenerInfoDieta() {
        StringBuilder sb = new StringBuilder();
        for (Dias dia : diasList) {
            sb.append(dia.toString());
        }
        System.out.println(sb.toString());
    }

    private Dias getDia(int diaIndex) {
        for (Dias dia : diasList) {
            if (dia.diaIndex == diaIndex) {
                return dia;
            }
        }
        return null;
    }
}
