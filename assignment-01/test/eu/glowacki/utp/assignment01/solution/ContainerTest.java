package eu.glowacki.utp.assignment01.solution;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;

public class ContainerTest {
    Container<Employee,Integer> listik;
    Employee emp1 = new Employee(400);
    Employee emp2;

    @Before
    public void before(){
        listik = new Container<>();
        listik.addToList(emp1);
        emp2 = emp1.deepClone();
        listik.addToList(emp2);
        ArrayList list = new ArrayList();
        list.add(emp1);
        list.add(emp2);
        assertEquals(list, listik.elements());
    }

    @Test
    public void aggregateAllElements() {
        int aggregate = emp2.aggregate(emp1.aggregate(null));
        int result =  listik.aggregateAllElements();
        assertEquals(aggregate,result);
    }

    @Test
    public void cloneElementAtIndex() {
        Employee clone = listik.cloneElementAtIndex(1);
        Assert.assertEquals(((Employee)listik.elements().get(1)).getSalary(), clone.getSalary());
        Assert.assertNotSame(clone, listik.elements().get(1));
    }
}