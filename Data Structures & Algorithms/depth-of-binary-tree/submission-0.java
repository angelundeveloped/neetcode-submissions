/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        // We need to traverse through the tree, each node has a left or right node
        // if not that is not the max depth
        // We need to handle recursion as such lets handle the base case first
        if (root == null) {
            return 0; // We return zero because there is no node here, no depth
        }
        
        int max_depth = 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right));

        return max_depth;
    }
}
