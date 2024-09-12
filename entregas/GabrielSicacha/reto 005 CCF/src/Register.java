public class Register {

    private int RegisterNumber;
    private boolean isOpen;
    private boolean isFull;
    private int itemsOnRegister;

    public Register(int registerNumber, boolean isOpen, boolean isFull) {
        this.RegisterNumber = registerNumber;
        this.isOpen = isOpen;
        this.isFull = isFull;
        this.itemsOnRegister = 0;
    }

    public int getRegisterNumber(){ return RegisterNumber; }

    public void setRegisterNumber(int registerNumber) {
        this.RegisterNumber = registerNumber;
    }

    public boolean isOpen(){ return isOpen; }

    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    public boolean isFull() { return itemsOnRegister!=0; }


    public int getItemsOnRegister() { return itemsOnRegister; }

    public void setItemsOnRegister(int itemsOnRegister) {
        this.itemsOnRegister = itemsOnRegister;
    }

    public void registerItems(){
        itemsOnRegister--;
    }
}

