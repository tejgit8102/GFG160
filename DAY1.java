//Problem 1 - Find the second largest element in a given array

class Solution {
    public int getSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1; // If array is null or has less than 2 elements
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}
