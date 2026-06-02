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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        //check if either one is null
        if (p == null || q == null) {
            return false;
        }
        // check if their current values are equal
        if (p.val == q.val) {
            // if their current values are the same we can continue checking
            // check left node
            return (isSameTree(p.left, q.left) &&  // returns true or false
            isSameTree(p.right, q.right));
            // check right nodes
        }

        return false;
    }
}
