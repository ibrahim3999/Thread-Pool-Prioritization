package src;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Ex2_1 {
    public static String[] createTextFiles(int n, int seed, int bound)  {
        Random rand=new Random(seed);
        String line="Hello World \n";
        byte[] lineBytes=line.getBytes();
        String[] FileNames= new String[n];
        for(int i=0;i<n;i++)
        {
                int lineCount=rand.nextInt(bound);
                File file=new File("Files/file_"+ (i+1)+".txt");
            try {
                FileOutputStream outPutStream=new FileOutputStream(file);
                for (int j = 0; j <lineCount ; j++) {
                    outPutStream.write(lineBytes);
                    outPutStream.write(32);
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


    public static void main(String[] args) {
        String[] FileNames=createTextFiles(3,1,10);


    }
}
