//Module 8 - Prefix Sum
//Problem 3 - Day63 - Largest subarray of 0's and 1's

class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLength = 0;
        int prefixSum = 0;
        
        for(int i = 0; i < arr.length; i++){
            prefixSum += arr[i];
            
            if(prefixSum == 0){
                maxLength = i + 1;
            }
            
            if(prefixSumMap.containsKey(prefixSum)){
                maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum));
            } else {
                prefixSumMap.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
}
