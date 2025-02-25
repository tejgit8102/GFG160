//Module 13 - Stack
//Problem 5 - Day103 - Histogram Max Rectangular Area

class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        int i = 0;
        while(i < n) {
            if(stack.isEmpty() || arr[i] >= arr[stack.peek()]) {
                stack.push(i++);
            } else {
                int height = arr[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }
        
        while(!stack.isEmpty()) {
            int height = arr[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        
        return maxArea;
    }
}
