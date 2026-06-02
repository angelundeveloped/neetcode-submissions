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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if the subroot is null then it is always a subroot
        if (subRoot == null) {
            return true;
        }
        // if the root is null but not the subroot, then false
        if (root == null) {
            return false;
        }
        // now we are at the root nodes and need to compare and check if they are the same tree
        if(this.isSameTree(root, subRoot)) {
            return true;
        }
        //return isSameTree(root, subRoot); // bug where we will exit loop early*****
        // if they are the same we will get a true
        // if they are not wee need to check isSubtree again but for the left and right nodes
        
        return (this.isSubtree(root.left, subRoot) ||
        this.isSubtree(root.right, subRoot));

    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        //lets validate nulls
        if(root == null && subRoot == null) {
            return true; // Match
        }
        // check if either is null
        if (root == null || subRoot == null) {
            return false; // they dont match
        }
        // if the current value is not null and they match
        if (root != null && subRoot != null && root.val == subRoot.val) {
            // They match at the current node
            // Lets check the left and right nodes
            return (this.isSameTree(root.left, subRoot.left) &&
            this.isSameTree(root.right, subRoot.right));
            // thee return is checking that the current tree is the same when false it return false
        }
        return false;
    }
}
