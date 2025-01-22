//Module 6 - Hashing
//Problem 7 - Day48 - Print Anagrams Together

class Solution{
    public ArrayList<ArrayList<String>> anagrams(String[] arr){
        HashMap<String, ArrayList<String>> anagramMap = new HashMap<>();
        
        for(String word:arr){
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            
            anagramMap.putIfAbsent(sortedWord, new ArrayList<>());
            anagramMap.get(sortedWord).add(word);
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        for(ArrayList<String> group:anagramMap.values()){
            result.add(group);
        }
        return result;
    }
}
