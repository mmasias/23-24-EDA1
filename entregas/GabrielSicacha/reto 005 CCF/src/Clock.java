public class Clock {
    int min;
    int hour;
    boolean anteMeridian;

    public Clock(int hour, int min, boolean anteMeridian) {
        this.hour = hour;
        this.min = min;
        this.anteMeridian = anteMeridian;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMin() {
        return min;
    }

    public int getHour() {
        return hour;
    }

    public boolean isAnteMeridian() {
        return anteMeridian;
    }

    public String clock() {
        String clock;
        System.out.println();
        String meridian = "";

        if (min > 59) {
            hour++;
            min = min - 60;
            if (hour == 12) {
                anteMeridian = !anteMeridian;
            } else if (hour > 12) {
                hour = hour - 12;
            }
        }

        if (anteMeridian) {
            meridian = "AM";
        } else {
            meridian = "PM";
        }
        if (min < 10) {
            clock = hour + ":0" + min + meridian;
        } else {
            clock = hour + ":" + min + meridian;
        }
        return clock;
    }
}

