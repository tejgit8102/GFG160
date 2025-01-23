//Module 1 - Arrays
//Problem 5 - Day5 - Next Permutation


class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;

        // Step 1: Find the first element from the end that is smaller than the next element
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Step 2: If such an element is found, find the smallest element greater than it on its right
        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            // Swap the elements
            swap(arr, i, j);
        }

        // Step 3: Reverse the subarray to the right of the found element (or the whole array if no such element exists)
        reverse(arr, i + 1, n - 1);
    }

    // Helper function to swap two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Helper function to reverse a subarray
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
