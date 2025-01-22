//Module 5 - Matrix
//Problem 2 - Day37 - Rotate by 90 degree

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int mat[][]) {
        int n = mat.length;

        // Step 1: Transpose the matrix (swap mat[i][j] with mat[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each column
        for (int j = 0; j < n; j++) {
            for (int i = 0, k = n - 1; i < k; i++, k--) {
                int temp = mat[i][j];
                mat[i][j] = mat[k][j];
                mat[k][j] = temp;
            }
        }
    }

    // Utility function to print the matrix (for testing)
    static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
