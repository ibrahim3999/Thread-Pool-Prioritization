package src;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Ex2_1 {
    /**
     * @param file name
     * @return number of lines
     */
    public static int countLines(String filename) {

        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (reader.readLine() != null) {
                lines++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(" An error occurred while reading the file: " + e.getMessage());
        }
        return lines;
    }

    /**
     * @param fileNames paths for all files
     * @return number of lines for all files
     * @throws IOException
     */
    public static int getNumOflines(String[] fileNames) {
        int lines = 0;
        for (int i = 0; i < fileNames.length; i++) {
            lines += countLines(fileNames[i]);
        }
        return lines;
    }

    /**
     * @param n     number of files to create
     * @param seed  -->Random(int seed)
     * @param bound --> rand .nextInt(bound)
     * @return The path of each file
     * @throws FileNotFoundException,IOException
     */
    public static String[] createTextFiles(int n, int seed, int bound) {
        Random rand = new Random(seed);
        String line = "Hello World\n";
        byte[] lineBytes = line.getBytes();
        String[] FileNames = new String[n];
        for (int i = 0; i < n; i++) {
            int lineCount = rand.nextInt(bound);
            File file = new File("Files/file_" + (i + 1) + ".txt");
            FileNames[i] = file.getPath();
            try {
                FileOutputStream outPutStream = new FileOutputStream(file);
                for (int j = 0; j < lineCount; j++) {
                    outPutStream.write(lineBytes);
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return FileNames;
    }

    /**
     * @param fileNames paths for all files
     * @return Lines Counter
     * implement threadPool Design pattern
     */
    public static int getNumOfLinesThreadPool(String[] fileNames) {

        ExecutorService executor = Executors.newFixedThreadPool(fileNames.length);
        ArrayList<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < fileNames.length; i++) {
            LinesCounterTask task = new LinesCounterTask(fileNames[i]);
            try {
                Future<Integer> result = executor.submit(task);
                results.add(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int totalLines = 0;
        for (Future<Integer> result : results) {
            try {
                totalLines += result.get();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        executor.shutdown();
        return totalLines;
    }

    /**
     * @param fileNames Method count lines  file(Threads)
     */
    public static int getNumOfLinesThreads(String[] fileNames) {
        int counter = 0;
        for (int i = 0; i < fileNames.length; i++) {
            LinesCounterThread l = new LinesCounterThread(fileNames[i]);
            l.start();
            try {
                l.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter += l.countLines;
        }

        return counter;
    }

    /**
     * LinesCounter implemnts Callable return Integer (count lines)
     */
    public static class LinesCounterTask implements Callable<Integer> {
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
    /**
     * LinesCounterThread -->is Thread
     */
    public static class LinesCounterThread extends Thread {

        private final String Path;
        private int countLines;

        public LinesCounterThread(String Path) {
            this.Path = Path;
            this.countLines = 0;

        }

        @Override
        /**
         * count lines for this.path file
         * */
        public void run() {
            // count  lines for once file
            this.countLines = countLines(this.Path);
        }

        public int getCountLines() {
            return countLines;
        }

    }

    /**
     * @param check paths files
     *              runtime for third Methods
     */
    public static void PrintTimerTest(String[] check) {
        System.out.println("----------------------------------------------------");
        System.out.println(" Normal -->getNumOflines(...) ");
        Timer timer = new Timer();
        timer.start();
        System.out.println("Lines: " + getNumOflines(check));
        timer.stop();
        timer.PrintElapsedTimeInseconds();

        timer.reset();
        System.out.println("----------------------------------------------------");
        System.out.println(" Threads --> getNumOfLinesThreads(...)");
        timer.start();
        System.out.println("Lines:" + getNumOfLinesThreads(check));
        timer.stop();
        timer.PrintElapsedTimeInseconds();
        timer.reset();

        System.out.println("----------------------------------------------------");
        System.out.println(" Threadpool --> getNumOfLinesThreadPool ");
        timer.start();
        System.out.println("Lines: " + getNumOfLinesThreadPool(check));
        timer.stop();
        timer.PrintElapsedTimeInseconds();
        timer.reset();
        System.out.println("--------------------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        String[] check = createTextFiles(3000, 2, 100);
        /*
        Arrays.stream(FileNames).forEach(
                (file)->{
                    System.out.println(file);
                }
        );


        //  System.out.println(getNumOflines(FileNames));

            LinesCounterThread t2 = new LinesCounterThread(check[1]);
            LinesCounterThread t3 = new LinesCounterThread(check[2]);
            t1.start();
            t2.start();
            t3.start(); */
        //  String[]check={"Files/file_1.txt","Files/file_2.txt","Files/file_3.txt","Files/file_3.txt"};
        //System.out.println(getNumOfLinesThreads(check));
        PrintTimerTest(check);

    }

}
