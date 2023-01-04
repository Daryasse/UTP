package extents;

import lists.Teacher;

import java.util.*;

public class Teachers extends Persons{
    private static Set<Teacher> instance;
    private static List<Teacher> teachersList;

    static {
        instance = new HashSet<>();
        teachersList =new ArrayList<>();
    }

    public static Set <Teacher> GetInstance(){
        return instance;
    }

    public static void add(Teacher teacher){
        instance.add(teacher);
        teachersList.add(teacher);
        teachersList.sort(Comparator.naturalOrder());
    }

}
