package MatrixSearch;

public class matrixsearch {
    public static int[] findElement(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return new int[]{row, column};
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        int key1 = 5;
        int[] result1 = findElement(arr, key1);
        Result(key1, result1);

        int key2 = 15;
        int[] result2 = findElement(arr, key2);
        Result(key2, result2);

        int key3 = 10;
        int[] result3 = findElement(arr, key3);
        Result(key3, result3);
    }

    private static void Result(int key, int[] result) {
        if (result[0] != -1) {
            System.out.println("Element " + key + " found at row " + result[0] + ", column " + result[1]);
        } else {
            System.out.println("Element " + key + " not found in the matrix.");
        }
    }
}


