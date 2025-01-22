//Problem - Make Matrix Beautiful

class Solution {
    public static int findMinOperation(int[][] mat) {
        int n = mat.length; // The matrix is square (n x n)
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        
        // Calculate row sums and column sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }
        
        // Find the target sum (maximum sum among rows and columns)
        int targetSum = 0;
        for (int i = 0; i < n; i++) {
            targetSum = Math.max(targetSum, rowSum[i]);
            targetSum = Math.max(targetSum, colSum[i]);
        }
        
        // Calculate the minimum operations required
        int operations = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Calculate the contribution needed for this cell
                int increment = Math.min(targetSum - rowSum[i], targetSum - colSum[j]);
                
                // Increment the cell and adjust the row/column sums
                mat[i][j] += increment;
                rowSum[i] += increment;
                colSum[j] += increment;
                
                // Add to total operations
                operations += increment;
            }
        }
        
        return operations;
    }
}
