package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static src.Ex2_1.Ex2_1.countLines;

import org.junit.jupiter.api.Test;
import src.Ex2_1.Ex2_1;

public class Ex2_1Test {
    @Test
    public void testCountLines() {
        String[] filename = new String[]{"Test/FileTest/file_1.txt"};
        int expectedNumLines = 3;
        int actualNumLines = Ex2_1.countLines(filename[0]);
        assertEquals(expectedNumLines, actualNumLines);
    }
}