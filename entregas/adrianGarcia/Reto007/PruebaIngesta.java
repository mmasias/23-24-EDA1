import java.time.LocalTime;

public class PruebaIngesta {
    public static void main(String[] args) {
        Dia dia = new Dia(1);

        Ingesta desayuno = new Ingesta("Desayuno", LocalTime.of(8, 0));
        dia.agregarIngesta(desayuno);

        desayuno.agregarAlimento(new Alimento("Café con leche", 250));
        desayuno.agregarAlimento(new Alimento("Tostadas", 50));

    }
}
