//Module 1 - Arrays
//Problem 6 - Majority Element II

class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Step 1: Find two candidates using the modified Boyer-Moore Voting Algorithm
        int candidate1 = Integer.MAX_VALUE, candidate2 = Integer.MAX_VALUE;
        int count1 = 0, count2 = 0;
        
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        // Step 2: Verify the two candidates by counting their occurrences
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }
        
        // Step 3: Return the result in increasing order
        Collections.sort(result);
        return result;
    }
}
