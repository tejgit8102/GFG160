//Module 10 - Recursion and Backtracking
//Problem 3 - Day77 - N-Queen Problem

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n];
        solveNQueen(n, 0, board, result);
        return result;
    }
    
    private void solveNQueen(int n, int col, int[] board, ArrayList<ArrayList<Integer>> result){
        if(col == n){
            ArrayList<Integer> solution = new ArrayList<>();
            for(int i = 0; i < n; i++){
                solution.add(board[i] + 1);
            }
            result.add(solution);
            return;
        }
        
        for(int row = 0; row < n; row++){
            if(isSafe(row, col, board)){
                board[col] = row;
                solveNQueen(n, col + 1, board, result);
            }
        }
    }
    
    private boolean isSafe(int row, int col, int[] board){
        for(int prevCol = 0; prevCol < col; prevCol++){
            int prevRow = board[prevCol];
            if(prevRow == row || Math.abs(prevRow - row) ==  Math.abs(prevCol - col)){
                return false;
            }
        }
        return true;
    }
}
