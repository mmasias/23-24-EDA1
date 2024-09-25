package src;

import java.util.Scanner;

public class Day {

    static Scanner scanner = new Scanner(System.in);

    public Day(){}

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
}
