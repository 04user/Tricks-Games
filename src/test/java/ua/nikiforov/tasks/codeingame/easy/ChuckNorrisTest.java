package ua.nikiforov.tasks.codeingame.easy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static ua.nikiforov.tasks.codeingame.easy.ChuckNorris.*;


/**
 * @author Sergey Nikiforov
 */
@RunWith(Parameterized.class)
public class ChuckNorrisTest {
    private String fileNameConsistInputData;
    private String fileNameConsistExpectedData;

    public ChuckNorrisTest(String fileNameConsistInputData, String fileNameConsistExpectedData) {
        this.fileNameConsistInputData = fileNameConsistInputData;
        this.fileNameConsistExpectedData = fileNameConsistExpectedData;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new String[][]{
                {"Chuck_Norris_case1_input.txt", "Chuck_Norris_case1_output.txt"},
                {"Chuck_Norris_case2_input.txt", "Chuck_Norris_case2_output.txt"},
                {"Chuck_Norris_case3_input.txt", "Chuck_Norris_case3_output.txt"},
                {"Chuck_Norris_message_input.txt", "Chuck_Norris_message_output.txt"},
        });
    }

    @Test
    public void test() {
        String inputMessage = readDataFromFile(getClass().getResource(fileNameConsistInputData).getFile());
        String expectedData = readDataFromFile(getClass().getResource(fileNameConsistExpectedData).getFile());

        String encodedOutputMessage = getChuckNorrisEncodedOutputMessage(inputMessage);

        Assert.assertEquals(expectedData, encodedOutputMessage);
    }
}
