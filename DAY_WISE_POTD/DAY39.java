//Module 5 - Matrix
//Problem 4 - Day39 - Search in a row-wise sorted matrix

class Solution {
    // Function to search a given number in a row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        int n = mat.length;    // Number of rows
        int m = mat[0].length; // Number of columns
        
        // Traverse each row and apply binary search
        for (int i = 0; i < n; i++) {
            if (binarySearch(mat[i], x)) {
                return true;
            }
        }
        
        return false; // Element not found in any row
    }
    
    // Helper function to perform binary search in a row
    private boolean binarySearch(int[] row, int x) {
        int low = 0, high = row.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (row[mid] == x) {
                return true;
            } else if (row[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false; // Element not found in this row
    }
}
