//Module 6 - Hashing
//Problem 2 - Day43 - Count pairs with given sum

class Solution {

    int countPairs(int arr[], int target) {
        // Create a HashMap to store the frequency of elements
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        // Traverse through the array
        for (int num : arr) {
            // Calculate the complement needed to form the target sum
            int complement = target - num;

            // Check if the complement exists in the HashMap
            if (freq.containsKey(complement)) {
                count += freq.get(complement);
            }

            // Update the frequency of the current element in the HashMap
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
