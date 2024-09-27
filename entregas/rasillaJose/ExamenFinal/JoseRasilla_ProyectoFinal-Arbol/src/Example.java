import java.util.Scanner;

public class Example {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter patient name: ");
            String patientName = scanner.nextLine();
    
            System.out.print("Enter date: ");
            String date = scanner.nextLine();
    
            int duration = InputManager.promptInt("Enter the number of days for the survey: ");
            
            Patient patient = new Patient(patientName, date, duration);
    
            patient.printSurvey();
    
            scanner.close();
        }

    
}
