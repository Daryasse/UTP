package eu.glowacki.utp.assignment08.test;
import eu.glowacki.utp.assignment08.InputParse;
import eu.glowacki.utp.assignment08.Person;
import eu.glowacki.utp.assignment08.PersonDatabase;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonDatabaseTest {

	@Test
	public void serializeAndDeserialize() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		try{
			Person person1 = new Person("Atrem", "Nemer", Date.from(Instant.now()));
			Person person2 = new Person("Vika", "Gols", format.parse("31-12-1999"));
			Person person3 = new Person("Lina", "Lubin", format.parse("06-05-2004"));
			List <Person> listik = new ArrayList<>();
			listik.add(person1);
			listik.add(person2);
			listik.add(person3);

			FileOutputStream seria = new FileOutputStream("data.txt");
			DataOutputStream parse = new DataOutputStream(seria);
			PersonDatabase database1 = new PersonDatabase(listik);
			database1.serialize(parse);
			parse.close();

			DataInputStream in = new DataInputStream(new FileInputStream("data.txt"));
			PersonDatabase database2 = PersonDatabase.deserialize(in);
			in.close();

			Assert.assertEquals(database1.sortedByBirthdate().size(), database2.sortedByBirthdate().size());
            Assert.assertEquals(database1.sortedByFirstName().get(1).getFirstName(), "Lina");
			Assert.assertEquals(database2.sortedByFirstName().get(1).getFirstName(), "Lina");
			Assert.assertEquals(database2.sortedByBirthdate().get(0).getSurname(),
					database1.sortedByBirthdate().get(0).getSurname());
            Assert.assertEquals(database1.sortedBySurnameFirstNameAndBirthdate().get(1).getSurname(), "Lubin");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}