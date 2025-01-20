//Module 4 - Searching
//Problem 1 - Day28 - Number of occurrence

class Solution {
    int countFreq(int[] arr, int target) {
        // Find the first and last occurrences of the target
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);

        // If target is not found, return 0
        if (first == -1) return 0;

        // The number of occurrences is (last - first + 1)
        return last - first + 1;
    }

    // Helper function to find the first occurrence
    int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; // Search in the left half
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Helper function to find the last occurrence
    int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                low = mid + 1; // Search in the right half
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
