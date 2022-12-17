package Automation_test;

public class Java_Enum {


    enum day {monday,tuesday,wedsday,thurday,friday,saturday,sunday}

    public static void main(String[] args) {
        day test = day.friday;
        for (day duyetday: day.values()) {
            if(duyetday.equals(day.sunday)){
                System.out.println(duyetday);
            }
        }
    }
}
