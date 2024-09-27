public class Client {
    private int itemPacks;
    private Client next;


    public Client(){ this.itemPacks = (int)(Math.random()*11)+5;}
    public int getItemPacks(){ return itemPacks;}
    public void setItemPacks(int newItemPacks) { this.itemPacks = newItemPacks;}
    public Client getNext() {return next;}
    public void setNext(Client next){ this.next=next;}
}
