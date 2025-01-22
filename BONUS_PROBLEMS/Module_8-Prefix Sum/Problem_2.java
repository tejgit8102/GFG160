//Problem - Longest Subarray with Majority Greater than K

class Solution {
    static int longestSubarray(int[] arr, int k) {
        // Code Here
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int prefixSum = 0;
        
        map.put(0, -1);
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > k){
                prefixSum += 1;
            } else {
                prefixSum -= 1;
            }
            
            if(prefixSum > 0){
                maxLength = i + 1;
            }
            
            if(map.containsKey(prefixSum - 1)){
                maxLength = Math.max(maxLength, i - map.get(prefixSum - 1));
            }
            
            map.putIfAbsent(prefixSum, i);
        }
        
        return maxLength;
    }
}
