package SortingAlogrithms;

import PGMManager.PGM;

import java.io.IOException;

import static App.source.BUBBLE_SORT;

public class BubbleSort extends Information{

    @Override
    public Information sort(int[] array) throws IOException {
        comparisons = 0;
        swaps = 0;

        boolean swapped;
        int sortedElements = 0;
        do {
            swapped = false;
            for(int i = 0;i < array.length - 1 - sortedElements;i++){
                //PGM.saveStatePGM(array, BUBBLE_SORT + "bubble" + swaps + "-" + comparisons + ".pgm", i);
                if(array[i] > array[i + 1]){
                    comparisons++;
                    PGM.saveStatePGM(array, BUBBLE_SORT + "bubble" + swaps + "-" + comparisons + ".pgm", i, i + 1);
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                    swaps++;
                    swapped = true;
                    comparisons--;
                }
                comparisons++;
                PGM.saveStatePGM(array, BUBBLE_SORT + "bubble" + swaps + "-" + comparisons + ".pgm", i, i + 1);
            }
            sortedElements++;
        } while (swapped);

        return this;
    }
}
