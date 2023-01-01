package src;


import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class LinesCounterThread extends Thread
{
    String file=null;
    public LinesCounterThread(String file)
    {
        this.file=file;
    }
    @Override
    public void run()
    {
        // count  lines for once file
    }
}
public class Ex2_1 {
    /**
     * @param fileNames paths for all files
     * @return number of lines for all files
     * @throws IOException
     * */
    public static int getNumOflines(String [] fileNames) {
        int lines = 0;
        for (int i = 0; i < fileNames.length; i++) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileNames[i]));
                while (reader.readLine() != null) {
                    lines++;
                }
                reader.close();
            } catch (IOException e) {
                System.out.println(" An error occurred while reading the file: " + e.getMessage());
            }

        }
        return lines;
    }
    /**
     * @param n number of files to create
     * @param seed -->Random(int seed)
     * @param bound --> rand .nextInt(bound)
     * @return The path of each file
     * @throws FileNotFoundException,IOException
     * */
    public static String[] createTextFiles(int n, int seed, int bound)  {
        Random rand=new Random(seed);
        String line="Hello World\n";
        byte[] lineBytes=line.getBytes();
        String[] FileNames= new String[n];
        for(int i=0;i<n;i++)
        {
                int lineCount=rand.nextInt(bound);
                File file=new File("Files/file_"+ (i+1)+".txt");
                FileNames[i]=file.getPath();
            try {
                FileOutputStream outPutStream=new FileOutputStream(file);
                for (int j = 0; j <lineCount ; j++) {
                    outPutStream.write(lineBytes);
                }

            }
            catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return  FileNames;
    }


    public static void main(String[] args) throws IOException {
        String[] FileNames=createTextFiles(3,1,10);
        /*
        Arrays.stream(FileNames).forEach(
                (file)->{
                    System.out.println(file);
                }
        );
        */
       // String[]check={"Files/file_1.txt","Files/file_2.txt","Files/file_3.txt"};
        System.out.println(getNumOflines(FileNames));



    }
}
