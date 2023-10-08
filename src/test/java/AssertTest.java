import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jitin on 24/03/2017.
 */
public class AssertTest {


    @Test
    public void assertTrueAndFalseTest(){
        Assert.assertTrue(true);
        Assert.assertFalse(false);
    }

    @Test
    public void assertNullAndNotNullTest(){
        Object myObject = null;
        Assert.assertNull(myObject);

        myObject = new String("test");

        Assert.assertNotNull(myObject);

    }


    @Test
    public void assertEqualsTest(){
        Integer i = new Integer("5");
        Integer j = new Integer("5");

        Assert.assertEquals(i,j);
    }

    @Test
    public void assertNotSameTest(){
        Integer i = new Integer("5");
        Integer j = new Integer("5");

        Assert.assertNotSame(i,j);

        Double first = new Double(3.2);
        Double second = new Double(1.8);
        Double third = new Double(3.2);

        List<Double> list = new ArrayList<Double>();

        Assert.assertEquals(8.20,list.stream().mapToDouble(Double::doubleValue).sum());

    }

    @Test
    public void assertSameTest(){
        Integer i = new Integer("5");
        Integer j = i;

        Assert.assertSame(i,j);

    }
}
