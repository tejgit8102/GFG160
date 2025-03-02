//Module 13 - Stack
//Problem 9 - Day107 - Decode the string

class Solution {
    static String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int currentNum = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0'); 
            } else if (ch == '[') {
                numStack.push(currentNum); 
                strStack.push(currentStr.toString()); 
                currentNum = 0;
                currentStr = new StringBuilder();
            } else if (ch == ']') {
                int num = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                temp.append(currentStr.toString().repeat(num)); 
                currentStr = temp;
            } else {
                currentStr.append(ch); 
            }
        }
        return currentStr.toString();
    }
}
