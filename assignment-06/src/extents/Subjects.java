package extents;

import lists.Subject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subjects {
    private static Set<Subject> instance;
    private static List<Subject> subjectsList;

    static {
        instance = new HashSet<>();
        subjectsList =new ArrayList<>();
    }

    public static void add(Subject s){
        instance.add(s);
        subjectsList.add(s);
    }

    public static Set <Subject> instance(){
        return instance;
    }
}
