//Problem - Implement Lower Bound

class Solution {
    int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = arr.length; // Default result if no element >= target is found
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] >= target) {
                result = mid;  // Update result and move to the left half
                right = mid - 1;
            } else {
                left = mid + 1; // Move to the right half
            }
        }
        
        return result;
    }
}
