public class Main {
    public static void main(String[] args) {
        
        arbolBinario arbol = new arbolBinario();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido In-Order del árbol:");
        arbol.recorrerInOrder();

        System.out.println("Recorrido Pre-Order del árbol:");
        arbol.recorrerPreOrder();

        System.out.println("Recorrido Post-Order del árbol:");
        arbol.recorrerPostOrder();

    }
}
