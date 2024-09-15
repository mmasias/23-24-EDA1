package Reto006;

public class Main {
    public static void main(String[] args) {
        Arbol arbolin = new Arbol();
        arbolin.insertar(43);
        arbolin.insertar(10);
        arbolin.insertar(8);
        arbolin.insertar(54);
        arbolin.insertar(15);
        arbolin.insertar(50);
        arbolin.insertar(53);
        System.out.println("Preorden");
        arbolin.dispararPreorden();
        System.out.println("");
        System.out.println("Inorden");
        arbolin.dispararInorden();
        System.out.println("");
        System.out.println("Postorden");
        arbolin.dispararPostorden();
    }
    

}
