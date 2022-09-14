package se.kth;

/**
 * Merge sort algorithm that will be to sort the array.
 * Heavily inspired from the book "Algorithms 4th Edition" by Robert Sedgewick, Kevin Wayne.
 */
class MergeSort {
    private MergeSort() {}

    /**
     * Will merge two parts of an array that was divided into sections.
     * @param unsortedArray the unsorted array that will sorted using the merge algorithm.
     * @param copyArray array to copy the content of the original array.
     * @param lo the lowest index for the array that wanted to be sorted.
     * @param mid middle index for the array.
     * @param hi the biggest index that the array size provides.
     */

    private static void merge(int[] unsortedArray, int[] copyArray, int lo, int mid, int hi) {
        assert isSorted(unsortedArray, lo, mid);
        assert isSorted(unsortedArray, mid+1, hi);

        // Copy the array content.
        for (int k = lo; k <= hi; k++) {
            copyArray[k] = unsortedArray[k];
        }
        // Merge back to original array.
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if(i > mid) {
                unsortedArray[k] = copyArray[j++];
            } else if (j > hi) {
                unsortedArray[k] = copyArray[i++];
            } else if (less(copyArray[j], copyArray[i])) {
                unsortedArray[k] = copyArray[j++];
            } else {
                unsortedArray[k] = copyArray[i++];
            }
        }
        assert isSorted(unsortedArray, lo, hi);
    }

    /**
     * Will call the sort method and giving the right inputs to it.
     * @param unsortedArray the array that wanted to be sorted.
     */

    public static void sort(int[] unsortedArray) {
        int[] copyArray = new int[unsortedArray.length];
        sort(unsortedArray, copyArray, 0, unsortedArray.length-1);
        assert isSorted(unsortedArray);
    }


    /**
     * Will manage the divisions of the sub arrays and merge them together under the right condition.
     * when they are sorted.
     * @param unsortedArray the unsorted array that will be sorted.
     * @param copyArray an array to copy the content of the original array.
     * @param lo the lowest index that the array has.
     * @param hi the highest index that the array provides.
     */

    private static void sort(int[] unsortedArray, int[] copyArray, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(unsortedArray, copyArray, lo, mid);
        sort(unsortedArray, copyArray, mid + 1, hi);
        merge(unsortedArray, copyArray, lo, mid, hi);
    }


    /**
     * Check whether the first number is smaller that the second number.
     * @param num1 the first number.
     * @param num2 the second number.
     * @return true of false depending on the condition.
     */

    private static boolean less(int num1, int num2) {
        return num1 < num2;
    }


    /**
     * Checks if the array is sorted or not.
     * @param sortedArray the array which assumed to be sorted.
     * @return false of true depending on the condition.
     */

    private static boolean isSorted(int[] sortedArray) {
        return isSorted(sortedArray, 0, sortedArray.length - 1);
    }


    /**
     *
     * @param sortedArray the assumed sorted array.
     * @param lo the smallest index in the array.
     * @param hi the highest index that the array offers.
     * @return if is it sorted or not.
     */

    private static boolean isSorted(int[] sortedArray, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(sortedArray[i], sortedArray[i-1])) return false;
        return true;
    }
}