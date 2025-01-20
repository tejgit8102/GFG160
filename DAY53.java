//Module 7 - Two Pointer Technique
//Problem 3 - Day53 - Sum Pair closest to target


class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        if(arr == null || arr.length < 2){
            return new ArrayList<>();
        }
        
        Arrays.sort(arr);
        
        int left = 0, right = arr.length - 1;
        int closestDiff = Integer.MAX_VALUE;
        int maxAbsDiff = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        
        while(left < right){
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum - target);
            
            if(diff < closestDiff || (diff == closestDiff && (arr[right] - arr[left] > maxAbsDiff))) {
                closestDiff = diff;
                maxAbsDiff = arr[right] - arr[left];
                result = Arrays.asList(arr[left], arr[right]);
            }
            
            if(sum < target){
                left++;
            } else {
                right--;
            }
        }
        
        return result;
    }
}
