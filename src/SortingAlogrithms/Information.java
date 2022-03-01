package SortingAlogrithms;

import java.io.IOException;

public abstract class Information {
    protected int swaps = 0;
    protected int comparisons = 0;

    public int getSwaps() {
        return swaps;
    }

    public int getComparisons() {
        return comparisons;
    }

    public abstract Information sort(int[] array) throws IOException;
}
