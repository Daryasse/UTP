package eu.glowacki.utp.assignment04;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Person implements Comparable<Person> {

    private final String _firstName;
    private final String _surname;
    private final Date _birthdate;

    public Person(String firstName, String surname, Date birthdate) {
        _firstName = firstName;
        _surname = surname;
        _birthdate = birthdate;
    }

    public Date getBirthdate() {
        return _birthdate;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getSurname() {
        return _surname;
    }

    @Override
    public int compareTo(Person otherPerson) {
        // natural order based on:
        // (1) surname;
        // (2) first name;
        // (3) birth date.
        int comarision = this.getSurname().compareTo(otherPerson.getSurname());
        if (comarision != 0)
            return comarision;

        comarision = this.getFirstName().compareTo(otherPerson.getSurname());

        if (comarision != 0)
            return comarision;

        return this.getBirthdate().compareTo(otherPerson.getBirthdate());

        // TODO Auto-generated method stub
    }
    DateFormat formatOfDate = new SimpleDateFormat("yyyy-mm-dd");
    @Override
    public String toString() {
        return  this.getFirstName() + '\'' +
                this.getSurname() + '\'' +
                this.formatOfDate.format(this.getBirthdate()) + _birthdate;
    }
}