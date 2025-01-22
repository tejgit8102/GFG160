//Problem - Rotate a Matrix by 180 Counterclockwise

class Solution {
    public void rotateMatrix(int[][] mat) {
        int n = mat.length;

        // Loop through half of the rows
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                // Swap the element with its 180-degree counterpart
                int temp = mat[i][j];
                mat[i][j] = mat[n - 1 - i][n - 1 - j];
                mat[n - 1 - i][n - 1 - j] = temp;
            }
        }

        // Handle the middle row for odd-sized matrices
        if (n % 2 != 0) {
            int mid = n / 2; // Middle row index
            for (int j = 0; j < n / 2; j++) {
                // Swap the element with its counterpart within the same row
                int temp = mat[mid][j];
                mat[mid][j] = mat[mid][n - 1 - j];
                mat[mid][n - 1 - j] = temp;
            }
        }
    }
}
