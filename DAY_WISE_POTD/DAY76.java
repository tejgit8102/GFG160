//Module 10 - Recursion and Backtracking
//Problem 2 - Day76 - Implement Pow

class Solution {
    double power(double b, int e) {
        // code here
        if(e == 0) return 1.0;
        if(b == 0) return 0.0;
        
        if(e < 0){
            b = 1/b;
            e = -e;
        }
        
        double halfPower = power(b, e/2);
        
        if(e%2 == 0){
            return halfPower * halfPower;
        } else {
            return halfPower * halfPower * b;
        }
    }
}
