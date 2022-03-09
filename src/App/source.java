package App;

import PGMManager.PGM;
import SortingAlogrithms.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class source {
    public static final int ARRAY_LENGTH = 150;  // MAX: 254
    public static final String BUBBLE_SORT = ".\\bubbleSort\\";
    public static final String QUICK_SORT = ".\\quickSort\\";   // TODO
    public static final String SELECTION_SORT = ".\\selectionSort\\";
    public static final String MERGE_SORT = ".\\mergeSort\\";
    public static final String COCKTAILSHAKER_SORT = ".\\cocktailShakerSort\\";
    public static final String INSERTION_SORT = ".\\insertionSort\\";
    public static final String STALIN_SORT = ".\\stalinSort\\";

    public static void main(String[] args) throws IOException {
        int[] arrayToSort = new int[ARRAY_LENGTH];
        int[] randomArray = new int[ARRAY_LENGTH];
        PGM pgm = new PGM();
        Information info;
        BubbleSort bs = new BubbleSort();
        SelectionSort ss = new SelectionSort();
        InsertionSort is = new InsertionSort();
        CocktailSort cs = new CocktailSort();
        MergeSort ms = new MergeSort();
        StalinSort stalinSort = new StalinSort();
        FileWriter fw;

        initializeArray(arrayToSort);
        randomizeArray(arrayToSort);
        copyArray(arrayToSort, randomArray);
        if(ARRAY_LENGTH <= 50) {
            if (pgm.resetDirectory(BUBBLE_SORT)) {
                System.out.println(BUBBLE_SORT + " directory reseted");
            }
            System.out.println("Starting array: " + printArray(arrayToSort));
            System.out.println("Applying bubble sort...");

            PGM.savePGM(arrayToSort, BUBBLE_SORT + "bubble0.pgm");
            info = bs.sort(arrayToSort);
            fw = new FileWriter(BUBBLE_SORT + "Information.txt", false);
            fw.write("Bubble sorting algorithm.\n\tStarting array: " + printArray(randomArray) + "\n\tSorted array: " + printArray(arrayToSort) + "\n\tTotal comparisons: " + info.getComparisons() + "\n\tTotal swaps: " + info.getSwaps());
            fw.close();
            System.out.println("Bubble sort finished... Total comparisons: " + info.getComparisons() + ", total swaps: " + info.getSwaps());
            PGM.savePGM(arrayToSort, BUBBLE_SORT + "bubbleEND.pgm");

            start(arrayToSort, randomArray, pgm, SELECTION_SORT);
            System.out.println("Applying selection sort...");

            PGM.savePGM(arrayToSort, SELECTION_SORT + "selection0.pgm");
            info = ss.sort(arrayToSort);
            fw = new FileWriter(SELECTION_SORT + "Information.txt", false);
            fw.write("Selection sorting algorithm.\n\tStarting array: " + printArray(randomArray) + "\n\tSorted array: " + printArray(arrayToSort) + "\n\tTotal comparisons: " + info.getComparisons() + "\n\tTotal swaps: " + info.getSwaps());
            fw.close();
            System.out.println("Selection sort finished... Total comparisons: " + info.getComparisons() + ", total swaps: " + info.getSwaps());
            PGM.savePGM(arrayToSort, SELECTION_SORT + "selectionEND.pgm");

            start(arrayToSort, randomArray, pgm, INSERTION_SORT);
            System.out.println("Applying insertion sort...");

            PGM.savePGM(arrayToSort, INSERTION_SORT + "insertion0.pgm");
            info = is.sort(arrayToSort);
            fw = new FileWriter(INSERTION_SORT + "Information.txt", false);
            fw.write("Insertion sorting algorithm.\n\tStarting array: " + printArray(randomArray) + "\n\tSorted array: " + printArray(arrayToSort) + "\n\tTotal comparisons: " + info.getComparisons() + "\n\tTotal swaps: " + info.getSwaps());
            fw.close();
            System.out.println("Insertion sort finished... Total comparisons: " + info.getComparisons() + ", total swaps: " + info.getSwaps());
            PGM.savePGM(arrayToSort, INSERTION_SORT + "insertionEND.pgm");

            start(arrayToSort, randomArray, pgm, COCKTAILSHAKER_SORT);
            System.out.println("Applying cocktail-shaker sort...");

            PGM.savePGM(arrayToSort, COCKTAILSHAKER_SORT + "cocktail0.pgm");
            info = cs.sort(arrayToSort);
            fw = new FileWriter(COCKTAILSHAKER_SORT + "Information.txt", false);
            fw.write("Cocktail-shaker sorting algorithm.\n\tStarting array: " + printArray(randomArray) + "\n\tSorted array: " + printArray(arrayToSort) + "\n\tTotal comparisons: " + info.getComparisons() + "\n\tTotal swaps: " + info.getSwaps());
            fw.close();

            System.out.println("Cocktail-shaker sort finished... Total comparisons: " + info.getComparisons() + ", total swaps: " + info.getSwaps());
            PGM.savePGM(arrayToSort, COCKTAILSHAKER_SORT + "cocktailEND.pgm");


        }
        start(arrayToSort, randomArray, pgm, MERGE_SORT);
        System.out.println("Applying merge sort...");

        PGM.savePGM(arrayToSort, MERGE_SORT + "merge0.pgm");
        info = ms.sort(arrayToSort);
        fw = new FileWriter(MERGE_SORT + "Information.txt", false);
        fw.write("Merge sorting algorithm.\n\tStarting array: "+ printArray(randomArray) + "\n\tSorted array: " + printArray(arrayToSort) + "\n\tTotal comparisons: " + info.getComparisons() + "\n\tTotal swaps: " + info.getSwaps());
        fw.close();

        System.out.println("Merge sort finished... Total comparisons: " + info.getComparisons() + ", total swaps: " + info.getSwaps());
        PGM.savePGM(arrayToSort, MERGE_SORT + "mergeEND.pgm");

        start(arrayToSort, randomArray, pgm, STALIN_SORT);

        PGM.savePGM(arrayToSort, STALIN_SORT + "stalin0.pgm");
        info = stalinSort.sort(arrayToSort);
        fw = new FileWriter(STALIN_SORT + "Information.txt", false);
        fw.write("Stalin sorting algorithm.\n\tTotal comparisons: " + info.getComparisons() + "\n\tTotal swaps: " + info.getSwaps());
        fw.close();

    }

    private static void start(int[] arrayToSort, int[] randomArray, PGM pgm, String dir) {
        System.out.println("Sorted array: " + printArray(arrayToSort));

        System.out.println();
        copyArray(randomArray, arrayToSort);
        if(pgm.resetDirectory(dir)){
            System.out.println(dir + " directory reseted");
        }
        System.out.println("Starting array: " + printArray(arrayToSort));
    }

    public static void initializeArray(int[] array){
        for(int i = 0; i < array.length;i++){
            array[i] = i + 1;
        }
    }

    public static void copyArray(int[] a1, int[] a2){
        assert a1.length == a2.length : "Error";
        System.arraycopy(a1, 0, a2, 0, a1.length);
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
        StringBuilder sb = new StringBuilder("{" + arr[0]);
        for (int a : arr) {
            if(a != arr[0]){
                sb.append(", ").append(a);
            }
        }
        sb.append("}");
        return sb.toString();
    }

}
