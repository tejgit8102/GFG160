//Module 1 - Arrays
//Problem 13 - Smallest Positive Missing

class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Step 1: Rearrange elements
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] with the element at its correct position
                int correctIndex = arr[i] - 1;
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            }
        }

        // Step 2: Identify the missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1; // Return the missing number
            }
        }

        // Step 3: If all numbers are in place, the missing number is n+1
        return n + 1;
    }
}
