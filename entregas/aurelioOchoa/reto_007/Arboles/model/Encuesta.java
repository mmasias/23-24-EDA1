package Arboles.model;

public class Encuesta {
    public Dia lunes, martes, miercoles, jueves, viernes;

    public Encuesta(NaryTreeNode pacienteRoot) {
        NaryTreeNode encuestaRoot = new NaryTreeNode("Encuesta", 5);
        encuestaRoot.addChild(0, new NaryTreeNode("lunes", 5));
        pacienteRoot.addChild(0, encuestaRoot);
        pacienteRoot.children[0].addChild(0, encuestaRoot);
    }
}
