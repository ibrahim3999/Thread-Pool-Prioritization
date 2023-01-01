package src;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex2_1 {
    public static String[] createTextFiles(int n, int seed, int bound)  {
        String[] FileNames= new String[n];
        for(int i=0;i<n;i++)
        {
                File file=new File("Files/file_"+ (i+1)+".txt");
            try {
                FileOutputStream outPutStream=new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return  FileNames;
    }


    public static void main(String[] args) {
        String[] FileNames=createTextFiles(3,0,0);


    }
}
