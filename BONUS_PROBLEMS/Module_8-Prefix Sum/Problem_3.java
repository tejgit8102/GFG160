//Problem - Largest rectangular sub-matrix whose sum is 0

class Solution {
    public static int zeroSumSubmat(int[][] mat) {
        // code here
        int rows = mat.length;
        int cols = mat[0].length;
        int maxArea = 0;
        
        for(int startRow = 0; startRow < rows; startRow++){
            int[] colSums = new int[cols];
            
            for(int endRow = startRow; endRow < rows; endRow++){
                for(int col = 0; col < cols; col++){
                    colSums[col] += mat[endRow][col];
                }
                
                maxArea = Math.max(maxArea, findLargestZeroSumSubarray(colSums, endRow - startRow + 1));
            }
        }
        
        return maxArea;
    }
    
    private static int findLargestZeroSumSubarray(int[] arr, int rowCount){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, maxLength = 0;
        
        for(int col = 0; col < arr.length; col++){
            sum += arr[col];
            
            if(map.containsKey(sum)){
                int startCol = map.get(sum);
                int subArrayLength = col - startCol;
                maxLength = Math.max(maxLength, subArrayLength * rowCount);
            } else {
                map.put(sum, col);
            }
        }
        
        return maxLength;
    }
}

