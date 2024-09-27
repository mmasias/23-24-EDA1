package entregas.garciaLydia.examenFinal;

import java.util.ArrayList;
import java.util.List;

public class Dia {
    private int numero;
    private TreeNode ingestas;

    public Dia(int numero) {
        this.numero = numero;
        this.ingestas = new TreeNode("Root");
    }

    public int getNumero() {
        return numero;
    }

    public void agregarAlimento(String tipoIngesta, Alimento alimento) {
        TreeNode tipoIngestaNode = findOrCreateTipoIngestaNode(tipoIngesta);
        tipoIngestaNode.addChild(new TreeNode(alimento));
    }

    private TreeNode findOrCreateTipoIngestaNode(String tipoIngesta) {
        for (TreeNode node : ingestas.getChildren()) {
            if (node.getTipoIngesta().equals(tipoIngesta)) {
                return node;
            }
        }

        TreeNode newNode = new TreeNode(tipoIngesta);
        ingestas.addChild(newNode);
        return newNode;
    }

    public TreeNode getIngestas() {
        return ingestas;
    }
}
