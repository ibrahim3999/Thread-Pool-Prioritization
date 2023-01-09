package src.Ex2_1;

/**
 * LinesCounterThread -->is Thread
 */
public class LinesCounterThread extends Thread {

    private final String Path;
    private int countLines;

    public LinesCounterThread(String Path) {
        this.Path = Path;
        this.countLines = 0;

    }
}
