//Problem - Subarrays with K Distinct Integers

class Solution {
    static int exactlyK(int arr[], int k) {
        // code here
        return atMostK(arr, k) - atMostK(arr, k - 1);
    }
    
    private static int atMostK(int[] arr, int k){
        if(k == 0) return 0;
        
        int left = 0, right = 0, count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        while(right < arr.length){
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
