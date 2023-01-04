package eu.glowacki.utp.assignment01.solution;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
   private final int GRANT = 300;
   private Student student;

    @Before
    public void before(){
        student = new Student(GRANT);
        Assert.assertEquals(GRANT, student.getGrant());
    }

    @Test
    public void aggregate() {
        int aggregate = student.aggregate(null);
        Assert.assertEquals(aggregate, GRANT);
        final int unit = 200;
        Assert.assertEquals((GRANT+unit),(int) student.aggregate(unit));
    }

    @Test
    public void deepClone() {
        Student clone = student.deepClone();
        Assert.assertEquals(clone.getGrant(), student.getGrant());
        Assert.assertNotSame(clone, student);
    }


}