package src.Ex2_1;

import java.util.concurrent.Callable;

import static src.Ex2_1.Ex2_1.countLines;

/**
 * LinesCounter implemnts Callable return Integer (count lines)
 */
public class LinesCounterTask implements Callable<Integer> {
    private final String Path;

    public LinesCounterTask(String Path) {
        this.Path = Path;
    }

    @Override
    public Integer call() {
        int count = 0;
        count = countLines(this.Path);
        return count;
    }
}