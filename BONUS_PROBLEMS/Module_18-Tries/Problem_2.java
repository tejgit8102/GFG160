//Problem - Maximum XOR With an Element From Array

class Node {
    Node left;
    Node right;
}

class Trie {
    Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(int n) {
        Node temp = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            
            if(bit == 0){
                if(temp.left == null) {
                    temp.left = new Node();
                }
                temp = temp.left;
            } else {
                if(temp.right == null) {
                    temp.right = new Node();
                }
                temp = temp.right;
            }
        }
    }
    
    public int max_XOR_helper(int value) {
        int current_ans = 0;
        Node temp = root;
        
        for(int j = 31; j >= 0; j--) {
            int bit = (value >> j) & 1;
            
            if(bit == 0) {
                if(temp.right != null) {
                    temp = temp.right;
                    current_ans += (1L << j);
                } else {
                    temp = temp.left;
                }
            } else {
                if(temp.left != null) {
                    temp = temp.left;
                    current_ans += (1L << j);
                } else {
                    temp = temp.right;
                }
        }
    }
    return current_ans;
    }
}


class Solution {
    public int[] maxXor(int[] arr, int[][] queries) {
        int n = arr.length, q = queries.length;
        int[] ans = new int[q];
        
        List<int[]> qry = new ArrayList<>();
        
        Arrays.sort(arr);
        
        for(int i = 0; i < q; i++) {
            qry.add(new int[] { queries[i][1], queries[i][0], i});
        }
        
        qry.sort(Comparator.comparingInt(a -> a[0]));
        
        int j = 0;
        Trie tree = new Trie();
        
        for(int i = 0; i < q; i++) {
            while(j < n && arr[j] <= qry.get(i)[0]) {
                tree.insert(arr[j++]);
            }
            
            if(j == 0) {
                ans[qry.get(i)[2]] = -1;
            } else {
                ans[qry.get(i)[2]] = tree.max_XOR_helper(qry.get(i)[1]);
            }
        }
         return ans;
    }
}
