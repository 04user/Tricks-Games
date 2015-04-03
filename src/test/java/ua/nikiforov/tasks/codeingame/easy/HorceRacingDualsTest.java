package ua.nikiforov.tasks.codeingame.easy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static ua.nikiforov.tasks.codeingame.easy.HorseRacingDuals.getDifferentBetweenTwoClosestHorses;
import static ua.nikiforov.tasks.codeingame.easy.HorseRacingDuals.readDataFromFile;

/**
 * @author Sergey Nikiforov
 */
@RunWith(Parameterized.class)
public class HorceRacingDualsTest {
    private String fileName;
    private int expected;

    public HorceRacingDualsTest(String fileName, int expected) {
        this.fileName = fileName;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"Horse-racing_Duals_simple_case.txt", 1},
                {"Horse-racing_Duals_horses_in_any_order.txt", 1},
                {"Horse-racing_Duals_many_horses.txt", 47}
        });
    }

    @Test
    public void test() {
        int[] horsesStrength = readDataFromFile(getClass().getResource(fileName).getFile());

        int diff = getDifferentBetweenTwoClosestHorses(horsesStrength);

        Assert.assertEquals(expected, diff);
    }
}
