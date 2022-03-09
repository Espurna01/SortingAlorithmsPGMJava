package SortingAlogrithms;

import App.source;
import PGMManager.PGM;

import java.io.IOException;

import static App.source.MERGE_SORT;

public class MergeSort extends Information {

    @Override
    public Information sort(int[] array) throws IOException {
        swaps = 0;
        comparisons = 0;
        mergeSort(array, 0, array.length - 1);
        PGM.savePGM(array,  MERGE_SORT + "merge" + swaps + "-" + comparisons + ".pgm");
        return this;
    }

    private void mergeSort(int[] array, int start, int end) throws IOException{
        if(end > start){
            int mid = (start + end)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private void merge(int[] array, int start, int mid, int end) throws IOException {
        int[] brr = new int[array.length];
        for(int i = start;i <= end; i++){
            brr[i] = array[i];
        }
        int indexL = start;
        int indexR = mid + 1;
        int indexArr = start;
        while(indexL <= mid && indexR <= end){
            if (brr[indexL] < brr[indexR]) {
                array[indexArr] = brr[indexL];
                indexL++;
            } else {
                array[indexArr] = brr[indexR];
                indexR++;
            }
            indexArr++;
            comparisons++;
            swaps++;
            PGM.saveStatePGM(array, MERGE_SORT + "merge" + swaps + "-" + comparisons + ".pgm", indexL, indexR);

        }
        while(indexL <= mid){
            array[indexArr] = brr[indexL];
            swaps++;
            PGM.saveStatePGM(array, MERGE_SORT + "merge" + swaps + "-" + comparisons + ".pgm", indexL, indexR);
            indexArr++;
            indexL++;
        }

    }
}
