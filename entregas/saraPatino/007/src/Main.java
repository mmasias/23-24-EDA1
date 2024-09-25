package src;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       
        TreeNode paciente = new TreeNode(User.name(scanner));

        List<TreeNode> dias = new List<>();
        paciente.children = dias;

        while (true) {
            System.out.println(paciente.key);
            int selectedDay = Day.selectDay(paciente);

            TreeNode dia = Day.getDayNodeOrCreateNew(dias, selectedDay);
            if (dia != null) {
                Food.setIngesta(dia);
            }
        }
    }
}