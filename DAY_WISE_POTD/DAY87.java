//Module 11 - Tree
//Problem 8 - Day87 - Maximum path sum from any node

class Solution {
    // Global variable to store the result
    int res = Integer.MIN_VALUE;

    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        maxPathSumUtil(node);
        return res;
    }

    // Helper function to calculate maximum path sum for each node
    int maxPathSumUtil(Node node) {
        if (node == null)
            return 0;

        // Recursively get the maximum sum from left and right subtrees
        int leftSum = Math.max(0, maxPathSumUtil(node.left));  // Ignore negative sums
        int rightSum = Math.max(0, maxPathSumUtil(node.right));

        // Calculate the maximum path sum through the current node
        int currentSum = node.data + leftSum + rightSum;

        // Update the result if currentSum is greater than the previous maximum
        res = Math.max(res, currentSum);

        // Return the maximum sum that can be extended to the parent node
        return node.data + Math.max(leftSum, rightSum);
    }
}
