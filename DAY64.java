//Module 8 - Prefix Sum
//Problem 4 - Day64 - Product array puzzle


class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length;
        int[] res = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        right[n - 1] = 1;
        
        for(int i = 1; i < n; i++){
            left[i] = left[i - 1] * arr[i - 1];
        }
        
        for(int i = n - 2; i >= 0; i--){
            right[i] = right[i + 1] * arr[i + 1];
        }
        
        for(int i = 0; i < n; i++){
            res[i] = left[i] * right[i];
        }
        
        return res;
    }
}
