package generators;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GeneratorOfPesel {
    private static Random random = new Random();
    private static int[] multipliers = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
     static int[] f = {0, 2, 4, 6, 8};
   static int[] m = {1, 3, 5, 7, 9};

    private static int getSexID() {
        char[] sexPossible = {'M', 'F'};
        char result = sexPossible[random.nextInt(sexPossible.length)];
        int s = switch (result){
            case 'F' -> random.nextInt(f.length);
            case 'M' -> random.nextInt(m.length);
            default -> throw new IllegalStateException("Unexpected value: " + result);
        };
        return s;
    }

    public static String generatePesel(Date birhdate) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birhdate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int monthField = 0;
        int yearField = year % 100;
        int threeDigits = random.nextInt(1000);
        int sex = getSexID();
        int checkSum = 0;


        if (yearField<18) {
            throw new Exception("The year is is out of bound");
        } else if (yearField==18) {
            monthField = month + 80;
        } else if (yearField==19) {
            monthField = month;
        } else if (yearField==20) {
            monthField = month + 20;
        } else if (yearField==21) {
            monthField = month + 40;
        } else if (yearField==22) {
            monthField = month + 60;
        } else if (yearField==23) {
            throw new Exception("The year is out of bound");
        }

        String firstSixDigits = String.format("%02d%02d%02d", yearField, monthField + 1, day);
        String secondFourDigits = String.format("%03d%01d", threeDigits, sex);
        String tenDigits = firstSixDigits + secondFourDigits;

        for (int i = 0; i < multipliers.length; i++) {
            checkSum += multipliers[i] * tenDigits.charAt(i);
        }
        int modify = checkSum % 10;
        String finalDigit = Integer.toString(modify == 0 ? 0 : 10 - modify);
        String PESEL = tenDigits + finalDigit;

        return PESEL;
    }
}
