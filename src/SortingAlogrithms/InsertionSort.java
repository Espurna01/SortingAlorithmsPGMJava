package SortingAlogrithms;

import java.io.IOException;

public class InsertionSort extends Information{
    @Override
    public Information sort(int[] array) throws IOException {
        swaps = 0;  comparisons = 0;
        for(int i = 1; i  < array.length;i++){
            int x = array[i];
            int j = i - 1;
            for(;j >= 0 && array[j] > x;j--){
                array[j + 1] = array[j];
                swaps++;
                comparisons++;
            }
            array[j + 1] = x;
            swaps++;
        }
        return this;
    }
}
