//Problem - Balanced Tree Check

/* A binary tree node class
class Node
{
    int data;
    Node left,right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
} */

class Solution {
    static int isBalancedRec(Node root) {
        // code here
        
        if(root == null) return 0;
        
        int lHeight = isBalancedRec(root.left);
        int rHeight = isBalancedRec(root.right);
        
        if(lHeight == -1 || rHeight == -1 || Math.abs(lHeight - rHeight) > 1)
            return -1;
        
        return Math.max(lHeight, rHeight) + 1;
    }
    
    static boolean isBalanced(Node root) { return isBalancedRec(root) > 0; }
}
