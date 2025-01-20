//Module 6 - Hashing
//Problem 9 - Day50 - Count Subarrays with given XOR

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> xorMap = new HashMap<>();
        int n = arr.length;
        int currentXOR = 0;
        long count = 0;
        
        for(int i=0; i<n; i++){
            currentXOR ^= arr[i];
            
            if(currentXOR == k){
                count++;
            }
            
            int requiredXOR = currentXOR ^ k;
            if(xorMap.containsKey(requiredXOR)){
                count += xorMap.get(requiredXOR);
            }
            
            xorMap.put(currentXOR, xorMap.getOrDefault(currentXOR, 0) + 1);
        }
        
        return count;
    }
}
