package ua.nikiforov.tasks.codeingame.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.*;
import static ua.nikiforov.tasks.codeingame.easy.Defibrillators.Defibrillator.DefibrillatorBuilder;

/**
 * @author Sergey Nikiforov
 */
public class Defibrillators {
    private Map<String, Defibrillator> defibrillators;
    private double userLatitude;
    private double userLongitude;

    public static void main(String args[]) {
        Defibrillators defibrillators = new Defibrillators();
        defibrillators.readDataFromInputSteam(System.in);

        Defibrillator defibrillator = defibrillators.computeNearestDefibrillatorLocation();
        System.out.println(defibrillator.getName());
    }

    public Defibrillator computeNearestDefibrillatorLocation() {
        double minDistance = Double.MAX_VALUE;
        String idDefibrillatorWhichLocatedNearest = "HAVEN'T EXISTED ANY DEFIBRILLATOR";

        for (Map.Entry<String, Defibrillator> entry : defibrillators.entrySet()) {
            Defibrillator defibrillator = entry.getValue();
            double distanceBetweenTwoPoints = computeDistanceBetweenTwoPoints(userLongitude, userLatitude,
                    defibrillator.getLongitude(), defibrillator.getLatitude());

            minDistance = Double.min(minDistance, distanceBetweenTwoPoints);
            if (Double.valueOf(minDistance).equals(distanceBetweenTwoPoints)) {
                idDefibrillatorWhichLocatedNearest = entry.getKey();
            }
        }
        return defibrillators.get(idDefibrillatorWhichLocatedNearest);
    }

    private double computeDistanceBetweenTwoPoints(double longitudeA, double latitudeA, double longitudeB, double latitudeB) {
        double x = (longitudeB - longitudeA) * cos((latitudeA + latitudeB) / 2);
        double y = (latitudeB - latitudeA);
        return sqrt(pow(x, 2) + pow(y, 2)) * 6371;
    }


    public void readDataFromInputSteam(InputStream in) {
        Scanner scanner = new Scanner(in);
        readData(scanner);
    }

    public void readDataFromFile(String pathToFile) {
        try (Scanner scanner = new Scanner(new File(pathToFile))) {
            readData(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readData(Scanner scanner) {
        userLongitude = scanner.nextDouble();
        scanner.nextLine();
        userLatitude = scanner.nextDouble();
        scanner.nextLine();
        int numberOfDefibrillators = scanner.nextInt();
        scanner.nextLine();
        defibrillators = new HashMap<>(numberOfDefibrillators);
        for (int i = 0; i < numberOfDefibrillators; i++) {
            addDefibrillator(scanner.nextLine());
        }
    }

    private void addDefibrillator(String line) {
        String[] tokens = line.split(";");
        Defibrillator defibrillator = new DefibrillatorBuilder(tokens[1], Double.parseDouble(tokens[4].replace(',', '.')),
                Double.parseDouble(tokens[5].replace(',', '.')))
                .setAddress(tokens[2]).setContactPhoneNumber(tokens[3]).build();
        defibrillators.put(tokens[0], defibrillator);
    }


    static class Defibrillator {
        private double longitude;
        private double latitude;
        private String name;
        private String address;
        private String contactPhoneNumber;

        public Defibrillator(double longitude, double latitude, String name, String address, String contactPhoneNumber) {
            this.longitude = longitude;
            this.latitude = latitude;
            this.name = name;
            this.address = address;
            this.contactPhoneNumber = contactPhoneNumber;
        }

        static class DefibrillatorBuilder {
            private double longitude;
            private double latitude;
            private String name;
            private String address;
            private String contactPhoneNumber;

            public DefibrillatorBuilder(String name, double longitude, double latitude) {
                this.name = name;
                this.longitude = longitude;
                this.latitude = latitude;
            }

            DefibrillatorBuilder setAddress(String address) {
                this.address = address;
                return this;
            }

            DefibrillatorBuilder setContactPhoneNumber(String contactPhoneNumber) {
                this.contactPhoneNumber = contactPhoneNumber;
                return this;
            }

            Defibrillator build() {
                return new Defibrillator(longitude, latitude, name, address, contactPhoneNumber);
            }
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getContactPhoneNumber() {
            return contactPhoneNumber;
        }
    }
}

