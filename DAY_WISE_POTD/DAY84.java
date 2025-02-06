//Module 11 - Tree
//Problem 5 - Day84 - Construct Tree from Inorder & Preorder

/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    static int preIndex = 0;
    
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        preIndex = 0;
        return buildTreeRecursive(preorder, inorderMap, 0, inorder.length - 1);
    }
    
    private static Node buildTreeRecursive(int[] preorder, Map<Integer, Integer> inorderMap, int inStart, int inEnd) {
        if(inStart > inEnd) {
            return null;
        }
        
        int rootVal = preorder[preIndex++];
        Node root = new Node(rootVal);
        
        int inorderIndex = inorderMap.get(rootVal);
        
        root.left = buildTreeRecursive(preorder, inorderMap, inStart, inorderIndex - 1);
        root.right = buildTreeRecursive(preorder, inorderMap, inorderIndex + 1, inEnd);
        
        return root;
    }
    
    public static void postOrderTraversal(Node node, List<Integer> result) {
        if(node == null) return;
        
        postOrderTraversal(node.left, result);
        postOrderTraversal(node.right, result);
        result.add(node.data);
    }
}
