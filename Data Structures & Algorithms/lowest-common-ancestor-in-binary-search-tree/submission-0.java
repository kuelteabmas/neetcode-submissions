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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode curr = root;
        while (curr != null) {
            if (p.val > curr.val && q.val > curr.val) { // p and q are on right side of node 
                curr = curr.right;
            } else if (p.val < curr.val && q.val < curr.val) {// p and q are on left side of node 
                curr = curr.left;
            }
            else { // p and q are on opposite end of curr node OR p or q are equal to curr. Either way, curr is the lowest node that has both as descendants, so it's the LCA.
                return curr;
            }
        }
        return null;
    }
}
