package generators;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GeneratorOfDates {
    private static Random random = new Random();
    private static Date current = new Date();

    private static int yearStart;

    private static int yearEnd = 70;
    private static int yearInFuture = 45;

    private static int monthStart = 1;
    private static int monthEnd = 12;

    private static int daysStart = 1;
    private static int daysEnd = 28;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current);
        int currentYear = calendar.get(Calendar.YEAR);
        yearStart = currentYear - yearEnd;
    }

    public static Date generateDate(){
        int year = yearStart + random.nextInt(yearInFuture);
        int month = monthStart + random.nextInt(monthEnd);
        int day = daysStart + random.nextInt(daysEnd);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    private static Date current1 = new Date();

    private static int monthStart1 = 1;
    private static int monthEnd1 = 12;

    private static int daysStart1 = 1;
    private static int daysEnd1 = 28;

    public static Date generateHiredate(Date birthdate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthdate);
        int yearStart1 = calendar.get(Calendar.YEAR) + 18;
        calendar.setTime(current1);
        int YEAR_COUNT = calendar.get(Calendar.YEAR) - yearStart1;
        int y = yearStart1 + random.nextInt(YEAR_COUNT);
        int m = monthStart1 + random.nextInt(monthEnd1);
        calendar.set(Calendar.MONTH, m);
        int d = daysStart1 + random.nextInt(daysEnd1);
        calendar.set(y, m, d);
        return calendar.getTime();
    }


}
