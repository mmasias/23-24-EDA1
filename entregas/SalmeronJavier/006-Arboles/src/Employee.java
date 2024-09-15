import java.util.ArrayList;
import java.util.List;

public class Employee {
    String position;
    List<Employee> subordinates;

    public Employee(String position) {
        this.position = position;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee employee) {
        this.subordinates.add(employee);
    }

    public void printTree(String indent) {
        System.out.println(indent + position);
        for (Employee subordinate : subordinates) {
            subordinate.printTree(indent + "  ");
        }
    }
}