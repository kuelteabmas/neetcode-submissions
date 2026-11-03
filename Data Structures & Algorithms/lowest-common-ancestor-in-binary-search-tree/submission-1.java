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
            if (curr.val > p.val && curr.val > q.val) { // p and q are on the left side
                curr = curr.left;
            } else if (curr.val < p.val && curr.val < q.val) { // p and q are on the right side
                curr = curr.right;
            } 
            else { // p and are on opposite ends of parent(curr) node OR if one of p & q are equal to parent (curr) node then lca equals curr node
                return curr;
            }
        }
        return null;
    }
}
