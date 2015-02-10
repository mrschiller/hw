package base;

import java.util.Calendar;
import java.util.Date;

public class Helper {

    public static Date getCurrentTimePlusXSeconds(int sec) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, sec);
        date = cal.getTime();
        return date;
    }

    public static Integer stringToInteger(String text) {
        try {
            return new Integer(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
