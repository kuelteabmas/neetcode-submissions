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
        
        // dfs - recursive
        if (root == null) return 0; // no treenode, no height

        int ld = maxDepth(root.left); // get height of current left treenode/subtree
        int lr = maxDepth(root.right); // get height of current right treenode/subtree

        return 1 + Math.max(ld, lr); // curr treenode height (1) + highest tree height between current left and right subtrees
    }   
}
