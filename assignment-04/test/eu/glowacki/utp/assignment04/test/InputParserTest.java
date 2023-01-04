package eu.glowacki.utp.assignment04.test;

import eu.glowacki.utp.assignment04.InputParser;
import eu.glowacki.utp.assignment04.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public final class InputParserTest {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    private static File file;

    List<Person> listik;

    @Before
    public void Before() {
        this.file = new File("src/eu/glowacki/utp/assignment04/INput.txt");
        Assert.assertTrue(file.exists());
    }

    @Test

    public void MatchFileTest(){


        this.listik = InputParser.parse(file);

        Assert.assertEquals("Adam", this.listik.get(3).getFirstName());
        Assert.assertEquals("Shelf", this.listik.get(3).getSurname() );
        Assert.assertEquals("1987-11-10", this.dateFormat.format(this.listik.get(3).getBirthdate()));
        Assert.assertEquals("Bobby", this.listik.get(1).getFirstName());
        Assert.assertEquals("Brown", this.listik.get(1).getSurname() );
        Assert.assertEquals("1976-04-08", this.dateFormat.format(this.listik.get(1).getBirthdate()));
    }

    @Test
    public void FileNotNullTest() throws Exception {
        Assert.assertNotNull(InputParser.parse(file));

    }

    @Test
    public void CorrectnessOfSizeTest() throws Exception {

        this.listik = InputParser.parse(file);
        Assert.assertEquals(10, this.listik.size());
    }
}