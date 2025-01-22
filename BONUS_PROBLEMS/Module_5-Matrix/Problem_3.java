//Problem - Generate a matrix with each row and column of given sum

class Solution {
    public int[][] generateMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length; // Number of rows
        int m = colSum.length; // Number of columns
        int[][] matrix = new int[n][m]; // Initialize the matrix with size n x m

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Take the minimum of the current row sum and column sum
                matrix[i][j] = Math.min(rowSum[i], colSum[j]);

                // Subtract the assigned value from the corresponding row and column sums
                rowSum[i] -= matrix[i][j];
                colSum[j] -= matrix[i][j];
            }
        }

        return matrix; // Return the generated matrix
    }
}
