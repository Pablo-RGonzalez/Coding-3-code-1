package pack;
import java.util.Random;

public class SortingBenchmark {

	public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
	// Implementation of Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Implementation of Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000); // Adjust the range as needed
        }
        return arr;
    }

    public static void main(String[] args) {
        int listSize = 1000; // Adjust the size of the array as needed
        int[] randomArray = generateRandomArray(listSize);

        int[] bubbleSortArray = randomArray.clone();
        long startTime = System.nanoTime();
        bubbleSort(bubbleSortArray);
        long endTime = System.nanoTime();
        long bubbleSortTime = endTime - startTime;

        int[] selectionSortArray = randomArray.clone();
        startTime = System.nanoTime();
        selectionSort(selectionSortArray);
        endTime = System.nanoTime();
        long selectionSortTime = endTime - startTime;

        int[] insertionSortArray = randomArray.clone();
        startTime = System.nanoTime();
        insertionSort(insertionSortArray);
        endTime = System.nanoTime();
        long insertionSortTime = endTime - startTime;

        System.out.println("Bubble Sort Time: " + bubbleSortTime + " ns");
        System.out.println("Selection Sort Time: " + selectionSortTime + " ns");
        System.out.println("Insertion Sort Time: " + insertionSortTime + " ns");
    }

}
