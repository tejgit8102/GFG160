//Problem - Bitonic Point

class Solution {
    public int findMaximum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the bitonic point
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
                return arr[mid];
            }
            // If the middle element is less than the next element, move right
            else if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
            // If the middle element is less than the previous element, move left
            else {
                right = mid - 1;
            }
        }
        return -1;  // This line is just a fallback; theoretically, it should never be reached
    }
}
