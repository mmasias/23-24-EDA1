public class Patient {
    String name;
    CustomDate dischargeDate;
    List<Day> days;

    public Patient(String name) {
        this.name = name;
        dischargeDate = new CustomDate((int) (Math.random() * 30 + 1), (int) (Math.random() * 12 + 1), 2023);
        days = new List<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(CustomDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    void addDay(Day day) {
        days.insert(day, -1);
    }


    void showData() {
        System.out.println("Nombre del Paciente: " + name);
        dischargeDate.showData();
        Node<Day> currentDay = days.getFirst();

        List<String> allIntakeNames = new List<>();
        allIntakeNames.insert("Desayuno", -1);
        allIntakeNames.insert("Media mañana", -1);
        allIntakeNames.insert("Almuerzo", -1);
        allIntakeNames.insert("Merienda", -1);
        allIntakeNames.insert("Cena", -1);

        List<String> allDayNames = new List<>();
        allDayNames.insert("1", -1);
        allDayNames.insert("2", -1);
        allDayNames.insert("3", -1);
        allDayNames.insert("4", -1);
        allDayNames.insert("5", -1);

        int dayCounter = 0;

        while (currentDay != null) {
            Day day = currentDay.getData();
            String dayName = day.getName();

            if (allDayNames.size() > 0 && dayName.equals(allDayNames.listData()[0])) {
                allDayNames.remove(0);
            }

            System.out.println(dayName);

            for (int i = 0; i < allIntakeNames.size(); i++) {
                String intakeName = (String) allIntakeNames.listData()[i];
                boolean intakeFound = false;

                Node<Intakes> currentIntake = day.getIntakes().getFirst();

                while (currentIntake != null) {
                    Intakes intakes = currentIntake.getData();
                    if (intakes.getName().equals(intakeName)) {
                        Node<Food> currentFood = intakes.getFoods().getFirst();
                        while (currentFood != null) {
                            Food food = currentFood.getData();
                            System.out.println("    " + intakeName);

                            System.out.println("      " + food.getName() + " (" + food.getKcal() + " kcal)");
                            currentFood = currentFood.getNext();
                        }
                        intakeFound = true;
                        break;
                    }
                    currentIntake = currentIntake.getNext();
                }

                if (!intakeFound) {
                    System.out.println("    " + intakeName);
                }
            }

            currentDay = currentDay.getNext();
            dayCounter++;
        }

        while (dayCounter < allDayNames.size()) {
            String dayName = (String) allDayNames.listData()[dayCounter];
            System.out.println("  Dia " + dayName);
            dayCounter++;
        }
    }

}

