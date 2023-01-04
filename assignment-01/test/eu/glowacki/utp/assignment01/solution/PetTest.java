package eu.glowacki.utp.assignment01.solution;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PetTest {
    private final String NAME = "Kate";
    private Pet cat;

    @Before
    public void before(){
        cat = new Pet(NAME);
        Assert.assertEquals(NAME, cat.getName());
    }

    @Test
    public void aggregate() {
        String aggregate = cat.aggregate(null);
        Assert.assertEquals(NAME, aggregate);
        final String unit = "Max";
        Assert.assertEquals((NAME+unit), cat.aggregate(unit));
    }

    @Test
    public void deepClone() {
        Pet clone = cat.deepClone();
        Assert.assertEquals(clone.getName(), cat.getName());
        Assert.assertNotSame(clone, cat);
    }
}