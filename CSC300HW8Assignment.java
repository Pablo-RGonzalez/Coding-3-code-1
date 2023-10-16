package pack;

import java.util.Random;

public class CSC300HW8Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = RandomArrayGenerator(10000);
        long a = System.currentTimeMillis();
        Shellsort(arr);
        System.out.println(System.currentTimeMillis() - a);
        
        int[] randomArray = RandomizedArray(100000, 1, 100000);

        //BubbleSort
        int[] bubbleSortArray = randomArray.clone();
        long bubbleSortStartTime = System.currentTimeMillis();
        bubbleSort(bubbleSortArray);
        long bubbleSortEndTime = System.currentTimeMillis();
        long bubbleSortTimeElapsed = bubbleSortEndTime - bubbleSortStartTime;

        //Selection Sort
        int[] selectionSortArray = randomArray.clone();
        long selectionSortStartTime = System.currentTimeMillis();
        selectionSort(selectionSortArray);
        long selectionSortEndTime = System.currentTimeMillis();
        long selectionSortTimeElapsed = selectionSortEndTime - selectionSortStartTime;

        //ShellSort
        Shellsort(arr);
        long shellSortStartTime = System.currentTimeMillis();
        Shellsort(arr);
        long shellSortEndTime = System.currentTimeMillis();
        long shellSortTimeElapsed = shellSortEndTime - shellSortStartTime;
        
        //Quick Sort
        int[] quickSortArray = arr.clone();
        long quickSortStartTime = System.currentTimeMillis();
        QuickSort(quickSortArray, 0, quickSortArray.length - 1);
        long quickSortEndTime = System.currentTimeMillis();
        long quickSortTimeElapsed = quickSortEndTime - quickSortStartTime;
        
        //InsertionSort
        long insertionSortTime = runInsertionSortBenchmark(arr);
        
        System.out.println("Insertion Sort on a random array size of 10,000 took " + insertionSortTime + "ms to complete.");
        
        System.out.println("Quick Sort on a random array size of 10,000 took " + quickSortTimeElapsed + "ms to complete.");
        System.out.println("Shell Sort on a random array size of 10,000 took " + shellSortTimeElapsed + "ms to complete.");

        System.out.println("Sorting a random array size of 10,000 took Bubble Sort " + bubbleSortTimeElapsed + "ms to complete.");
        System.out.println("Sorting a random array size of 10,000 took Selection Sort " + selectionSortTimeElapsed + "ms to complete.");
	}
	
	public static int Partition(int[] arr, int low, int high){
		int pivot = arr[low];
	    int i = low - 1;
	    int j = high + 1;

	    while (true) {
	        do {
	            i++;
	        } while (arr[i] < pivot);

	        do {
	            j--;
	        } while (arr[j] > pivot);

	        if (i >= j) {
	            return j;
	        }

	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	}
	//QuickSort implementation
	public static void QuickSort(int[] arr, int low, int high) {
		if (low < high) {
	        int pivot = Partition(arr, low, high);
	        QuickSort(arr, low, pivot);
	        QuickSort(arr, pivot + 1, high);
	    }
		}
	
	public static int[] RandomArrayGenerator(int size) {
    	int[] result = new int[size];
		Random r = new Random();
        for(int i = 0; i < size; i++){
            result[i] = i;
        }
		for(int i = 0; i < size; i++) {
			int pos = r.nextInt(size);
            int temp = result[i];
			result[i] = result[pos];
			result[pos] = temp;
		}
		return result;
	}

    //round 1
	//1     4     7     10
	//  2     5     8
	//    3     6     9
    //round 2
	//1   3   5   7   9
	//  2   4   6   8
    public static void ShellSortPartition(int[] arr, int startIndex, int interval) {
		for(int i = startIndex; i < arr.length; i = i + interval) {
			int pos = i;
			while(pos - interval >= startIndex && arr[pos - interval] > arr[pos]) {
				int temp = arr[pos];
				arr[pos] = arr[pos - interval];
				arr[pos - interval] = temp;
				pos = pos - interval;
 			}
		}
	}
    // shellSort implementation
    public static void Shellsort(int[] arr){
        //interval 2^n -1 , 2^(n-1) - 1, 2^(n-2) -1, ..., 2, 1
        int length = arr.length;
        int n = (int)Math.floor(Math.log(length + 1));
        for(int i = n; i > 0; i--){
            int interval = (int)Math.pow(2, i) - 1;
            for(int start = 0; start < interval; start++){
                ShellSortPartition(arr, start, interval);
            }
        }
    }


    public static void displayArray(int[] arr){
        //for-each loop in Java
        for(int element: arr){
            System.out.print(element + " >> ");
        }
        System.out.println(" ");
    }
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
    
    //Insertion Sort
    public static void InsertionSorts(int[] arr) {
    	for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = current;
        }

	}
    private static long runInsertionSortBenchmark(int[] arr) {
        int[] shuffledArr = arr.clone();
        long startTime = System.currentTimeMillis();
        InsertionSorts(shuffledArr);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    


}
