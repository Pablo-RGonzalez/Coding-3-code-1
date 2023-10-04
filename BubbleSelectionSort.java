package pack;

import java.util.Random;

public class BubbleSelectionSort {
    public static void main(String[] args) {
        int[] randomArray = RandomizedArray(100000, 1, 100000);

        int[] bubbleSortArray = randomArray.clone();
        long bubbleSortStartTime = System.currentTimeMillis();
        bubbleSort(bubbleSortArray);
        long bubbleSortEndTime = System.currentTimeMillis();
        long bubbleSortTimeElapsed = bubbleSortEndTime - bubbleSortStartTime;

        int[] selectionSortArray = randomArray.clone();
        long selectionSortStartTime = System.currentTimeMillis();
        selectionSort(selectionSortArray);
        long selectionSortEndTime = System.currentTimeMillis();
        long selectionSortTimeElapsed = selectionSortEndTime - selectionSortStartTime;

        System.out.println("Sorting a random array size of 100000 took Bubble Sort " + bubbleSortTimeElapsed + "ms to complete.");
        System.out.println("Sorting a random array size of 100000 took Selection Sort " + selectionSortTimeElapsed + "ms to complete.");
    }

    // Method to generate a random array
    public static int[] RandomizedArray(int size, int start, int end) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(end - start + 1) + start;
        }
        return arr;
    }

    // Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Selection Sort implementation
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
	//This code generates a random array of size 100,000, sorts it using both Bubble Sort and Selection Sort, and measures the time it takes for each sorting algorithm to complete. It then prints out the elapsed time in milliseconds for each algorithm.
