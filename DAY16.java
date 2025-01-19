//Module 2 - Strings
//Problem 3 - Day16 - Anagram

class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        // If lengths are not the same, they cannot be anagrams.
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create frequency maps for both strings.
        HashMap<Character, Integer> freqMap1 = new HashMap<>();
        HashMap<Character, Integer> freqMap2 = new HashMap<>();

        // Count the frequency of characters in s1.
        for (char c : s1.toCharArray()) {
            freqMap1.put(c, freqMap1.getOrDefault(c, 0) + 1);
        }

        // Count the frequency of characters in s2.
        for (char c : s2.toCharArray()) {
            freqMap2.put(c, freqMap2.getOrDefault(c, 0) + 1);
        }

        // Compare the frequency maps.
        return freqMap1.equals(freqMap2);
    }
}
