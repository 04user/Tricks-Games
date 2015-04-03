package ua.nikiforov.tasks.codeingame.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Sergey Nikiforov
 */
public class ChuckNorris {
    public static void main(String[] args) {
        String inputMessage = readDataFromInputSteam(System.in);
        String encodedOutputMessage = getChuckNorrisEncodedOutputMessage(inputMessage);
        System.out.println(encodedOutputMessage);
    }

    public static String getChuckNorrisEncodedOutputMessage(String inputMessage) {
        String binaryRepresentation = getBinaryRepresentation(inputMessage);
        return encode(binaryRepresentation);
    }

    private static String encode(String binaryRepresentation) {
        String[] binarySequences = binaryRepresentation.split("(?=(?!^)0)(?<!0)|(?!0)(?<=0)");

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < binarySequences.length; i++) {
            String s = binarySequences[i];
            if (s.charAt(0) == '1') {
                builder.append("0 ").append(s.replace('1', '0'));
            } else {
                builder.append("00 ").append(s);
            }
            if (i < binarySequences.length - 1) {
                builder.append(' ');
            }
        }
        return builder.toString();
    }

    private static String getBinaryRepresentation(String inputMessage) {
        byte[] bytes = inputMessage.getBytes();
        StringBuilder binaryRepresentation = new StringBuilder();
        for (byte b : bytes) {
            /* also we have Integer.toString(int, radix)*/
            binaryRepresentation.append(String.format("%7s", Integer.toBinaryString(b)));
        }

        return binaryRepresentation.toString().replace(' ', '0');
    }

    private static String readDataFromInputSteam(InputStream in) {
        Scanner scanner = new Scanner(in);
        return readData(scanner);
    }

    public static String readDataFromFile(String pathToFile) {
        try (Scanner scanner = new Scanner(new File(pathToFile))) {
            return readData(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String readData(Scanner scanner) {
        return scanner.nextLine();
    }

}
