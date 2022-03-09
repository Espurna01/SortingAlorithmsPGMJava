package App;

import PGMManager.PGM;

import java.io.IOException;
import java.util.Arrays;

public class PGMTest {
    public static final String PRUEBA = ".\\prueba\\";
    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 7};
        PGM.savePGM(array, PRUEBA + "prueba" + values(array) + ".pgm");
        char a = (char)(array[0] + 96);
        System.out.println(a);
    }
    public static String values(int[] arr){
        StringBuilder sb = new StringBuilder(arr[0] + "");
        for(int i = 1; i < arr.length;i++){
            sb.append("-").append(arr[i]);
        }
        return sb.toString();
    }
}
