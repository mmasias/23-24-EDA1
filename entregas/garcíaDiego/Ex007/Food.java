public class Food implements Comparable<Food> {
    private int grams;
    private String name;
    public Food(String name, int grams) {
        this.grams = grams;
        this.name = name;
    }
    public int getGrams() {
        return grams;
    }
    public void setGrams(int grams) {
        this.grams = grams;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Food o) {
        if (this.getName().compareTo(o.getName())> 0){
            return 1;

        }else if (this.getName().compareTo(o.getName())<0){
            return -1;
        }else{
            return 0;
        }
    }

    public String toString(){
        return " Name: "+name+" Grams: "+grams;
    }
    

    
}
