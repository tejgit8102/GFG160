//Module 6 - Hashing
//Problem 8 - Day49 - Subarrays with sum K

class Solution {
    public int countSubarrays(int arr[], int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        
        prefixSumCount.put(0,1);
        
        for(int num:arr){
            prefixSum += num;
            
            if(prefixSumCount.containsKey(prefixSum - k)){
                count += prefixSumCount.get(prefixSum - k);
            }
            
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0)+1);
        }
        
        return count;
    }
}
