//Problem - 4 Sum – Count quadruplets with given sum

class Solution {
    public int countSum(int arr[], int target) {
        // code here
        
        int n = arr.length;
        int count = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n - 1; i++){
            
            for(int j = i + 1; j < n; j++){
                int temp = arr[i] + arr[j];
                count += map.getOrDefault(target - temp, 0);
            }
            
            for(int j = 0; j < i; j++){
                int temp = arr[i] + arr[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        
        return count;
    }
}
