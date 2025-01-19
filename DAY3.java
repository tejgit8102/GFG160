//Module 1 - Arrays
//Problem 3 - Reverse a given array

class Solution {
    public static void reverseArray(int[] arr) {
        int start = 0;            // Pointer to the beginning of the array
        int end = arr.length - 1; // Pointer to the end of the array

        // Loop until start crosses or meets end
        while (start < end) {
            // Swap elements at start and end
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move the pointers inward
            start++;
            end--;
        }
    }
}
