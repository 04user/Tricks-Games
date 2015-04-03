package ua.nikiforov.tasks.codeingame.easy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static ua.nikiforov.tasks.codeingame.easy.ChuckNorris.getChuckNorrisEncodedOutputMessage;
import static ua.nikiforov.tasks.codeingame.easy.ChuckNorris.readDataFromFile;


/**
 * @author Sergey Nikiforov
 */
@RunWith(Parameterized.class)
public class DefibrillatorsTest {
    private String fileNameConsistInputData;
    private String expectedOutput;

    public DefibrillatorsTest(String fileNameConsistInputData, String expectedOutput) {
        this.fileNameConsistInputData = fileNameConsistInputData;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new String[][]{
                {"Defibrillators_simple_test.txt", "Maison de la Prevention Sante"},
        });
    }

    @Test
    public void test() {
        Defibrillators defibrillators = new Defibrillators();
        defibrillators.readDataFromFile(getClass().getResource(fileNameConsistInputData).getFile());

        Defibrillators.Defibrillator defibrillator = defibrillators.computeNearestDefibrillatorLocation();

        Assert.assertEquals(expectedOutput, defibrillator.getName());
    }
}
