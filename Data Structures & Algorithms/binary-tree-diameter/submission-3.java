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
    int maxHeight = 0; // global var

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return maxHeight;
    }

    // get height of subtree
    public int getHeight(TreeNode node) {
        if (node == null) return 0; // no node, no height

        // get height of left and right subtrees
        int left = getHeight(node.left);
        int right = getHeight(node.right);

        // update maxheight 
        maxHeight = Math.max(maxHeight, left+right);

        // 1 (current height) + heighest height between left and right subtree height
        return 1 + Math.max(left, right);
    }
}
