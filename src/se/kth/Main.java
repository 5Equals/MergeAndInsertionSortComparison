package se.kth;

/**
 * Compare the execution time for two sorting algorithms, merge sort and insertion sort. how they fair to
 * sort large arrays.
 */

public class Main {
    public static void main(String[] args) {
        // Preparations
        int arraySize = 200000;
        int maxIntegerSize = arraySize;
        int tests = 10;
        String file = "input100000.txt";

        Test.testRandomArrays(tests,maxIntegerSize,arraySize);
        // Test.testReadFromFile(arraySize, file);
        // Test.testBestCaseScenario(arraySize);
    }
}

class Test {
    private Test() {}

    static void testRandomArrays(int tests, int maxIntegerSize, int arraySize) {
        long startTime;
        long endTime;
        long executionTime;
        long average = 0;

        // Merge sort test
        for(int i = 0; i < tests; i++) {
            int[] testArray1 = Utilities.generateArray(maxIntegerSize, arraySize);
            startTime = System.nanoTime();
            MergeSort.sort(testArray1);
            endTime = System.nanoTime();
            // executionTime = endTime - startTime;
            executionTime = (endTime - startTime)  / 1000000;
            System.out.println("The time taken to finish (Merge sort): " + executionTime);
            average += executionTime;
        }
        average = average / tests;
        System.out.println("Average time taken (Merge sort): " + average);

        System.out.println("");

        average = 0;
        // Insertion sort test
        for(int i = 0; i < tests; i++) {
            int[] testArray2 = Utilities.generateArray(maxIntegerSize, arraySize);
            startTime = System.nanoTime();
            InsertionSort.sort(testArray2);
            endTime = System.nanoTime();
            // executionTime = endTime - startTime;
            executionTime = (endTime - startTime)  / 1000000;
            System.out.println("The time taken to finish (Insertion sort): " + executionTime);
            average += executionTime;
        }
        average = average / tests;
        System.out.println("Average time taken (Insertion sort): " + average);

    }

    static void testBestCaseScenario(int arraySize) {
        long startTime;
        long endTime;
        long executionTime;

        // Insertion sort
        int[] testArray = new int[arraySize];
        Utilities.generateSortedArray(testArray);
        startTime = System.nanoTime();
        InsertionSort.sort(testArray);
        endTime = System.nanoTime();
        executionTime = (endTime - startTime)  / 1000000;
        System.out.println("The time taken to finish (Insertion sort): " + executionTime);

        // Merge Sort
        testArray = new int[arraySize];
        Utilities.generateSortedArray(testArray);
        startTime = System.nanoTime();
        MergeSort.sort(testArray);
        endTime = System.nanoTime();
        executionTime = (endTime - startTime)  / 1000000;
        System.out.println("The time taken to finish (Merge sort): " + executionTime);
    }

    static void testReadFromFile(int arraySize, String file) {
        long startTime;
        long endTime;
        long executionTime;

        // Merge Sort
        int[] testArray = new int[arraySize];
        Utilities.readArray(testArray, file);
        startTime = System.nanoTime();
        MergeSort.sort(testArray);
        endTime = System.nanoTime();
        executionTime = (endTime - startTime)  / 1000000;
        System.out.println("The time taken to finish (Merge sort): " + executionTime);

        // Insertion sort
        testArray = new int[arraySize];
        Utilities.readArray(testArray, file);
        startTime = System.nanoTime();
        InsertionSort.sort(testArray);
        endTime = System.nanoTime();
        executionTime = (endTime - startTime)  / 1000000;
        System.out.println("The time taken to finish (Insertion sort): " + executionTime);
    }
}
