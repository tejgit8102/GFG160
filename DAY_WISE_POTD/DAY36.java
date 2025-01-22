//Module 5 - Matrix
//Problem 1 - Day36 - Spirally traversing a matrix


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        if (mat == null || mat.length == 0) {
            return result;
        }
        
        int top = 0;                 // Starting row
        int bottom = mat.length - 1; // Ending row
        int left = 0;               // Starting column
        int right = mat[0].length - 1; // Ending column
        
        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++; // Move the top boundary down
            
            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--; // Move the right boundary left
            
            if (top <= bottom) {
                // Traverse from right to left along the bottom row
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }
            
            if (left <= right) {
                // Traverse from bottom to top along the left column
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++; // Move the left boundary right
            }
        }
        
        return result;
    }
}
