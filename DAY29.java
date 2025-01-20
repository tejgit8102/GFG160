//Module 4 - Searching
//Problem 2 - Day29 - Sorted and Rotated Minimum

class Solution {
    public int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If mid element is greater than the rightmost element, 
            // the minimum is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // Otherwise, the minimum is in the left half (including mid)
            else {
                right = mid;
            }
        }
        
        // After the loop, left == right, which points to the minimum element
        return arr[left];
    }
}
