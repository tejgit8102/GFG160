//Module 8 - Prefix Sum
//Problem 2 - Day62 - Longest Subarray with Sum K

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            
            if(sum == k){
                maxLen = i + 1;
            }
            
            if(prefixSumMap.containsKey(sum - k)){
                maxLen = Math.max(maxLen, i - prefixSumMap.get(sum - k));
            }
            
            if(!prefixSumMap.containsKey(sum)){
                prefixSumMap.put(sum, i);
            }
        }
        
        return maxLen;
    }
}
