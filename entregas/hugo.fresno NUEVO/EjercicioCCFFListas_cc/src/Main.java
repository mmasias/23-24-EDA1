public class Main {
    public static void main(String[] args) {
        CentroComercial centroComercial = new CentroComercial(8);

        for (int i = 0; i < 720; i++) {
            centroComercial.simularMinuto();
        }
    }
}