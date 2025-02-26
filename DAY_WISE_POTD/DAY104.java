//Module 13 - Stack
//Problem 6 - Day104 - Maximum of minimum for every window size

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, Integer.MIN_VALUE));
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        int[] windowMin = new int[n + 1];
        Arrays.fill(windowMin, Integer.MIN_VALUE);
        
        for(int i = 0; i < n; i++) {
            int windowSize = right[i] - left[i] - 1;
            windowMin[windowSize] = Math.max(windowMin[windowSize], arr[i]);
        }
        
        for(int i = n - 1; i >= 1; i--){
            windowMin[i] = Math.max(windowMin[i], windowMin[i + 1]);
        }
        
        for(int i = 1; i <= n; i++) {
            result.set(i - 1, windowMin[i]);
        }
        
        return result;
     
     }
}
