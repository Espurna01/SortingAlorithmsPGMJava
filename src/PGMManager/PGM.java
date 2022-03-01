package PGMManager;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

public class PGM implements FilenameFilter {

    private static final String extension = ".pgm";

    public static void savePGM(int[] array, String name) throws IOException {
        FileWriter fw = new FileWriter(name, false);
        fw.write("P2\n" + array.length + " " + array.length + "\n" + (array.length+1) + "\n");
        for (int i = 0, j = 0; i < array.length;i++){
            if(j == array.length) j = 0;
            fw.write((i >= array.length - array[j]?j+2:0) + "");
            for(j = 1; j < array.length;j++){
                fw.write("\t" + (i >= array.length - array[j]?j+2:0));
            }
            fw.write("\n");
        }
        fw.close();
    }

    public static void saveStatePGM(int[] array, String name, int comparee, int comparent) throws IOException {
        FileWriter fw = new FileWriter(name, false);
        fw.write("P2\n" + array.length + " " + array.length + "\n" + (array.length + 1) + "\n");
        for (int i = 0, j = 0; i < array.length;i++){
            if(j == array.length) j = 0;
            if(j == comparee || j == comparent){
                fw.write((i >= array.length - array[j]?1:0) + "");
            } else {
                fw.write((i >= array.length - array[j]?j+2:0) + "");
            }
            for(j = 1; j < array.length;j++){
                if(j == comparee || j == comparent){
                    fw.write("\t" + (i >= array.length - array[j]?1:0) + "");
                } else {
                    fw.write("\t" + (i >= array.length - array[j]?j+2:0) + "");
                }
            }
            fw.write("\n");
        }
        fw.close();
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
