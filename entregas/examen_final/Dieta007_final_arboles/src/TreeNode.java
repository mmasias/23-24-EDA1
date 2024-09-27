import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.Field;

public class TreeNode<T> {
    private T value;
    private TreeNode<T> parent;
    private List<TreeNode<T>> childNodes;

    public TreeNode(T value) {
        this.value = value;
        this.childNodes = new LinkedList<>();
        this.parent = null;
    }

    public void addChild(TreeNode<T> childNode) {
        childNode.setParent(this);
        this.childNodes.add(childNode);
    }

    private void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public TreeNode<T> getParent() {
        return this.parent;
    }

    public TreeNode<T> getRoot() {
        TreeNode<T> current = this;
        while (current.getParent() != null) {
            current = current.getParent();
        }
        return current;
    }

    //todo con el que funcionaba lo primero
    /*public void printTree() {
        printTree("", true);
    }*/

    /*public void printTree() {
        printTree("", true, 0); // Iniciar desde el nodo raíz con índice 0
    }*/


    //todo funciona hasta intakes
    /*private void printTree(String prefix, boolean isTail, int childIndex) {
        T value = getValue();

        String nameToPrint = getNameForValue(value, childIndex);

        System.out.println(prefix + (isTail ? "└── " : "├── ") + nameToPrint);
        for (int i = 0; i < childNodes.size(); i++) {
            childNodes.get(i).printTree(prefix + (isTail ? "    " : "│   "), i == childNodes.size() - 1, i);
        }
    }*/

    /*private void printTree(String prefix, boolean isTail, int childIndex) {
        T value = getValue();

        String nameToPrint = getNameForValue(value, childIndex);

        System.out.println(prefix + (isTail ? "└── " : "├── ") + nameToPrint);
        for (int i = 0; i < childNodes.size(); i++) {
            childNodes.get(i).printTree(prefix + (isTail ? "    " : "│   "), i == childNodes.size() - 1, i);
        }
    }*/


    public void printTree(boolean fullTree) {
        printTree("", true, 0, fullTree); // Agregar el parámetro fullTree
    }

    private void printTree(String prefix, boolean isTail, int childIndex, boolean fullTree) {
        T value = getValue();

        String nameToPrint = getNameForValue(value, childIndex);
        System.out.println(prefix + (isTail ? "└── " : "├── ") + nameToPrint);

        if (fullTree || !(value instanceof Patient)) {
            for (int i = 0; i < childNodes.size(); i++) {
                childNodes.get(i).printTree(prefix + (isTail ? "    " : "│   "), i == childNodes.size() - 1, i, fullTree);
            }
        }
    }

    private String getNameForValue(T value, int index) {
        if (value instanceof Day) {
            Day day = (Day) value;
            String[] names = day.getName();
            if (index >= 0 && index < names.length) {
                return names[index];
            }
            return "Día fuera de rango";
        } else if (value instanceof Intakes) {
            Intakes intakes = (Intakes) value;
            String[] names = intakes.getName();
            if (index >= 0 && index < names.length) {
                return names[index]; // Retorna el nombre de la ingesta basado en el índice
            }
            return "Ingesta fuera de rango";
        } else if (value instanceof Food) {
            Food food = (Food) value;
            return food.getName() + " (" + food.getKcal() + " kcal)"; // Agrega la información de kcal
        } else {
            return getGenericName(value);
        }
    }

    private String getGenericName(T object) {
        if (object == null) {
            return "null";
        }
        try {
            Field nameField = object.getClass().getDeclaredField("name");
            nameField.setAccessible(true);
            Object nameValue = nameField.get(object);
            return nameValue.toString();
        } catch (Exception e) {
            return object.toString();
        }
    }

    //todo este funcionaba lo principal las dos primeras paciente y encuesta

    /* void printTree(String prefix, boolean isTail) {
        T value = getValue();
        String name = getNameUsingReflection(value);

        System.out.println(prefix + (isTail ? "└── " : "├── ") + name);
        for (int i = 0; i < childNodes.size() - 1; i++) {
            childNodes.get(i).printTree(prefix + (isTail ? "    " : "│   "), false);
        }
        if (childNodes.size() > 0) {
            childNodes.get(childNodes.size() - 1).printTree(prefix + (isTail ? "    " : "│   "), true);
        }
    }*/

    private String getNameUsingReflection(T object) {
        try {
            if (object == null) {
                return "null";
            }

            // Intenta obtener el método getName
            Method getNameMethod = object.getClass().getMethod("getName");
            Object returnValue = getNameMethod.invoke(object);

            if (returnValue != null && returnValue instanceof String) {
                return (String) returnValue;
            }

            // Si el método getName no está presente o no devuelve un String
            return "Unnamed Object";
        } catch (Exception e) {
            // Si algo sale mal, retornar una representación genérica
            return object.getClass().getSimpleName() + " Object";
        }
    }

    public T getValue() {
        return value;
    }

    public List<TreeNode<T>> getChildNodes() {
        return childNodes;
    }
}
