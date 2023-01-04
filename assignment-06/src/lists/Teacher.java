package lists;

import extents.Teachers;

import java.util.Date;
import java.util.Objects;

public class Teacher extends Person {

    private academicDegree degree;
    private Date hiredate;

    public Teacher (String pesel,String surname,String firstName, Date birthdate, Nationality nationality,
                    academicDegree degree, Date hiredate){

        super(pesel, surname, firstName, birthdate, nationality);
        this.degree = degree;
        this.hiredate = hiredate;
        Teachers.add(this);
    }

    public academicDegree getDegree() {
        return degree;
    }

    public Date getHiredate() {
        return hiredate;
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
        Teacher teacher = (Teacher) o;
        return Objects.equals(degree, teacher.degree) &&
                Objects.equals(hiredate, teacher.hiredate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), degree, hiredate);
    }
}
