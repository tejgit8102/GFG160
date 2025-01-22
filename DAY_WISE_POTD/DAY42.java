//Module 6 - Hashing
//Problem 1 - Day42 - Two Sum - Pair with Given Sum

class Solution {
    boolean twoSum(int arr[], int target) {
        // Create a HashSet to store elements
        HashSet<Integer> set = new HashSet<>();
        
        // Traverse the array
        for (int num : arr) {
            // Calculate the difference
            int diff = target - num;
            
            // Check if the difference exists in the set
            if (set.contains(diff)) {
                return true;
            }
            
            // Add the current element to the set
            set.add(num);
        }
        
        // If no pair is found
        return false;
    }
}
