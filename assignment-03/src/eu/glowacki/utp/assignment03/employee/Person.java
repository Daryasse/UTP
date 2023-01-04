package eu.glowacki.utp.assignment03.employee;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Person {

    // (assignment 02)
    // attributes:
    // * first name
    // * surname
    // * birth date
    // * age (derived --- computed based on birth date)

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
            return (short)Math.abs((_birthDay.getYear() - today.getYear()));
        }
        else {
            return (short)Math.abs (_birthDay.getYear() - today.getYear() - 1);
        }
    }

	// (assignment 03)
	// methods:
	// * is older than other person
    Comparator<Person> byAge = Comparator.comparing(Person::getAge);
    public boolean isOlder (Person person){
        return byAge.compare(this, person)>0;
    }
    public boolean comparisionAgeGreaterThan (short age){
        return ageComparision.compare(this.getAge(), age)>0;
    }
	// * is younger than other person
    public boolean isYounger (Person person){
        return byAge.compare(this, person)<0;
    }
	// * compare age with other person's age
    Comparator<Short> ageComparision = Comparator.naturalOrder();
    public int ageComparisionWithPerson (Person person){
        return ageComparision.compare(this.getAge(), person.getAge());
    }
}