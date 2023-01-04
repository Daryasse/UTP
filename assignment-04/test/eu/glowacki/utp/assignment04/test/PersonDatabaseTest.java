package eu.glowacki.utp.assignment04.test;

import eu.glowacki.utp.assignment04.InputParser;
import eu.glowacki.utp.assignment04.Person;
import eu.glowacki.utp.assignment04.PersonDatabase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PersonDatabaseTest {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    private static File file;
    PersonDatabase database;

    @Before
    public void Before(){
        file = new File("src/eu/glowacki/utp/assignment04/INput.txt");
        List<Person> data = InputParser.parse(file);
        this.database = new PersonDatabase(data);
    }

    @Test
    public void sortedByFirstNameTest() {

        List<Person> sortedByFirstNameList = this.database.sortedByFirstName();

        Assert.assertEquals("Adam", sortedByFirstNameList.get(0).getFirstName());
        Assert.assertEquals("1990-07-03", dateFormat.format(sortedByFirstNameList.get(1).getBirthdate()));
        System.out.println(sortedByFirstNameList.toString());
    }

    @Test
    public void sortedBySurnameFirstNameAndBirthdateTest() {

        List<Person> sortedList = this.database.sortedBySurnameFirstNameAndBirthdate();

        System.out.println(sortedList.toString());
        Assert.assertEquals("Adamer", sortedList.get(0).getSurname());
        Assert.assertEquals("Adamer", sortedList.get(1).getSurname());
        Assert.assertEquals("1991-02-12", this.dateFormat.format(sortedList.get(0).getBirthdate()));
        Assert.assertEquals("1987-11-10", this.dateFormat.format(sortedList.get(1).getBirthdate()));
    }

    @Test
    public void sortedByBirthdateTest() {

        List<Person> sortedList = this.database.sortedByBirthdate();

        System.out.println(sortedList.toString());
        Assert.assertEquals("Joi", sortedList.get(0).getFirstName());
        Assert.assertEquals("Doich", sortedList.get(0).getSurname());
        Assert.assertEquals("1965-05-27", this.dateFormat.format(sortedList.get(0).getBirthdate()));
        Assert.assertEquals("Brown", sortedList.get(1).getSurname());
        Assert.assertEquals("1976-04-08", this.dateFormat.format(sortedList.get(1).getBirthdate()));
    }

    @Test
    public void bornOnDayTest()  throws Exception {

        List<Person> resultList = this.database.bornOnDay(this.dateFormat.parse("1987-11-10"));

        System.out.println(resultList.toString());
        Assert.assertEquals( 3, resultList.size());

        Assert.assertEquals("Shelf", resultList.get(0).getSurname());
        Assert.assertEquals("Adamer", resultList.get(1).getSurname());
        Assert.assertEquals("Evans", resultList.get(2).getSurname());
        Assert.assertEquals("1987-11-10", this.dateFormat.format(resultList.get(0).getBirthdate()));
        Assert.assertEquals("1987-11-10", this.dateFormat.format(resultList.get(1).getBirthdate()));
        Assert.assertEquals("1987-11-10", this.dateFormat.format(resultList.get(2).getBirthdate()));
    }
}