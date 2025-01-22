//Problem - CamelCase Pattern Matching

class Solution {
    public List<String> camelCase(String[] arr, String pat) {
        // List to store the matching words
        List<String> result = new ArrayList<>();
        
        // Iterate through each word in the array
        for (String word : arr) {
            // Extract the uppercase letters from the word
            StringBuilder uppercaseLetters = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    uppercaseLetters.append(c);
                }
            }
            
            // Check if the extracted uppercase letters start with the pattern
            if (uppercaseLetters.toString().startsWith(pat)) {
                result.add(word);
            }
        }
        
        // Return the result list (empty list if no matches are found)
        return result;
    }
}
