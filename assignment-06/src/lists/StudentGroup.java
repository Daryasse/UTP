package lists;

import extents.StudentGroups;

import java.util.List;
import java.util.Objects;

public class StudentGroup {
    private String name;
    private List<Student> studentsList;

    public StudentGroup (String name, List <Student> studentsList ){
        this.name = name;
        this.studentsList = studentsList;
        StudentGroups.add(this);
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(studentsList, that.studentsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studentsList);
    }
}
