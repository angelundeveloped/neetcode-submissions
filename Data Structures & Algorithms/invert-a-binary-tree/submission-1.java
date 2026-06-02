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
    public TreeNode invertTree(TreeNode root) {
        // Consider the current node is empty
        if (root == null){
            return root;
        }
        // first recursion until we find the deepest node.
        invertTree(root.left);
        invertTree(root.right);

        // if the current node is not empty lets invert
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        return root;
    }
}
