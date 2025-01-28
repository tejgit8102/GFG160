//Module 10 - Recursion and Backtracking
//Problem 1 - Day75 - Permutations of a String

class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        ArrayList<String> result = new ArrayList<>();
        Set<String> uniquePermutations = new HashSet<>();
        char[] chars = s.toCharArray();
        permute(chars, 0, uniquePermutations);
        result.addAll(uniquePermutations);
        Collections.sort(result);
        return result;
    }
    
    private void permute(char[] chars, int index, Set<String> uniquePermutations){
        if(index == chars.length){
            uniquePermutations.add(new String(chars));
            return;
        }
        for(int i = index; i < chars.length; i++){
            swap(chars, index, i);
            permute(chars, index + 1, uniquePermutations);
            swap(chars, index, i);
        }
    }
    
    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
