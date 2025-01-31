//Module 10 - Recursion and Backtracking
//Problem 4 - Day78 - Solve the Sudoku

class Solution {
    
    static final int N = 9;
    
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        boolean[][] row = new boolean[N][N + 1];
        boolean[][] col = new boolean[N][N + 1];
        boolean[][] box = new boolean[N][N + 1];
        
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(mat[r][c] != 0){
                    int num = mat[r][c];
                    row[r][num] =  true;
                    col[c][num] = true;
                    box[getBoxIndex(r, c)][num] = true;
                }
            }
        }
        
        solve(mat, row, col, box);
    }
    
    private static boolean solve(int[][] mat, boolean[][] row, boolean[][] col, boolean[][] box){
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(mat[r][c] == 0){
                    for(int num = 1; num <=9; num++){
                        int boxIndex = getBoxIndex(r, c);
                        if(!row[r][num] && !col[c][num] && !box[boxIndex][num]){
                            mat[r][c] = num;
                            row[r][num] = col[c][num] = box[boxIndex][num] = true;
                            
                            if(solve(mat, row, col, box)){
                                return true;
                            }
                            
                            mat[r][c] = 0;
                            row[r][num] = col[c][num] = box[boxIndex][num] = false;
                        }
                    }
                    return false;
                }
            }
            
        }
        
        return true;
    }
    
    private static int getBoxIndex(int r, int c){
        return (r/3) * 3 + (c/3);
    }
    
    static void printSudoku(int[][] mat){
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                System.out.print(mat[r][c] + " ");
            }
            System.out.println();
        }
    }
}
