//Module 5 - Matrix
//Problem 5 - Day40 - Search in a sorted Matrix


class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;    // Number of rows
        int m = mat[0].length; // Number of columns
        
        int low = 0;
        int high = n * m - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;  // Map 1D index to row
            int col = mid % m;  // Map 1D index to column
            int midValue = mat[row][col];
            
            if (midValue == x) {
                return true;  // Element found
            } else if (midValue < x) {
                low = mid + 1;  // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        
        return false;  // Element not found
    }
}
