//Module 13 - Stack
//Problem 1 - Day99 - Parenthesis Checker

class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {
                       return false;
                   }
            }
        }
        
        return stack.isEmpty();
    }
}
