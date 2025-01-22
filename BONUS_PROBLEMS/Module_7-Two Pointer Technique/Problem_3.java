//Problem - 4 Sum - All Quadruples

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        // code here
        List<List<Integer>> result = new ArrayList<>();
        if(arr == null || arr.length < 4){
            return result;
        }
        
        Arrays.sort(arr);
        int n = arr.length;
        
        for(int i = 0; i < n - 3; i++){
            if(i > 0 && arr[i] == arr[i - 1]){
                continue;
            }
            
            for(int j = i + 1; j < n - 2; j++){
                if(j > i + 1 && arr[j] == arr[j - 1]){
                    continue;
                }
                
                int left = j + 1;
                int right = n - 1;
                
                while(left < right){
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    
                    if(sum == target){
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        
                        while(left < right && arr[left] == arr[left + 1]){
                            left++;
                        }
                        
                        while(left < right && arr[right] == arr[right - 1]){
                            right--;
                        }
                        
                        left++;
                        right--;
                    } else if(sum < target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}
