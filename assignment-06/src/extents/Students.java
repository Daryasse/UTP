package extents;

import lists.Student;

import java.util.*;

public class Students extends Persons{
    private static Set<Student> instance;
    private static List<Student> studentsList;

    static {
        instance = new HashSet<>();
        studentsList =new ArrayList<>();
    }

    public static void add(Student student){
        instance.add(student);
        studentsList.add(student);
        studentsList.sort(Comparator.naturalOrder());
    }

    public static Set <Student> getInstance(){
        return instance;
    }

}
