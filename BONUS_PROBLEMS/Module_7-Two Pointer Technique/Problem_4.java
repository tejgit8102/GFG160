//Problem - Subarrays With At Most K Distinct Integers

class Solution {
    public int atMostK(int arr[], int k) {
        // code here
        if(k == 0) return 0;
        
        int n = arr.length;
        int left = 0, right = 0;
        int count = 0;
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        while(right < n){
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);
            
            while(freqMap.size() > k){
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if(freqMap.get(arr[left]) == 0){
                    freqMap.remove(arr[left]);
                }
                left++;
            }
            
            count += (right - left + 1);
            right++;
        }
        
        return count;
    }
}
