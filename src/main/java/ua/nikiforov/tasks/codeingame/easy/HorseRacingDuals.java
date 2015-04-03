package ua.nikiforov.tasks.codeingame.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Sergey Nikiforov
 */
public class HorseRacingDuals {
    public static void main(String[] args) {
        int[] horsesStrength = readDataFromInputSteam(System.in);
        int diff = getDifferentBetweenTwoClosestHorses(horsesStrength);
        System.out.println(diff);
    }

    public static int getDifferentBetweenTwoClosestHorses(int[] horsesStrength) {
        List<Integer> list = Arrays.stream(horsesStrength).parallel().sorted().boxed().collect(Collectors.toList());

        int diff = list.get(1) - list.get(0);
        int newDiff = 0;
        for (int i = 2; i < list.size(); i++) {
            if ((newDiff = list.get(i) - list.get(i - 1)) < diff) {
                diff = newDiff;
            }
        }

        return diff;
    }

    private static int[] readDataFromInputSteam(InputStream in) {
        Scanner scanner = new Scanner(in);
        return readData(scanner);
    }

    public static int[] readDataFromFile(String pathTofile) {
        try (Scanner scanner = new Scanner(new File(pathTofile))) {
            return readData(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new int[0];
    }

    public static int[] readData(Scanner scanner) {
        int numberOfHorses = scanner.nextInt();
        int[] horsesStrength = new int[numberOfHorses];
        for (int i = 0; i < numberOfHorses; i++) {
            horsesStrength[i] = scanner.nextInt();
        }
        return horsesStrength;
    }

}
