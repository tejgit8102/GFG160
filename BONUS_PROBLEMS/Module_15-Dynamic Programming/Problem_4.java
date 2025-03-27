//Problem - Interleaved Strings

class Solution {
    public boolean isInterLeave(String s1, String s2, String s3) {
        // code here
        if(s1.length() + s2.length() != s3.length()) return false;
        
        int n = s1.length(), m = s2.length();
        
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        
        prev[0] = 1;
        
        for(int j = 1; j <= m; ++j) {
            prev[j] = 
                (s2.charAt(j - 1) == s3.charAt(j - 1)) && (prev[j - 1] == 1) ? 1 : 0;
        }
        
        for(int i = 1; i <= n; ++i) {
            
            cur[0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && (prev[0] == 1) ? 1 : 0;
            for(int j = 1; j <= m; ++j) {
                int k = i + j;
                cur[j] = ((s1.charAt(i - 1) == s3.charAt(k - 1) && prev[j] == 1) ||
                          (s2.charAt(j - 1) == s3.charAt(k - 1) && cur[j - 1] == 1))
                            ? 1
                            : 0;
            }
            
            prev = Arrays.copyOf(cur, m + 1);
        }
        
        return cur[m] == 1;
    }
}
