package entregas.garciaLydia.examenFinal;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String tipoIngesta;
    private Alimento alimento;
    private List<TreeNode> children;

    public TreeNode(String tipoIngesta) {
        this.tipoIngesta = tipoIngesta;
        this.children = new ArrayList<>();
    }

    public TreeNode(Alimento alimento) {
        this.alimento = alimento;
        this.children = new ArrayList<>();
    }

    public String getTipoIngesta() {
        return tipoIngesta;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public List<TreeNode> getChildren() {
        return children;
    }
}