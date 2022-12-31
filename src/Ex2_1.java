package src;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Ex2_1 {
    public static String[] createTextFiles(int n, int seed, int bound){
        String[] FileNames= new String[n];
        for(int i=0;i<n;i++)
        {
            File file=new File("Files/Text_"+i+".txt");
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            FileNames[i]=file.getPath();
        }
        return  FileNames;
    }

    public static void main(String[] args) {
        String[] FileNames=createTextFiles(3,0,0);
    }
}
