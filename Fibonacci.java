/*Fibonacci number is a sequence which following the principle that the current number equals to the addition between previous two.

F(0) = 1, F(1) = 1, F(2) = 2, F(3) = 3, F(4) = 5, …

F(n+2) = F(n) + F(n+1)

Write a function which can generate any Fibonacci number by given index:

Example: Fibonacci(5) = 8

Also, try to print out in console how many times it takes to get the value. (every time, the function is called, increment the times by 1)

Due Date: 9/27*/

package fibonacci;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		}

	

public static void SelectionSort(int[] arr) {
	for(int i = 0; i < arr.length - 1; i++) {
		int SmallestIndex = i;
		for (int j = i; j < arr.length - 1; j++) {
			if(arr[j] < arr[i]) {
			SmallestIndex = j;
	}
}
		if (SmallestIndex != 1) {
			int temp = arr[i];
			arr[i] = arr[SmallestIndex];
			arr[SmallestIndex] = temp;
		}
}

}

}
