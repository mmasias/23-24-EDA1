public class Main {
    public static void main(String[] args) {
        Person[] family = {
                new Person(67, "Abuelo Joel"),
                new Person(68, "Abuela Carolina"),
                new Person(45, "Padre Sebastian"),
                new Person(48, "Madre Juliana"),
                new Person(6, "Hijo Felipe"),
                new Person(9, "Hija Andrea"),
                new Person(1, "Hijo Juan")
        };

        BinaryTree<Person> familyTree = new BinaryTree<>();

        for (Person person : family) {
            familyTree.insert(person);

        }
        familyTree.remove(family[4]);

        familyTree.inOrden();

    }
}
