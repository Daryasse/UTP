package lists;

import extents.Subjects;

import java.util.List;
import java.util.Objects;

public class Subject {
    private String name;
    private Department department;
    private Teacher lecturer;
    private List<Student> studentsList;

    public Subject(String name, Department department, Teacher lecturer, List <Student> studentsList) {
        this.name = name;
        this.department = department;
        this.lecturer = lecturer;
        this.studentsList = studentsList;
        Subjects.add(this);
    }

    public String getName(){
        return name;
    }

    public Department getDepartment(){
        return department;
    }

    public Teacher getLecturer(){
        return lecturer;
    }

    public List <Student> getListOfStudents(){
        return studentsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name) &&
                Objects.equals(department, subject.department) &&
                Objects.equals(lecturer, subject.lecturer) &&
                Objects.equals(studentsList, subject.studentsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, lecturer, studentsList);
    }
}
