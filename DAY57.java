//Module 7 - Two Pointer Technique
//Problem 7 - Day57 - Count distinct elements in every window

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        for(int i = 0; i < k; i++){
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }
        
        result.add(frequencyMap.size());
        
        for(int i = k; i < arr.length; i++){
            int elementToRemove = arr[i - k];
            frequencyMap.put(elementToRemove, frequencyMap.get(elementToRemove) - 1);
            if(frequencyMap.get(elementToRemove) == 0){
                frequencyMap.remove(elementToRemove);
            }
            
            int elementToAdd = arr[i];
            frequencyMap.put(elementToAdd, frequencyMap.getOrDefault(elementToAdd, 0) + 1);
            
            result.add(frequencyMap.size());
        }
        
        return result;
        
    }
}
