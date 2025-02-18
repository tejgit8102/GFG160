//Problem - Distribute candies in a binary tree

*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

class Solution {
    
    static int distributeCandyUtil(Node root, int[] ans) {
        
        if(root == null) return 0;
        
        int l = distributeCandyUtil(root.left, ans);
        
        int r = distributeCandyUtil(root.right, ans);
        
        ans[0] += Math.abs(l) + Math.abs(r);
        
        return root.data + l + r - 1;
    }
    
    static int distributeCandy(Node root) {
        // code here
        int[] ans = new int[1];
        
        distributeCandyUtil(root, ans);
        
        return ans[0];
    }
}
