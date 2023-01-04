package eu.glowacki.utp.assignment08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Comparable<Person> {

	private final String _firstName;
	private final String _surname;
	private final Date _birthdate;
	private static final SimpleDateFormat format = new SimpleDateFormat("dd--MM--yyyy");

	public Person(String firstName, String surname, Date birthdate) {
		_firstName = firstName;
		_surname = surname;
		_birthdate = birthdate;
	}

	// assignment 8
	public void serialize(DataOutputStream output) throws Assignment08Exception {
		try{
		output.writeUTF(_firstName);
		output.writeUTF(_surname);
		output.writeUTF(format.format(_birthdate));
		// serialize birth date with getTime() method
		}catch (Throwable exception) {
			throw new Assignment08Exception(exception.getMessage(), exception);
		}
		// encapsulate IOException in Assignment08Exception
	}
	
	public static Person deserialize(DataInputStream input) throws Assignment08Exception {
		try{
			String name = input.readUTF();
			String surname = input.readUTF();
			return new Person(name, surname, format.parse(input.readUTF()));
			}catch (Throwable exception) {
			throw new Assignment08Exception(exception.getMessage(), exception);
		}
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		int result = this.getSurname().compareTo(o.getSurname());
		if (result != 0){
			return result;
		}
		result = this.getFirstName().compareTo(o.getFirstName());
		if (result != 0){
			return result;
		}
		return getBirthDate().compareTo(o.getBirthDate());
	}

	public String getFirstName() {
		return _firstName;
	}

	public String getSurname() {
		return _surname;
	}

	public Date getBirthDate() {
		return _birthdate;
	}

}