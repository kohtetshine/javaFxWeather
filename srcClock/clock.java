import java.text.SimpleDateFormat;
import java.util.Date;

public class clock {

    // Method to get the current time and date
    public static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

    public static void main(String[] args) {

        // Thread for continuously updating and printing the current time
        Thread timeDisplayThread = new Thread(() -> {
            while (true) {
                System.out.println("Current Time: " + getCurrentTime());
                try {
                    // Update the time every second (1000 ms)
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Background thread (lower priority) for future functionality, e.g., fetching
        // data
        Thread backgroundThread = new Thread(() -> {
            while (true) {
                // Placeholder for background task (no operation)
                try {
                    Thread.sleep(2000); // Simulate a background task with a delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Setting thread priorities
        timeDisplayThread.setPriority(Thread.MAX_PRIORITY); // Higher priority for displaying time
        backgroundThread.setPriority(Thread.MIN_PRIORITY); // Lower priority for background task

        // Start both threads
        timeDisplayThread.start();
        backgroundThread.start();
    }
}
