//Module 4 - Searching
//Problem 7 - Day34 - Allocate Minimum Pages

class Solution {
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1; // Not enough books for every student to get at least one

        int low = Integer.MIN_VALUE; // Maximum book pages
        int high = 0; // Sum of all pages

        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid overflow
            if (isValid(arr, k, mid)) {
                result = mid; // Update result with the feasible maximum
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1; // Try for a larger maximum
            }
        }
        return result;
    }

    private static boolean isValid(int[] arr, int k, int maxPages) {
        int students = 1; // Start with one student
        int pagesSum = 0; // Current pages allocated

        for (int pages : arr) {
            if (pagesSum + pages > maxPages) {
                students++; // Allocate to a new student
                pagesSum = pages; // Start new allocation
                if (students > k) return false; // More students than allowed
            } else {
                pagesSum += pages;
            }
        }
        return true; // Allocation is valid
    }
}
