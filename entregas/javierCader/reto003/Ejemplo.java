class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacia? " + nephews.isEmpty());
        
        System.out.println(" > Llegó " + nephews.insert("Juanito"));
        System.out.println(" > Llegó " + nephews.insert("Pepito"));
        System.out.println(" > Llegó " + nephews.insert("Anita"));

        System.out.println("Esta vacia? " + nephews.isEmpty());

        viewLine(nephews);

        System.out.println(" > Llegó " + nephews.insert("Luisito"));

        System.out.println("Tamaño: " + nephews.size());

        System.out.println("Se fue " + nephews.delete());
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);
    }

    static void viewLine(List filaDeSobrinos) {
        
        String[] larray = filaDeSobrinos.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (String sobrino : larray){
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }
}
 