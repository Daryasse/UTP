package extents;

import lists.StudentGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentGroups {
    private static Set<StudentGroup> instance;
    private static List<StudentGroup> studentGroupListList;

    static {
        instance = new HashSet<>();
        studentGroupListList = new ArrayList<>();
    }

    public static void add(StudentGroup s){
        instance.add(s);
        studentGroupListList.add(s);
    }

    public static Set <StudentGroup> instance(){
        return instance;
    }
}
