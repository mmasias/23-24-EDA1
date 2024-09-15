
public class Organization {
    public static void main(String[] args) {
        Employee ceo = new Employee("CEO");
        Employee cto = new Employee("CTO");
        Employee cfo = new Employee("CFO");
        Employee coo = new Employee("COO");
        Employee hrManager = new Employee("HR Manager");

        ceo.addSubordinate(cto);
        ceo.addSubordinate(cfo);
        ceo.addSubordinate(coo);
        ceo.addSubordinate(hrManager);

        Employee leadDeveloper = new Employee("Lead Developer");
        Employee qaManager = new Employee("QA Manager");

        cto.addSubordinate(leadDeveloper);
        cto.addSubordinate(qaManager);

        Employee seniorDev = new Employee("Senior Developer");
        Employee juniorDev = new Employee("Junior Developer");

        leadDeveloper.addSubordinate(seniorDev);
        leadDeveloper.addSubordinate(juniorDev);

        Employee recruiter = new Employee("Recruiter");
        Employee hrAssistant = new Employee("HR Assistant");

        hrManager.addSubordinate(recruiter);
        hrManager.addSubordinate(hrAssistant);

        Employee accountant = new Employee("Accountant");
        Employee financialAnalyst = new Employee("Financial Analyst");

        cfo.addSubordinate(accountant);
        cfo.addSubordinate(financialAnalyst);

        Employee operationsManager = new Employee("Operations Manager");
        Employee logisticsCoordinator = new Employee("Logistics Coordinator");

        coo.addSubordinate(operationsManager);
        coo.addSubordinate(logisticsCoordinator);


        ceo.printTree("");
    }
}
