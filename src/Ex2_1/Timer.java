package src.Ex2_1;

public class Timer {
    private double startTime;
    private double endTime;
    private double elapsedTime;

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

    public double getElapsedTime() {
        return elapsedTime;
    }

    public void PrintElapsedTimeInMilliseconds() {

        System.out.println("Elapsed time: " +elapsedTime / 1000000 + " milliseconds");
    }
    public void PrintElapsedTimeInseconds() {

        System.out.println("Elapsed time: " +elapsedTime / 1000000000 + " seconds");
    }

    public void reset() {
        startTime = 0;
        endTime = 0;
        elapsedTime = 0;
    }
}
