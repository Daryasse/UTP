import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PESEL {
    private static final String digit = "[0-9]";
    private static final String doubleDigit = digit + "{2}";
    private static final String begin = "^";
    private static final String end = "$";
    private static final String pesel = begin + "|" + doubleDigit + "|"
            + "|" + doubleDigit + "|"
            + "|" + doubleDigit + "|"
            + digit + "{3}"
            + "|" + digit + "|"
            + digit
            + end;
    private static final Pattern pesel_regex = Pattern.compile(pesel);
    private static final int[] multipliers = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};
    private final String value;
    private final Date birthdate;
    private final Sex sex;

    public PESEL(String value) throws Exception {
        validate(value, true);
        this.value = value;
        this.birthdate = getBirthDate(value, true);
        this.sex = getSex(value);
    }

    public Date getBirthDate() {
        return birthdate;
    }

    public Sex getSex() {
        return sex;
    }

    public String getValue() {
        return value;
    }

    private static boolean validate(String inputValue, boolean exception) throws Exception {
        Matcher matcher = pesel_regex.matcher(inputValue);
        if (!matcher.matches()) {
            if (!exception) {
                return false;
            }
            throw new Exception("wrong Pesel: " + inputValue);
        }
        boolean result = validateControlDigit(inputValue);
        if (!result && exception) {
            throw new Exception("wrong checksum");
        }
        return result;
    }

    private static boolean validateControlDigit(String inputValue) {
        int sum = 0;
        for (int i = 0; i < inputValue.length(); i++) {
            char character = inputValue.charAt(i);
            int charValue = character - '0';
            sum += multipliers[i] * charValue;
        }
        return sum % 10 == 0;
    }

    private static Date getBirthDate(String inputValue, boolean exception) throws Exception {
        Matcher matcher = pesel_regex.matcher(inputValue);
        if(!matcher.matches()){
            if(exception){
                throw new Exception("wrong date specification");
            }else{
                return null;
            }
        }
        int lastYearDigits = Integer.parseInt(matcher.group(1));
        int monthDigits = Integer.parseInt(matcher.group(2));
        int dayDigits = Integer.parseInt(matcher.group(3));
        int month = monthDigits % 20;
        int century = monthDigits /20;
        int year = 0;
        switch (century){
            case 4:
                year = 1800 + lastYearDigits;
                break;
            case 0:
                year = 1900 + lastYearDigits;
                break;
            case 1:
                year = 2000 + lastYearDigits;
                break;
            case 2:
                year = 2100 + lastYearDigits;
                break;
            case 3:
                year = 2200 + lastYearDigits;
                break;
        }
        Calendar calendar =Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month - 1, dayDigits);
        return calendar.getTime();
    }

    private static Sex getSex(String inputValue){
        final int SexCharacterIndex = 9;
        char sexCharecter = inputValue.charAt(SexCharacterIndex);
        int sexValue = sexCharecter - '0';
        return (sexValue % 2 == 0)? Sex.female : Sex.male;
    }


}
