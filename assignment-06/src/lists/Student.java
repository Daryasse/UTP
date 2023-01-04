package lists;

import extents.Students;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class Student extends Person {
    private String studentBookNumber;

    public Student(String pesel, String surname, String firstName, Date birthdate, Nationality nationality,
                   String studentBookNumb) {
        super(pesel, surname, firstName, birthdate, nationality);
        this.studentBookNumber = studentBookNumb;
        Students.add(this);
    }

    @Override
    public Date getBirthdate() {
        return super.getBirthdate();
    }

    @Override
    public Nationality getNationality() {
        return super.getNationality();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getPesel() {
        return super.getPesel();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    public String getStudentBookNumber() {
        return studentBookNumber;
    }

    public static String generateStudentBookNumber() {
        Random random = new Random();
        String studentBookNumber = Integer.toString(random.nextInt(1000000));
        return studentBookNumber;
    }

    @Override
    public int compareTo(Person o) {
        return super.compareTo(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(studentBookNumber, student.studentBookNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentBookNumber);
    }
}
