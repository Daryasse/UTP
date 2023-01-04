import generators.GeneratorOfDates;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class GeneratorOfDatesTest {
    @Test
    public void testBirthdateGenerator() {
        Date birthdate = GeneratorOfDates.generateDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthdate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        Assert.assertTrue(year >= 1951 && year <= 2001);
        Assert.assertNotEquals(13, month);
    }

    @Test
    public void testHireDateGenerator() {
        Date birthdate = GeneratorOfDates.generateDate();
        Date hiredate = GeneratorOfDates.generateHiredate(birthdate);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthdate);
        int yearBirth = calendar.get(Calendar.YEAR);
        calendar.setTime(hiredate);
        int yearHire = calendar.get(Calendar.YEAR);

        Assert.assertNotEquals(birthdate.compareTo(hiredate), 1);
        Assert.assertTrue(yearHire - yearBirth >= 18);
    }
}