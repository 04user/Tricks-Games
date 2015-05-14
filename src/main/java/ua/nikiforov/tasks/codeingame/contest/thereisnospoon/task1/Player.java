package ua.nikiforov.tasks.codeingame.contest.thereisnospoon.task1;

import java.util.Scanner;

/**
 * @author Sergey Nikiforov
 */
class Player {
    private static final char NODE = '0';
    private static final char EMPTY_CELL = '.';
    private static final String WHEN_NODE_IS_EMPTY = " -1 -1";
    private static int width;
    private static int height;
    private static char[][] field;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        width = in.nextInt();
        in.nextLine();
        height = in.nextInt();
        in.nextLine();
        field = new char[height][width];

        for (int y = 0; y < height; y++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            for (int x = 0; x < width; x++) {
                field[y][x] = line.charAt(x);
            }
        }

        String coordinates = "";
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (field[y][x] != NODE) {
                    continue;
                }
                coordinates = x + " " + y;

                // Check right coordinate
                coordinates += checkRightCoordinate(x, y);

                // Check bottom coordinate
                coordinates += checkBottomCoordinate(x, y);

                System.err.println(coordinates);
                System.out.println(coordinates);
            }
        }
    }

    private static String checkRightCoordinate(int x, int y) {
        for (int localCursor = x + 1; localCursor < width; localCursor++) {
            if (field[y][localCursor] == NODE) {
                return (" " + localCursor + " " + y);
            }
        }
        return WHEN_NODE_IS_EMPTY;
    }

    private static String checkBottomCoordinate(int x, int y) {
        for (int localCursor = y + 1; localCursor < height; localCursor++) {
            if (field[localCursor][x] == NODE) {
                return " " + x + " " + localCursor;
            }
        }
        return WHEN_NODE_IS_EMPTY;
    }
}
