//Module 4 - Searching
//Problem 8 - Day35 - Kth Missing Positive Number in a Sorted Array

class Solution {
    public int kthMissing(int[] arr, int k) {
        int current = 1; // The first missing positive number
        int n = arr.length;
        
        // Traverse through the array
        for (int i = 0; i < n; i++) {
            // Calculate how many numbers are missing before arr[i]
            int missingNumbers = arr[i] - current;
            
            // If there are enough missing numbers
            if (missingNumbers >= k) {
                return current + k - 1;
            }
            
            // Otherwise, decrease k by the number of missing numbers
            k -= missingNumbers;
            
            // Move the current pointer to arr[i] + 1
            current = arr[i] + 1;
        }
        
        // If not found in the array, calculate based on the last element
        return current + k - 1;
    }
}
