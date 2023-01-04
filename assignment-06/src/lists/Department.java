package lists;

import extents.Departments;

import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private List<Teacher> teachers;

    public Department(String name, List <Teacher> teachers){
        this.name = name;
        this.teachers = teachers;
        Departments.add(this);
    }

    public String getName(){
        return name;
    }

    public List <Teacher> getTeachers(){
        return teachers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(teachers, that.teachers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teachers);
    }
}
