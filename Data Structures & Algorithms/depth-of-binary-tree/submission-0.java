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
        int depth = 0;

        if (root == null) return depth;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            depth++;
            if (node.left != null || node.right != null) {
                if (node.left != null) {
                    queue.add(node.left);
                } else if (node.right != null) {
                    queue.add(node.right);
                }
                depth++;
            } 
        }
        return depth;
    }
}
