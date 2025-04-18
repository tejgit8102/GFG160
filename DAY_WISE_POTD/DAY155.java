//Module 18 - Tries
//Problem 1 - Day155 - Implement Trie

// User function Template for Java
class TrieNode {
    
    TrieNode[] children;
    boolean isEndOfWord;
    
    public TrieNode() {
        
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        
        current.isEndOfWord = true;
        
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode current = root;
        for( char c : word.toCharArray()) {
            int index = c - 'a';
            
            if(current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        
        return current.isEndOfWord;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            
            if(current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        
        return true;
    }
}
