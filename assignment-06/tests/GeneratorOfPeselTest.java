import generators.GeneratorOfDates;
import generators.GeneratorOfPesel;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneratorOfPeselTest {
    private static Pattern pattern = Pattern.compile("^[0-9]{11}$");

    @Test
    public void testGeneratePesel() throws Exception {
        String pesel = GeneratorOfPesel.generatePesel(GeneratorOfDates.generateDate());
        Matcher matcher = pattern.matcher(pesel);
        System.out.println(pesel);
        Assert.assertTrue(matcher.matches());
        Assert.assertFalse(pesel.length()<11);
    }

}