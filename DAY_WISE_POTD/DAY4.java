//Module 1 - Arrays
//Problem 4 - Day4 - Rotate Array

class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        d = d % n; // To handle cases where d >= n
        
        // Reverse the first d elements
        reverse(arr, 0, d - 1);
        // Reverse the remaining elements
        reverse(arr, d, n - 1);
        // Reverse the entire array
        reverse(arr, 0, n - 1);
    }
    
    // Helper function to reverse elements of an array from index start to end
    static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
