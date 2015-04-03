package ua.nikiforov;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sergey Nikiforov
 */
public class UniqueValueTest {
    @Test
    public void testFindUniqueValue() {
        assertEquals("Must be 5.", 5, UniqueValue.findUniqueValue(new int[]{1,2,3,5,3,2,1}));
    }
}
