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
    public boolean isBalanced(TreeNode root) {
        // return true or false
        return depthFirstSearch(root)[0] == 1;
    }

    // we need to implement the logic for depthFirstSearch
    private int[] depthFirstSearch(TreeNode root) {
        // if the current node is null
        if (root == null) {
            return new int[]{1, 0};
        }

        int[] left = depthFirstSearch(root.left);
        int[] right = depthFirstSearch(root.right);

        // flag to check if this is balanced
        boolean balanced = (left[0] == 1 && right[0] == 1) && (Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1], right[1]);

        return new int[]{balanced ? 1: 0, height};
    }
}
