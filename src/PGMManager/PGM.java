package PGMManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PGM implements FilenameFilter {

    private static final String extension = ".pgm";

    public static void savePGMv0(int[] array, String name) throws IOException {
        FileWriter fw = new FileWriter(name, false);
        int max = max(array);
        fw.write("P2 " + array.length + " " + max + " " + (array.length+1) + "\n");
        for (int i = 0, j = 0; i < max;i++){
            fw.write((i >= max - array[j]?j+2:0) + "");
            for(j = 1; j < array.length;j++){
                fw.write("\t" + (i >= max - array[j]?j+2:0));
            }
            j = 0;
            fw.write("\n");
        }
        fw.close();
    }

    public static void savePGM(int[] array, String name) throws IOException {
        FileWriter fw = new FileWriter(name, false);
        int max = max(array);
        fw.write("P5 " + array.length + " " + max + " " + (array.length + 1) + "\n");
        fw.close();
        FileOutputStream fos = new FileOutputStream(name, true);

        for (int i = 0; i < max;i++){
            for(int j = 0; j < array.length;j++){
                char a;
                if (i >= max - array[j]) {
                    a = (char)(j + 2);
                } else {
                    a = 0;
                }
                fos.write(a);
            }
        }
        fos.close();
    }

    public static void saveStatePGM(int[] array, String name, int comparee, int comparent) throws IOException {
        FileWriter fw = new FileWriter(name, false);
        int max = max(array);
        fw.write("P5 " + array.length + " " + max + " " + (array.length + 1) + "\n");
        fw.close();
        FileOutputStream fos = new FileOutputStream(name, true);
        for (int i = 0; i < max;i++){
            for(int j = 0; j < array.length;j++){
                char a;
                if(j == comparee || j == comparent){
                    if(i >= max - array[j]){
                        a = (char)(array.length + 1);
                    } else{
                        a = 0;
                    }
                } else{
                    if(i >= max - array[j]){
                        a = (char)(j+1);
                    } else{
                        a = 0;
                    }
                }
                fos.write(a);
            }
        }
        fos.close();
    }

    private static int max(int[] array) {
        int max = array[0];
        for (int i = 1;i < array.length;i++){
            if(max < array[i]) max = array[i];
        }
        return max;
    }


    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(extension);
    }

    public boolean resetDirectory(String path){
        File dir = new File(path);
        String[] fileNames = dir.list(this);
        if(fileNames != null){
            File toDelete;
            boolean a = true;
            for(String f : fileNames){
                toDelete = new File(path + f);
                if(!toDelete.delete()) a = false;
            }
            return a;
        }else{
            return false;
        }
    }
}
