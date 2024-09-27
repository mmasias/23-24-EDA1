package entregas.sergioMayen.Reto6;

public class Main {
    public static void main(String[] args) {
        Person[] family = {
                new Person(67, "Abuelo Antonio"),
                new Person(68, "Abuela Delia"),
                new Person(45, "Padre Sergio"),
                new Person(48, "Madre Roxana"),
                new Person(6, "Hija Roxana"),
                new Person(9, "Hija Pamela"),
                new Person(1, "Hijo Sergio")
        };

        BinaryTree<Person> familyTree = new BinaryTree<>();

        for (Person person : family) {
            familyTree.insert(person);
        }

        familyTree.remove(family[4]);

        System.out.println("Recorrido inOrden:");
        familyTree.inOrderTraversal();
    }
}