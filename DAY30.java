//Module 4 - Searching
//Problem 3 - Day30 - Search in Rotated Sorted Array

class Solution {
    int search(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            // Check if the left half is sorted
            if (arr[low] <= arr[mid]) {
                // Check if the key lies in the left half
                if (key >= arr[low] && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // Otherwise, the right half is sorted
                // Check if the key lies in the right half
                if (key > arr[mid] && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // If we exit the loop, the key is not in the array
        return -1;
    }
}
