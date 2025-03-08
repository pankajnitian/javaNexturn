package test;

// 4. Matrix Addition

 public class Problem4 {
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        int[][] C = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 2},
            {3, 4}
        };

        int[][] B = {
            {5, 6},
            {7, 8}
        };

        int[][] C = addMatrices(A, B);
        System.out.println("Resultant Matrix:");
        printMatrix(C); // Expected Output: [[6, 8], [10, 12]]
    }
}