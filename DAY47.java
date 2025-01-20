//Module 6 - Hashing
//Problem 6 - Day47 - Longest Consecutive Subsequence

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        
        if(arr == null || arr.length == 0){
            return 0;
        }
        // code herecla
        
        HashSet<Integer> set = new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        
        int longestStreak = 0;
        
        for (int num:arr){
            if(!set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                
                while(set.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
}
