import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Management {

    private Scanner scanner;
    private GenericList<TreeData> tree;
    private DateTimeFormatter format;

    public Management() {
        this.tree = new GenericList<TreeData>(null);
        this.scanner = new Scanner(System.in);
        this.format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void insertPatient() {
        String name;
        LocalDate date = null;
        boolean ok = true;
        System.out.println("Enter name: ");
        name = scanner.nextLine();
        do {
            System.out.println("Enter the registration date with the following format (dd/MM/yyyy): ");
            try {
                ok = true;
                date = LocalDate.parse(scanner.nextLine(), format);
            } catch (Exception e) {
                System.out.println("Incorrect date, enter a valid one");
                ok = false;
            }
        } while (!ok);

        Patient p = new Patient(date, name);

        TreeNode<TreeData> PatientNode = new TreeNode<>(p);
        tree.insertFront(PatientNode);
    }

    public void insertSurvey() {
        LocalDate date = null;
        boolean ok = true;
        do {
            System.out.println("Enter the survey date in the following format (dd/MM/yyyy): ");
            try {
                ok = true;
                date = LocalDate.parse(scanner.nextLine(), format);
            } catch (Exception e) {
                System.out.println("Incorrect date, enter a valid one");
                ok = false;
            }
        } while (!ok);

        Survey e = new Survey(date);
        tree.insertInOrder(new GenericNode<>(e));
    }

    public void insertDays() {
        TreeNode<TreeData> surveyNode = tree.getFirst;
        for (int i = 1; i <= 5; i++) {
            Day d = new Day(i);
            surveyNode.insertInOrder(new GenericNode<TreeData>(d));
        }
    }

    public void insertIntakes() {
        int day = 0;
        boolean ok = true;
        String option2 = null;
        Intake intake = null;

        do {
            do {
                System.out.println("Select day (1-5) (0) to exit: ");
                try {
                    day = scanner.nextInt();
                } catch (NumberFormatException e) {
                    day = -1;
                    System.out.println("That day number does not exist");
                    ok = false;
                }

            } while (day < 0 || day > tree.size());
            if (day == 0) {
                break;
            }
            TreeNode<TreeData> dayNode = tree.getObject(day - 1);
            int option = 0;
            do {
                ok = true;
                System.out.println(
                        "Select intake: 1-(Breakfast) / 2-Mid-Morning / 3-Lunch /4-Snack / 5-Dinner/ -1 - (Previous Menu)");
                try {
                    option = scanner.nextInt();

                } catch (NumberFormatException e) {
                    System.out.println("Insert a number not a letter");
                    ok = false;
                }
                switch (option) {
                    case 1:
                        intake = new Intake(Schedule.BREAKFAST);

                        break;
                    case 2:
                        intake = new Intake(Schedule.MIDMORNING);

                        break;

                    case 3:
                        intake = new Intake(Schedule.LAUNCH);

                        break;
                    case 4:
                        intake = new Intake(Schedule.SNACK);

                        break;
                    case 5:
                        intake = new Intake(Schedule.DINNER);

                        break;
                    case -1:
                        break;

                    default:
                        System.out.println("Wrong option, choose another one");
                        ok = false;
                        break;
                }
            } while (!ok);

            do {
                System.out.println("Enter a food for " + intake.getSchedule().getDescription() + " for day " + day
                        + " (-1 to finish / -2 to list entered food / -3 to empty)");
                scanner = new Scanner(System.in);
                option2 = scanner.nextLine();
                if (option2.equals("-2")) {
                    System.out.println("Entered food: " + intake.getInformation());
                }else if (option2.equals("-3")){
                    intake.empty();
                } else if (!option2.equals("-1")) {
                    System.out.println("Enter gram info: ");
                    int grams = scanner.nextInt();
                    intake.insertFood(new Food(option2, grams));
                }
            } while (!option2.equals("-1"));

            if (intake != null) {
                dayNode.insertInOrder(new GenericNode<TreeData>(intake));
            }

        } while (true);
    }

    public void takeData() {
        insertPatient();
        insertSurvey();
        insertDays();
        insertIntakes();

    }

    public void show() {
        tree.preOrder(tree.getRoot());
    }
}
