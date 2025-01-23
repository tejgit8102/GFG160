//Module 1 - Arrays
//Problem 10 - Day10 - Kadane's Algorithm

class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        // Initialize variables
        int maxSoFar = Integer.MIN_VALUE; // Maximum sum found so far
        int maxEndingHere = 0;            // Maximum sum ending at current position

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Update maxEndingHere
            maxEndingHere += arr[i];

            // Update maxSoFar if maxEndingHere is greater
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }

            // If maxEndingHere becomes negative, reset it to 0
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }
}
