package SortingAlogrithms;

import PGMManager.PGM;

import java.io.IOException;

import static App.source.SELECTION_SORT;

public class SelectionSort extends Information {

    @Override
    public Information sort(int[] array) throws IOException {
        swaps = 0;
        comparisons = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int mini = i;
            int j = i + 1;
            for (; j < array.length; j++) {
                comparisons++;
                PGM.saveStatePGM(array, SELECTION_SORT + "selection" + swaps + "-" + comparisons + ".pgm", mini, j);
                if(array[j] < array[mini]){
                    mini = j;
                }
            }
            if(i != mini){
                int tmp = array[mini];
                array[mini] = array[i];
                array[i] = tmp;
                swaps++;
                PGM.saveStatePGM(array, SELECTION_SORT + "selection" + swaps + "-" + comparisons + ".pgm", mini, j);
            }
        }
        return this;
    }
}
