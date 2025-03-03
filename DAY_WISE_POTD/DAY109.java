//Module 14 - Queue and Deque
//Problem 2 - Day109 - Longest Bounded-Difference Subarray

class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, maxLen = 0, startIndex = 0;
        
        for(int right = 0; right < arr.length; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            
            while(map.lastKey() - map.firstKey() > x)
            {
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            
            if(right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIndex = left;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = startIndex; i < startIndex + maxLen; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
