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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        depthFirstSearch(root, res);
        return res[0];
    }

    public int depthFirstSearch(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int leftLength = depthFirstSearch(root.left, res);
        int rightLength = depthFirstSearch(root.right, res);
        res[0] = Math.max(res[0], leftLength + rightLength);
        return 1 + Math.max(leftLength, rightLength);
    };
}
