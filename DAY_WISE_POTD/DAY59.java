//Module 7 - Two Pointer Technique
//Problem 9 - Day59 - Trapping Rain Water

class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = arr[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        
        rightMax[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        
        int totalWater = 0;
        for(int i = 0; i < n; i++){
            totalWater += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        
        return totalWater;
    }
}

