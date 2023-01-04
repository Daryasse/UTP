package extents;

import lists.Department;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Departments {
    private static Set<Department> instance;
    private static List <Department> departmentList;

    static {
        instance = new HashSet<>();
        departmentList =new ArrayList<>();
    }

    public static void add(Department d){
        instance.add(d);
        departmentList.add(d);
    }

    public static Set <Department> instance(){
        return instance;
    }

}
