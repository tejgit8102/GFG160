//Problem - Longest Valid Word with All Prefixes

class Node {
    Node[] children = new Node[26];
    boolean eow;
    
    Node() {
        for(int i = 0; i < 26; i++) {
            children[i] = null;
        }
        eow = false;
    }
}


class Solution {
    
    private void insert(Node root, String s) {
        Node curr = root;
        for(char c : s.toCharArray()) {
            int idx = c - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        
        curr.eow = true;
    }
    
    private String longestStringRecur(Node root, String pre) {
        if(root == null) {
            return pre;
        }
        String longest = pre;
        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null && root.children[i].eow) {
                String s = pre + (char)(i + 'a');
                String curr = longestStringRecur(root.children[i], s);
                if(curr.length() > longest.length() || 
                    (curr.length() == longest.length() &&
                      curr.compareTo(longest) < 0)) {
                          longest = curr;
                      }
            }
        }
        return longest;
    }
    
    public String longestValidWord(String[] words) {
        // code here
        Node root = new Node();
        for(String s : words) {
            insert(root, s);
        }
        return longestStringRecur(root, "");
    }
}
