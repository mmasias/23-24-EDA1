package NotPOO;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       
        TreeNode paciente = new TreeNode(name());

        List<TreeNode> dias = new List<>();
        paciente.children = dias;

        while (true) {
            System.out.println(paciente.key);
            int selectedDay = selectDay(paciente);

            TreeNode dia = getDayNodeOrCreateNew(dias, selectedDay);
            if (dia != null) {
                setIngesta(dia, scanner);
            }
        }
    }

    public static String name(){
        System.out.println("Ingresa tu nombre");
        String name = scanner.nextLine();
        return name;
    }

    public static int selectDay(TreeNode paciente) {
        while (true) {
            System.out.println("Seleccione día de 1 a 5 (-1 para mostrar información / -2 para salir): ");
            int selectedDay = scanner.nextInt();
            
            if (selectedDay == -2) {
                System.out.println("Saliendo del programa...");
                System.exit(0);
            } else if (selectedDay == -1) {
                Tree.printTree(paciente, 0);
            } else if (selectedDay > 5 || selectedDay < 1) {
                System.out.println("Número no disponible");
            } else {
                return selectedDay;
            }
        }
    }


    public static void setIngesta(TreeNode dia, Scanner scanner) {
        while (true) {
            System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)");
            int selectedMeal = scanner.nextInt();
            if (selectedMeal == -1) {
                break;
            }

            scanner.nextLine(); // Limpiar el buffer del scanner

            String mealName = getMealName(selectedMeal);
            TreeNode ingesta = getMealNodeOrCreateNew(dia.children, mealName);

            if (ingesta != null) {
                addFoods(ingesta, scanner);
            }
        }
    }

    public static void addFoods(TreeNode ingesta, Scanner scanner) {
        while (true) {
            System.out.println("Ingrese un alimento (-1 para terminar / -2 para listar alimentos ingresados): ");
            String food = scanner.nextLine();

            if (food.equals("-1")) {
                break;
            } else if (food.equals("-2")) {
                listFoods(ingesta.children);
            } else {
                TreeNode alimento = new TreeNode(food);
                ingesta.children.insert(alimento, -1);
            }
        }
    }

    public static void listFoods(List<TreeNode> alimentos) {
        Object[] array = alimentos.listData();
        if (array.length == 0) {
            System.out.println("No se han ingresado alimentos.");
        } else {
            System.out.println("Alimentos ingresados:");
            for (Object food : array) {
                System.out.println(((TreeNode) food).key);
            }
        }
    }

    public static TreeNode getDayNodeOrCreateNew(List<TreeNode> dias, int selectedDay) {
        for (Object day : dias.listData()) {
            TreeNode existingDay = (TreeNode) day;
            if (existingDay.key.equals("Dia " + selectedDay)) {
                return existingDay;
            }
        }

        TreeNode newDay = new TreeNode("Dia " + selectedDay);
        dias.insert(newDay, -1);
        return newDay;
    }

    public static TreeNode getMealNodeOrCreateNew(List<TreeNode> comidas, String mealName) {
        for (Object comida : comidas.listData()) {
            TreeNode existingMeal = (TreeNode) comida;
            if (existingMeal.key.equals(mealName)) {
                return existingMeal;
            }
        }

        TreeNode newMeal = new TreeNode(mealName);
        comidas.insert(newMeal, -1);
        return newMeal;
    }

    public static String getMealName(int selectedMeal) {
        String mealName = "";
        switch (selectedMeal) {
            case 1:
                mealName = "Desayuno";
                break;
            case 2:
                mealName = "Media mañana";
                break;
            case 3:
                mealName = "Almuerzo";
                break;
            case 4:
                mealName = "Merienda";
                break;
            case 5:
                mealName = "Cena";
                break;
            default:
                break;
        }
        return mealName;
    }
}