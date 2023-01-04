package eu.glowacki.utp.assignment08.test;

import eu.glowacki.utp.assignment08.Assignment08Exception;
import eu.glowacki.utp.assignment08.Person;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class PersonTest {

	@Test
	public void serializeAndDeserialize() throws IOException, Assignment08Exception, ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt"));
		Person person1 = new Person("Misha", "Akiev", format.parse("30-08-2004"));
		person1.serialize(out);
		out.close();

		DataInputStream in = new DataInputStream(new FileInputStream("data.txt"));
		Person person2 = Person.deserialize(in);
		in.close();

		System.out.println(person1);
		System.out.println(person2);

		Assert.assertEquals(0, person1.compareTo(person2));
		Assert.assertNotEquals(1, person1.compareTo(person2));
		Assert.assertEquals(person1.getSurname(),person2.getSurname());
		}

	}
