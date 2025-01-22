//Module 2 - Strings
//Problem 4 - Day17 - Non Repeating Character

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Use a LinkedHashMap to store characters and their frequencies.
        LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
        
        // Traverse the string and count occurrences of each character.
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Traverse the LinkedHashMap to find the first non-repeating character.
        for (char c : charCount.keySet()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }
        
        // If no non-repeating character is found, return '$'.
        return '$';
    }
}
