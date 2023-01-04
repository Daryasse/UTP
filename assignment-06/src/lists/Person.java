package lists;

import extents.Persons;

import java.text.Collator;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public abstract class Person implements Comparable<Person> {

    private String pesel;
    private String surname;
    private String firstName;
    private Date birthdate;
    private Nationality nationality;

    protected Person(String pesel, String surname, String firstName, Date birthdate, Nationality nationality) {
        this.pesel = pesel;
        this.surname = surname;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.nationality = nationality;
        Persons.add(this);
    }

    public String getPesel() {
        return this.pesel;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public Nationality getNationality() {
        return this.nationality;
    }

    private static final Collator polishCollator = Nationality.Polish.getCollator();

    private Comparator<Person> Apha_order = Comparator
            .comparing(Person::getSurname, polishCollator)
            .thenComparing(Person::getFirstName,polishCollator);

    @Override
    public int compareTo(Person o) {
        return Apha_order
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(pesel, person.pesel) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(birthdate, person.birthdate) &&
                nationality == person.nationality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel, surname, firstName, birthdate, nationality);
    }
}
