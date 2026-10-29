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

    int res = 0; // global diameter variable

    public int diameterOfBinaryTree(TreeNode root) {        
        dfs(root);
        return res;
    }

    // returns height of current subtree of parent node
    public int dfs(TreeNode curr) {
        if (curr == null) return 0; // no height for an empty tree

        // get height of each side of tree
        int left = dfs(curr.left);
        int right = dfs(curr.right);

        // update res with highest number - res or current height of left+right
        res = Math.max(res, left+right);

        // 1 for height of curr node + max between both heights of left and right subtrees
        return 1 + Math.max(left, right);
    }
}
