//Problem - Distinct occurrences

class Solution {
    public int subseqCount(String txt, String pat) {
        // code here
        int m = pat.length();
        int n = txt.length();
        
        if(m > n) return 0;
        
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        
        prev[0] = 1;
        
        for(int i = 1; i <= n; i++) {
            curr[0] = 1;
            
            for(int j = 1; j <= m; j++) {
                if(txt.charAt(i - 1) == pat.charAt(j - 1)) {
                    curr[j] = (prev[j - 1] + prev[j]);
                } else {
                    curr[j] = prev[j];
                }
            }
            
            System.arraycopy(curr, 0, prev, 0, curr.length);
        }
        
        return (int)prev[m];
    }
}
