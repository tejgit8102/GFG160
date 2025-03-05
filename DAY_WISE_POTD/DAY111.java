//Module 15 - Dynamic Programming
//Problem 2 - Day111 - Longest String Chain

class Solution {
    public int longestStringChain(String words[]) {
        // code here
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        HashMap<String, Integer> dp = new HashMap<>();
        int maxLength = 1;
        
        for(String word : words) {
            int longest = 1;
            for(int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                longest = Math.max(longest, dp.getOrDefault(predecessor, 0) + 1);
            }
            dp.put(word, longest);
            maxLength = Math.max(maxLength, longest);
        }
        
        return maxLength;
        
    }
}
