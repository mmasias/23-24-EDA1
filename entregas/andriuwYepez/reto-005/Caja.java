public class Caja {
    private int items;

    public Caja() {
        this.items = 0;
    }

    public boolean estaDisponible() {
        return items == 0;
    }

    public void atenderItem() {
        if (items > 0) {
            items--;
            System.out.println("  >  La caja atiende un item, le quedan " + items);
        }
    }

    public void asignarPersona(Persona persona) {
        items = persona.getItems();
        System.out.println("  >  La caja atiende a una persona llevando [" + items + "] items");
    }
}
