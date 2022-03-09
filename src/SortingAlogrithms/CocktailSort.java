package SortingAlogrithms;

import PGMManager.PGM;

import java.io.IOException;

import static App.source.BUBBLE_SORT;
import static App.source.COCKTAILSHAKER_SORT;

public class CocktailSort extends Information{

    @Override
    public Information sort(int[] array) throws IOException {
        swaps = 0;  comparisons = 0;
        boolean swap;
        int index = 0;
        int sortedElements = 0;
        do{
            swap = false;
            while(index < array.length - 1 - sortedElements/2) {
                if(array[index] > array[index + 1]){
                    PGM.saveStatePGM(array, COCKTAILSHAKER_SORT + "cocktail" + swaps + "-" + (comparisons + 1) + ".pgm", index, index + 1);
                    int tmp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = tmp;
                    swaps++;
                    swap = true;
                }
                comparisons++;
                PGM.saveStatePGM(array, COCKTAILSHAKER_SORT + "cocktail" + swaps + "-" + comparisons + ".pgm", index, index + 1);
                index++;
            }
            sortedElements++;
            if(swap){
                index--;
                swap = false;
                while (index > sortedElements/2){
                    if(array[index] < array[index - 1]){
                        PGM.saveStatePGM(array, COCKTAILSHAKER_SORT + "cocktail" + swaps + "-" + (comparisons + 1) + ".pgm", index, index - 1);
                        int tmp = array[index];
                        array[index] = array[index - 1];
                        array[index - 1] = tmp;
                        swaps++;
                        swap = true;
                    }
                    comparisons++;
                    PGM.saveStatePGM(array, COCKTAILSHAKER_SORT + "cocktail" + swaps + "-" + comparisons + ".pgm", index, index - 1);
                    index--;
                }
                sortedElements++;
                index++;
            }
        }while (swap);
        return this;
    }
}
