//Problem - Fizz Buzz

class Solution {
    public static ArrayList<String> fizzBuzz(int n) {
        // Create a list to store the result
        ArrayList<String> result = new ArrayList<>();
        
        // Loop through numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz"); // Divisible by both 3 and 5
            } else if (i % 3 == 0) {
                result.add("Fizz"); // Divisible by 3
            } else if (i % 5 == 0) {
                result.add("Buzz"); // Divisible by 5
            } else {
                result.add(String.valueOf(i)); // Neither divisible by 3 nor 5
            }
        }
        
        return result; // Return the result
    }
}
