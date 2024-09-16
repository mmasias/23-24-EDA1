package Reto002.src;

public class limpiar extends imprimirCursor {
    static String limpiar(String texto, int largo, boolean borde) {
        if (texto.length() < largo) {
            texto = " ".repeat(largo - texto.length()) + texto;
        } else {
            texto = texto.substring(texto.length() - largo);
        }
        if (borde) {
            texto = "[" + limpiar(texto, 5, !borde) + "]";
        }
        return texto;
    }
}