public class Intakes {

    //String intakeType geter seter y constructor recibiendo intake
    String[] name;

    List<Food> foods;

    public Intakes() {
        name = new String[]{"Desayuno","Media mañana","Almuerzo","Merienda","Cena"};

        foods = new List<>();
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    void addFood(Food foodx){
        foods.insert(foodx,-1);

    }

    void newFood(){

    }

    void showMenu(){

        Node<Food> actual=foods.getFirst();
        while (actual!=null){
            System.out.println(actual.getData().getName());
            actual=actual.getNext();
        }

    }


}
