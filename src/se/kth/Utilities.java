package se.kth;

import java.io.*;
import java.util.Random;

/**
 * Utilities that are used and necessary to the project.
 */
class Utilities {
    private Utilities() {}

    /**
     * Generate an array with random integer numbers.
     * @param maxIntegerSize the biggest possible integer that can be generated.
     * @param arraySize how many inputs wanted in the array.
     * @return the random generated array.
     */
    static int[] generateArray(int maxIntegerSize, int arraySize) {
        int[] generateArray = new int[arraySize];
        Random random = new Random();
        for(int i = 0; i < arraySize; i++) {
            generateArray[i] = random.nextInt(maxIntegerSize + 1);
        }
        return generateArray;
    }

    static void generateSortedArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    /**
     * Print the content of an array. the style is {x, x, x, ...}
     * @param array which will be printed.
     */

    static void printArray(int[] array) {
        String arrString = "{";
        for(int i = 0; i < array.length; i++) {
            arrString += array[i];
            if(i != array.length -1) {
                arrString += ", ";
            }
            if(i % 10 == 0 && i != 0) {
                arrString += "\n";
            }
        }
        arrString += "}";
        System.out.println(arrString);
    }

    /**
     * Read the inputs from a text file and save them into an array.
     * @param array the array that will hole the information from the file.
     * @param file the name of the file.
     */
    static void readArray(int[] array, String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                for(String num : line.split(",")) {
                    array[i] = Integer.parseInt(num);
                    i++;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
