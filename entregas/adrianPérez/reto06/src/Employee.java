package code;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private List<Employee> subordinates;

    public Employee(String name) {
        this.name = name;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee e) {
        this.subordinates.add(e);
    }

    public List<Employee> getSubordinates() {
        return this.subordinates;
    }

    public String getName() {
        return this.name;
    }
}