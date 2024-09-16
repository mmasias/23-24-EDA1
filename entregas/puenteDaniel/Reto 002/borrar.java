public class borrar {
    
    static String limpia(String texto, int largo, boolean borde) {
        if (texto.length() < largo) {
            texto = " ".repeat(largo - texto.length()) + texto;
        } else {
            texto = texto.substring(texto.length() - largo);
        }
        if (borde) {
            texto = "[" + limpia(texto, 5, !borde) + "]";
        }
        return texto;
    }
}
