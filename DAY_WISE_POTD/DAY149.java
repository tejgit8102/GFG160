//Module 17 - Graph
//Problem 12 - Day149 - Flood fill Algorithm


class Solution {
    
    public void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length ||
            image[x][y] != oldColor) {
                return;
        }
        
        image[x][y] = newColor;
        
        dfs(image, x + 1, y, oldColor, newColor);
        dfs(image, x - 1, y, oldColor, newColor);
        dfs(image, x, y + 1, oldColor, newColor);
        dfs(image, x, y - 1, oldColor, newColor);
            
            
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        if(image[sr][sc] == newColor) {
            return image;
        }
        
        dfs(image, sr, sc, image[sr][sc], newColor);
        
        return image;
    }
};
