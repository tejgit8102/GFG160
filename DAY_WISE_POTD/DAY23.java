//Module 3 - Sorting
//Problem 3 - Day23 - Count Inversions

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Use a helper function with additional parameters for recursion.
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    // Function to perform merge sort and count inversions.
    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in the left half.
            count += mergeSortAndCount(arr, left, mid);

            // Count inversions in the right half.
            count += mergeSortAndCount(arr, mid + 1, right);

            // Count split inversions while merging.
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    // Function to merge two sorted halves and count split inversions.
    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = java.util.Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = java.util.Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left, swaps = 0;

        // Merge the two halves while counting inversions.
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (mid + 1) - (left + i);
            }
        }

        // Copy remaining elements of leftArr, if any.
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of rightArr, if any.
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return swaps;
    }
}
