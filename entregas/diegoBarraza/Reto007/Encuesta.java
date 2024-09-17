package Reto007;

public class Encuesta {
    private Tree<Dias> diasTree;

    public Encuesta() {
        this.diasTree = new Tree<>();
        for (int i = 1; i <= 5; i++) {
            diasTree.insert(new Node<>(new Dias(i), i));
        }
    }

    public void agregarAlimento(Alimentos alimento, int dia, String tipoIngesta) {
        Node<Dias> diaNode = diasTree.find(dia);
        if (diaNode != null) {
            diaNode.getData().agregarAlimento(alimento, tipoIngesta);
        } else {
            System.out.println("Error: Día no válido.");
        }
    }

    public void obtenerInfoDieta() {
        StringBuilder sb = new StringBuilder();
        diasTree.printInOrder(sb);
        System.out.println(sb.toString());
    }
}