//Module 1 - Arrays
//Problem 11 - Day11 - Maximum Product Subarray

class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        
        // Initialize variables
        int maxProduct = arr[0];  // Global maximum product
        int currentMax = arr[0];  // Current maximum product ending at the current index
        int currentMin = arr[0];  // Current minimum product ending at the current index
        
        // Traverse the array
        for (int i = 1; i < n; i++) {
            // If the current element is negative, swap currentMax and currentMin
            if (arr[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            
            // Update currentMax and currentMin
            currentMax = Math.max(arr[i], currentMax * arr[i]);
            currentMin = Math.min(arr[i], currentMin * arr[i]);
            
            // Update the global maximum product
            maxProduct = Math.max(maxProduct, currentMax);
        }
        
        return maxProduct;
    }
}
