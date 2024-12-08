package labs.lab10.task3;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Events {

    private static final String[] EVENT_TYPES = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
    private static final Random RANDOM = new Random();

    public void generateEventsFile(String filename, int numRecords) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < numRecords; i++) {
                String timestamp = RandomTimestamp();
                String eventType = EVENT_TYPES[RANDOM.nextInt(EVENT_TYPES.length)];
                int userId = RANDOM.nextInt(1000);

                String eventRecord = timestamp + " / Event Type: " + eventType + " / User ID: " + userId;
                writer.write(eventRecord);
                writer.newLine();
            }
            System.out.println("Events file generated successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void printEventsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public List<String> readEventsFromFile(String filename) {
        List<String> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                events.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return events;
    }

    private String RandomTimestamp() {
        long startEpoch = System.currentTimeMillis() - (365L * 24 * 60 * 60 * 1000);
        long endEpoch = System.currentTimeMillis();
        long randomEpoch = startEpoch + (long) (RANDOM.nextDouble() * (endEpoch - startEpoch));
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(randomEpoch));
    }

    public static void main(String[] args) {
        Events events = new Events();

        String filename = "events.txt";
        int numRecords = 10;

        events.generateEventsFile(filename, numRecords);

        System.out.println("\n Events from File: ");
        events.printEventsFromFile(filename);

        System.out.println("\n Events List: ");
        List<String> eventRecords = events.readEventsFromFile(filename);
        for (String record : eventRecords) {
            System.out.println(record);
        }
    }
}
