package src;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Ex2_1 {
    /**
     * @param file name
     * @return number of lines
     *
     * */
    public static int countLines(String filename)  {
        int lines=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (reader.readLine() != null) {
                lines++;
            }
            reader.close();
        }

            catch(IOException e){
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
                    lines+=countLines(fileNames[i]);
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

    public static class LinesCounterThread extends Thread {
        private String Path = null;
        private int countLines;

        public LinesCounterThread(String Path) {
            this.Path = Path;
            this.countLines = 0;
        }
        @Override
        public void run() {
            // count  lines for once file
                this.countLines=countLines(this.Path);
        }

        public int getCountLines() {
            return countLines;
        }

    }

    public static void main(String[] args) throws Exception {
        //String[] FileNames = createTextFiles(3, 1, 10);
        /*
        Arrays.stream(FileNames).forEach(
                (file)->{
                    System.out.println(file);
                }
        );
        */
         String[]check={"Files/file_1.txt","Files/file_2.txt","Files/file_3.txt"};
        //  System.out.println(getNumOflines(FileNames));
            LinesCounterThread t1 = new LinesCounterThread(check[0]);
            LinesCounterThread t2 = new LinesCounterThread(check[1]);
            LinesCounterThread t3 = new LinesCounterThread(check[2]);
            t1.start();
            t2.start();
            t3.start();
        System.out.println(t1.getState());
        }

    }
