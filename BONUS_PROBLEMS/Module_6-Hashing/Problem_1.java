//Problem - Roman Number to Integer
\
class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        // code here
        
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int result = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            int currentVal = romanMap.get(s.charAt(i));
            
            if(i < n - 1 && currentVal < romanMap.get(s.charAt(i+1))){
                result -= currentVal;
            } else {
                result += currentVal;
            }
        }
        
        return result;
    }
}
