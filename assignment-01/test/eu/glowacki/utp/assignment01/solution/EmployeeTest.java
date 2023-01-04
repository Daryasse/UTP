package eu.glowacki.utp.assignment01.solution;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    private static final int SALARY = 2000;
    private Employee employee;

    @Before
    public void before(){
        employee = new Employee(SALARY);
        Assert.assertEquals(SALARY, employee.getSalary());
    }

    @Test
    public void aggregate() {
        int aggregate = employee.aggregate(null);
        Assert.assertEquals(SALARY, aggregate);
        final int unit = 300;
        Assert.assertEquals((SALARY+unit), (int) employee.aggregate(unit));

    }

    @Test
    public void deepClone() {
        Employee clone = employee.deepClone();
        Assert.assertEquals(employee.getSalary(), clone.getSalary());
        Assert.assertNotSame(employee, clone);
    }
}