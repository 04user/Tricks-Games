package ua.nikiforov.main;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sergey Nikiforov
 */
public class MultiplyWithNoMultiplyTest {
    @Test
    public void test1() {
        Assert.assertEquals(5*7, MultiplyWithNoMultiply.multiply(5, 7));
        Assert.assertEquals(7*5, MultiplyWithNoMultiply.multiply(7, 5));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1234*73, MultiplyWithNoMultiply.multiply(1234, 73));
        Assert.assertEquals(5*908, MultiplyWithNoMultiply.multiply(5, 908));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-3*7, MultiplyWithNoMultiply.multiply(-3, 7));
        Assert.assertEquals(3*-5, MultiplyWithNoMultiply.multiply(3, -5));
        Assert.assertEquals(-15*-3, MultiplyWithNoMultiply.multiply(-15, -3));
    }

    @Test
    public void test4() {
        Assert.assertEquals(0, MultiplyWithNoMultiply.multiply(0, 2));
        Assert.assertEquals(0, MultiplyWithNoMultiply.multiply(3, 0));
    }
}
