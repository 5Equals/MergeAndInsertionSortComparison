package se.kth;

/**
 * The insertion sort algorithm which will be used to sort the array.
 * Heavily inspired from the book "Algorithms 4th Edition" by Robert Sedgewick, Kevin Wayne.
 */
class InsertionSort {
    private InsertionSort() {}

    /**
     * Sort the array using the insertion sort method.
     * @param unsortedArray the array that wanted to be sorted.
     */
    static void sort(int[] unsortedArray) {
        int arrayLength = unsortedArray.length;
        for (int i = 1; i < arrayLength; i++) {
            for (int j = i; j > 0 && less(unsortedArray[j], unsortedArray[j-1]); j--) {
                exchange(unsortedArray, j, j - 1);
            }
            assert isSorted(unsortedArray, 0, i);
        }
        assert isSorted(unsortedArray);
    }

    /**
     * Check whether the first number is smaller than the second number.
     * @param num1 the first number.
     * @param num2 the second number.
     * @return ture or false depending on the condition.
     */
    private static boolean less(int num1, int num2) {
        return num1 < num2;
    }

    /**
     * Swap between two numbers that are in the array.
     * @param array in which the swap wanted to be.
     * @param i the position for the first number.
     * @param j the position for the second number.
     */
    private static void exchange(int[] array, int i, int j) {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

    /**
     * Checks if the array is sorted or not.
     * @param sortedArray the array which assumed to be sorted.
     * @return false of true depending on the condition.
     */
    private static boolean isSorted(int[] sortedArray) {
        return isSorted(sortedArray, 0, sortedArray.length);
    }

    /**
     *
     * @param sortedArray the assumed sorted array.
     * @param lo the smallest index in the array.
     * @param hi the highest index that the array offers.
     * @return if is it sorted or not.
     */
    private static boolean isSorted(int[] sortedArray, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(sortedArray[i], sortedArray[i-1])) return false;
        return true;
    }
}