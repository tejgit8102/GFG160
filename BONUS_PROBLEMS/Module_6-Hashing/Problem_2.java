//Problem - Max distance between same elements

class Solution {
    public int maxDistance(int[] arr) {
        // Code here
        
        HashMap<Integer, Integer> firstOccurence = new HashMap<>();
        int maxDist = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(!firstOccurence.containsKey(arr[i])){
                firstOccurence.put(arr[i], i);
            } else {
                maxDist = Math.max(maxDist, i - firstOccurence.get(arr[i]));
            }
        }
        
        return maxDist;
    }
}
