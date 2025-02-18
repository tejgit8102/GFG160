//Problem - Count BST nodes that lie in a given range

*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    
    static int getCount(Node root, int l, int h) {
        // Your code here
        if(root == null) return 0;
        
        if(root.data <= h && root.data >= l)
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
            
        else if(root.data < l)
            return getCount(root.right, l, h);
        
        else
            return getCount(root.left, l, h);
    }
}
