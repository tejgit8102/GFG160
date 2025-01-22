//Problem - Maximize Number of 1's

class Solution {
    public int maxOnes(int arr[], int k) {
        int start = 0; // Start of the sliding window
        int zeroCount = 0; // Count of zeros in the current window
        int maxLength = 0; // Maximum length of consecutive 1's

        // Traverse the array
        for (int end = 0; end < arr.length; end++) {
            // Include the current element in the window
            if (arr[end] == 0) {
                zeroCount++;
            }

            // If zeroCount exceeds k, shrink the window
            while (zeroCount > k) {
                if (arr[start] == 0) {
                    zeroCount--;
                }
                start++; // Move the start of the window
            }

            // Update the maximum length
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
