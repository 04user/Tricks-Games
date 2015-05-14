package ua.nikiforov.tasks.codeingame.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Sergey Nikiforov
 */
public class MarsLander {
    private static Point[] surfaceOfMars;

    private static int desiredAngle;
    private static int desiredThrustPower;

    private static int x;
    private static int y;
    private static int horizontalSpeed;
    private static int verticalSpeed;
    private static int fuel;
    private static int rotationAngle;
    private static int power;

    private static int startFlatGround;
    private static int endFlatGround;
    private static int flatGroundAltitude;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        initializeLander(in);

        while (true) {
            x = in.nextInt();
            y = in.nextInt();
            horizontalSpeed = in.nextInt();
            verticalSpeed = in.nextInt();
            fuel = in.nextInt();
            rotationAngle = in.nextInt();
            power = in.nextInt();

            computeNewDesiredSettings();

            System.out.println(desiredAngle + " " + desiredThrustPower); // R P. R is the desired rotation angle. P is the desired thrust power.
        }
    }

    private static void initializeLander(Scanner in) {
        int numberOfPoints = in.nextInt();           // the number of points used to draw the surface of Mars.
        surfaceOfMars = new Point[numberOfPoints];

        // X coordinate of a surface point. (0 to 6999)
        // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
        for (int i = 0; i < numberOfPoints; i++) {
            int landX = in.nextInt();
            int landY = in.nextInt();
            surfaceOfMars[i] = new Point(landX, landY);
        }

        Arrays.sort(surfaceOfMars, (o1, o2) -> Integer.compare(o1.x, o2.x));

        findFlatGround();
    }

    private static void findFlatGround() {
        for (int i = 1; i < surfaceOfMars.length; i++) {
            Point start = surfaceOfMars[i - 1];
            Point end = surfaceOfMars[i];
            if (start.y == end.y) {
                startFlatGround = start.x;
                endFlatGround = end.x;
                flatGroundAltitude = end.y;
                break;
            }
        }
    }

    private static void computeNewDesiredSettings() {
        if (x < startFlatGround) {
            desiredAngle -= 15;
        } else if (x > endFlatGround) {
            desiredAngle += 15;
        } else {
            desiredAngle = 0;
        }
    }

    static final class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
