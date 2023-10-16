package pack;

public class InsertionSort {

	public static void main(String[] args ) {
		int[] array = new int[] {6, 2, 3, 4, 5};
		int[] array2 = new int[] {6, 2, 3, 4, 5};
		
		long a = System.nanoTime();
		InsertionSorts(array);
		long b = System.nanoTime();
		System.out.println(b - a);
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
			System.out.println(array2[i]);

		}

}
	
	public static void InsertionSorts(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int current = 1;
			for(int j = i -1; j >= 0; j--) {
				if(arr[current] >= arr[j]) {
					break;
				}else {
					int temp = arr[j];
					arr[j] = arr[current];
					arr[current] = temp;
					current = j;
				}
			}
		}

	}


public static void BubleSort(int[] arr) {
	for(int i = 0; i < arr.length - 1; i++) {
		for(int j = 0; j < arr.length - 1 - i; j++) {
			if(arr[j + 1] < arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}
}

}
	