//Problem 2 - Push all the zeros present in an array to the end

class Solution {
    void pushZerosToEnd(int[] arr) {
        // Initialize a pointer to keep track of the position for non-zero elements
        int index = 0;

        // Iterate over the array
        for (int i = 0; i < arr.length; i++) {
            // If the current element is not zero, move it to the index position
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // Fill the remaining positions with zeros
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
    }
}
