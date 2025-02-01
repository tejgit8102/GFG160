//Module 10 - Recursion and Backtracking
//Problem 5 - Day79 - Word Search

class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, i, j, 0, new boolean[n][m])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static boolean dfs(char[][] mat, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j] || mat[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true;
        
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};
        
        for (int d = 0; d < 4; d++) {
            if (dfs(mat, word, i + rowDir[d], j + colDir[d], index + 1, visited)) {
                return true;
            }
        }
        
        visited[i][j] = false;
        return false;
    }
}
