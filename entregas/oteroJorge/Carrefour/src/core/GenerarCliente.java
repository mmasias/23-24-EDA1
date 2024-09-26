package core;

public class GenerarCliente {
    public Cliente generarCliente() {
        int numPacks = (int)(Math.random() * (15-5+1))+5;
        return new Cliente(numPacks);
    }
}

