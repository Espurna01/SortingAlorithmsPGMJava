package SortingAlogrithms;

import App.source;
import PGMManager.PGM;

import java.io.IOException;
import java.sql.Array;

import static App.source.STALIN_SORT;

public class StalinSort extends Information {
    @Override
    public Information sort(int[] array) throws IOException {
        swaps = 0;
        comparisons = 0;
        for(int i = 0; i < array.length - 1;i++){
            if(array[i + 1] < array[i]){
                PGM.saveStatePGM(array, STALIN_SORT + "stalin" + swaps + "-" + comparisons + ".pgm", i, i+1);
                comparisons++;
                int[] brr = array;
                int x = array[i + 1];
                array = new int[array.length - 1];
                for(int j = 0, k = 0; j < brr.length;j++){
                    if(brr[j] != x){
                        array[k] = brr[j];
                        k++;
                    }
                }
                PGM.savePGM(array, STALIN_SORT + "stalin" + swaps + "-" + comparisons + ".pgm");
                i--;
            }
        }
        PGM.savePGM(array, STALIN_SORT + "stalinEND.pgm");
        System.out.println("Stalin sort finished... Total comparisons: " + getComparisons() + ", total swaps: " + getSwaps());
        System.out.println("Sorted array: " + source.printArray(array));
        return this;
    }
}
