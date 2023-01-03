package src;

public class Timer {
    private long startTime;
    private long endTime;
    private long elapsedTime;

    public Timer() {
        startTime = 0;
        endTime = 0;
        elapsedTime = 0;
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void PrintElapsedTimeInMilliseconds() {
        System.out.println("Elapsed time: " + elapsedTime / 1000000 + " milliseconds");

    }

    public void reset() {
        startTime = 0;
        endTime = 0;
        elapsedTime = 0;
    }
}
