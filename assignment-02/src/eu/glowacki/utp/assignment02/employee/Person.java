package eu.glowacki.utp.assignment02.employee;
import java.time.LocalDate;
import java.util.Date;

public abstract class Person {

	// To implement an attribute means that you provide a backing field and
	// getter or optionally setter for read-write properties/attributes
	// 
	// NO BACKING FIELDS SHOULD BE PROVIDED FOR DERIVED ATTRIBUTES
	// THOSE SHOULD BE COMPUTED ON-LINE
	//
	// attributes:
	// * first name (read-only)
	// * surname (read-only)
	// * birth date (read-only) --- date MUST BE represented by an instance of
	// the type designed for date representation (either Date or LocalDate)
	//
	// * age (derived --- computed based on birth date) --- implemented as a
	// getter calculating the difference between the current date and birth date

	private final String _firstName; // backing field
	private final String _surname;
	private final LocalDate _birthDay;

	protected Person(String firstName, String surname, LocalDate birthDay) {
		_firstName = firstName;
		_birthDay = birthDay;
		_surname = surname;
	}

	public String getFirstName() { // getter
		return _firstName;
	}

	public String getSurname() { // getter
		return _surname;
	}
	public LocalDate getBirthday() { // getter
		return _birthDay;
	}

	public short getAge() {
		LocalDate today = LocalDate.now();
		if (_birthDay.isBefore(today) || _birthDay.equals(today)){
			return (short)(_birthDay.getYear() - today.getYear());
		}
		else {
			return (short) (_birthDay.getYear() - today.getYear() - 1);
		}
	}
}