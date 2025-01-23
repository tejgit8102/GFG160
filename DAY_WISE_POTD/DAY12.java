//Module 1 - Arrays
//Problem 12 - Day12 - Max Circular Subarray Sum

class Solution {

    // Function to find maximum circular subarray sum
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;
        
        // Step 1: Find the maximum subarray sum using Kadane's algorithm
        int maxKadane = kadane(arr);
        
        // Step 2: Calculate the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // Step 3: Find the minimum subarray sum using a modified Kadane's algorithm
        int minKadane = kadaneForMin(arr);
        
        // Step 4: Handle the all-negative case
        if (totalSum == minKadane) {
            // If all numbers are negative, max circular sum is just the maximum single element
            return maxKadane;
        }
        
        // Step 5: Return the maximum of the two cases
        return Math.max(maxKadane, totalSum - minKadane);
    }

    // Helper function to find the maximum subarray sum (Kadane's algorithm)
    private int kadane(int[] arr) {
        int maxEndingHere = 0, maxSoFar = Integer.MIN_VALUE;
        for (int num : arr) {
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // Helper function to find the minimum subarray sum
    private int kadaneForMin(int[] arr) {
        int minEndingHere = 0, minSoFar = Integer.MAX_VALUE;
        for (int num : arr) {
            minEndingHere = Math.min(num, minEndingHere + num);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        return minSoFar;
    }
}
