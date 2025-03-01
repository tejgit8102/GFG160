//Module 13 - Stack
//Problem 8 - Day106 - Evaluation of Postfix Expression

class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        
        for(String token : arr){
            if(isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOperation(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    private int applyOperation(int a, int b, String operator) {
        switch(operator) {
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            case "/": return a/b;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
