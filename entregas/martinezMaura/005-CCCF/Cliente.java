
class Client {
    private int packCount;

    public Client(int packCount) {
        this.packCount = packCount;
    }

    public int calculateServiceTime() {
        return packCount; 
    }

    public int getPackCount() {
        return packCount;
    }
}
