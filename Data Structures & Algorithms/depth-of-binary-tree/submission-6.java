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
        
        int d = 0;
        if (root == null) return 0;

        int lvlSize = 0;
        int ld = maxDepth(root.left);
        int lr = maxDepth(root.right);
        lvlSize = Math.max(ld,lr);
        return 1 + Math.max(d, lvlSize);
    }   
}
