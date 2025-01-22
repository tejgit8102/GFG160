//Problem - Pairs with difference k

class Solution {
    int countPairs(int[] arr, int k) {
        // code here
        
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0;
        
        for(int num : arr){
            if(frequencyMap.containsKey(num - k)){
                count += frequencyMap.get(num - k);
            }
            
            if(frequencyMap.containsKey(num + k)){
                count += frequencyMap.get(num + k);
            }
            
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        return count;
    }
}
