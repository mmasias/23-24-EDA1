package src;

import java.util.Scanner;

public class Food {
    static Scanner scanner = new Scanner(System.in);
    
    public Food() {}

    public static void setIngesta(TreeNode dia) {
        while (true) {
            System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)");
            int selectedMeal = scanner.nextInt();
            if (selectedMeal == -1) {
                break;
            }

            scanner.nextLine();

            String mealName = getMealName(selectedMeal);
            TreeNode ingesta = getMealNodeOrCreateNew(dia.children, mealName);

            if (ingesta != null) {
                addFoods(ingesta);
            }
        }
    }

    public static void addFoods(TreeNode ingesta) {
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
}