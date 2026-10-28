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
    // premise of solution is to get height of each side (left & right sides) of parent node's subtree 
    // and add them and take the highest number between left+right and the res variable

    int res = 0; // global var to hold result - longest path

    public int diameterOfBinaryTree(TreeNode root) {
        dfs_longestPath(root);
        return res;
    }

    // Returns the height of current subtree of parent node
    public int dfs_longestPath(TreeNode curr) {
        if (curr == null) return 0; // no height for empty tree
        
        // get height of each side
        int left = dfs_longestPath(curr.left);
        int right = dfs_longestPath(curr.right);  

        // update res with highest number - res or current  height of left+right   
        res = Math.max(res, left+right);

        return 1 + Math.max(left, right);  // 1 for height of current node + max of both heights of subtree
    }
}
