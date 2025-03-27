//Problem - Word Break - 2


class Solution {
    static String[] wordBreak(String[] dict, String s) {
        // code here
        HashSet<String> st = new HashSet<>(Arrays.asList(dict));
        int n = s.length();
        
        List<List<String>> dp = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        
        dp.get(n).add("");
        
        for(int i = n - 1; i >= 0; --i) {
            for(int j = i + 1; j <= n; ++j) {
                String word = s.substring(i, j);
                
                if(st.contains(word)) {
                    for(String sub : dp.get(j)) {
                        if(sub.isEmpty()) {
                            dp.get(i).add(word);
                        } else {
                            dp.get(i).add(word + " " + sub);
                        }
                    }
                }
            }
        }
        
        return dp.get(0).toArray(new String[0]);
    }
}
