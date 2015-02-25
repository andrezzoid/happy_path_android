package pt.andrezzoid.example.services;

/**
 * Created by André Jonas on 25/02/2015.
 */
public class ThreadUtils {
    /**
     * Sleeps for the given time even if InterruptedException is thrown
     * @param millis
     */
    public static void sleepUninterruptibly(int millis){
        long remaining = millis;
        long end = System.currentTimeMillis() + remaining;
        boolean interrupted = false;
        try {
            do {
                try {
                    Thread.sleep(remaining);
                    return;
                } catch (InterruptedException e) {
                    interrupted = true;
                    long now = System.currentTimeMillis();
                    remaining = end - now;
                }
            } while (true);
        }finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
