//Problem - Create a spiral matrix of N*M size from given array

class Solution {
    public int[][] spiralFill(int n, int m, int[] arr) {
        int[][] matrix = new int[n][m]; // Initialize the n x m matrix
        int top = 0, bottom = n - 1, left = 0, right = m - 1; // Define boundaries
        int index = 0; // Pointer to traverse the array

        while (top <= bottom && left <= right) {
            // Fill top row
            for (int i = left; i <= right && index < arr.length; i++) {
                matrix[top][i] = arr[index++];
            }
            top++;

            // Fill right column
            for (int i = top; i <= bottom && index < arr.length; i++) {
                matrix[i][right] = arr[index++];
            }
            right--;

            // Fill bottom row
            for (int i = right; i >= left && index < arr.length; i--) {
                matrix[bottom][i] = arr[index++];
            }
            bottom--;

            // Fill left column
            for (int i = bottom; i >= top && index < arr.length; i--) {
                matrix[i][left] = arr[index++];
            }
            left++;
        }

        return matrix; // Return the filled matrix
    }
}

