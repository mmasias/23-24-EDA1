package ExamenFinal;

public class Ingesta {

    String name;
    List<Food> foods;

    public Ingesta(String name) {
        this.name = name;
        foods = new List<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    void addFood(Food food) {
        foods.insert(food, -1);
    }


    void showMenu(){

        Node<Food> actual=foods.getFirst();
        while (actual!=null){
            System.out.println(actual.getData().getName());
            actual=actual.getNext();
        }

    }

    void showData() {
        System.out.println("    " + name);
        Node<Food> currentFood = foods.getFirst();
        while (currentFood != null) {
            System.out.println("      " + currentFood.getData().getName());
            currentFood = currentFood.getNext();
        }
    }



}
