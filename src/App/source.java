package App;

import PGMManager.PGM;
import SortingAlogrithms.BubbleSort;
import SortingAlogrithms.Information;
import SortingAlogrithms.InsertionSort;
import SortingAlogrithms.SelectionSort;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class source {
    public static final int ARRAY_LENGTH = 20;
    public static final String BUBBLE_SORT = ".\\bubbleSort\\";
    public static final String QUICK_SORT = ".\\quickSort\\";
    public static final String SELECTION_SORT = ".\\selectionSort\\";
    public static final String MERGE_SORT = ".\\mergeSort\\";
    public static final String COCKTAILSHAKER_SORT = ".\\cocktailShakerSort\\";
    public static final String INSERTION_SORT = ".\\insertionSort\\";
    public static final String STALIN_SORT = ".\\stalinSort\\";

    public static void main(String[] args) throws IOException {
        int[] array = new int[ARRAY_LENGTH];
        PGM pgm = new PGM();
        Information info;
        BubbleSort bs = new BubbleSort();
        SelectionSort ss = new SelectionSort();
        InsertionSort is = new InsertionSort();
        FileWriter fw;
/*

        initializeArray(array);
        randomizeArray(array);
        if(pgm.resetDirectory(BUBBLE_SORT)){
            System.out.println("Directory reseted");
        }


        System.out.println("Starting array: " + printArray(array));
        System.out.println("Applying bubble sort...");

        PGM.savePGM(array, BUBBLE_SORT + "bubble0.pgm");
        info = bs.sort(array);
        fw = new FileWriter(BUBBLE_SORT + "Information.txt", false);
        fw.write("Bubble sorting algorithm.\n\tTotal comparisons: " + info.getComparisons() + "\n\tTotal swaps: " + info.getSwaps());
        fw.close();

        System.out.println("Bubble sort finished... Total comparisons: " + info.getComparisons() + ", total swaps: " + info.getSwaps());
        System.out.println("Sorted array: " + printArray(array));

        initializeArray(array);
        randomizeArray(array);
        if(pgm.resetDirectory(SELECTION_SORT)){
            System.out.println("Directory reseted");
        }
        System.out.println("Starting array: " + printArray(array));
        System.out.println("Applying selection sort...");

        PGM.savePGM(array, SELECTION_SORT + "selection0.pgm");
        info = ss.sort(array);
        fw = new FileWriter(SELECTION_SORT + "Information.txt", false);
        fw.write("Selection sorting algorithm.\n\tTotal comparisons: " + info.getComparisons() + "\n\tTotal swaps: " + info.getSwaps());
        fw.close();

        System.out.println("Selection sort finished... Total comparisons: " + info.getComparisons() + ", total swaps: " + info.getSwaps());
        System.out.println("Sorted array: " + printArray(array));
*/
        initializeArray(array);
        randomizeArray(array);
        if(pgm.resetDirectory(INSERTION_SORT)){
            System.out.println("Directory reseted");
        }
        System.out.println("Starting array: " + printArray(array));
        System.out.println("Applying insertion sort...");

        PGM.savePGM(array, INSERTION_SORT + "insertion0.pgm");
        info = is.sort(array);
        fw = new FileWriter(INSERTION_SORT + "Information.txt", false);
        fw.write("Insertion sorting algorithm.\n\tTotal comparisons: " + info.getComparisons() + "\n\tTotal swaps: " + info.getSwaps());
        fw.close();

        System.out.println("Selection sort finished... Total comparisons: " + info.getComparisons() + ", total swaps: " + info.getSwaps());
        System.out.println("Sorted array: " + printArray(array));

    }

    public static void initializeArray(int[] array){
        for(int i = 0; i < array.length;i++){
            array[i] = i + 1;
        }
    }

    public static void randomizeArray(int[] array){
        Random rand = new Random();
        for(int i = 0; i < array.length*2;i++){
            int a = rand.nextInt(array.length);
            int b = rand.nextInt(array.length);
            while(a == b){
                b = rand.nextInt(array.length);
            }
            int tmp = array[b];
            array[b] = array[a];
            array[a] = tmp;
        }

    }

    public static String printArray(int[] arr) {
        String m = "{" + arr[0];
        for (int a : arr) {
            if(a != arr[0]){
                m += ", " + a;
            }
        }
        return m + "}";
    }

}
