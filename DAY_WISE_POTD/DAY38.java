//Module 5 - Matrix
//Problem 3 - Day38 - Search in a Row-Column sorted matrix

class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int n = mat.length;       // Number of rows
        int m = mat[0].length;    // Number of columns
        
        int row = 0;              // Start at the top-right corner
        int col = m - 1;
        
        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                return true;      // Found the element
            } else if (mat[row][col] > x) {
                col--;            // Move left
            } else {
                row++;            // Move down
            }
        }
        return false;             // Element not found
    }
}
