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
        // === BFS - iterative
        if (root == null) return 0;

        int depth = 0;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()) {
            depth++; // Increment once per level
            int levelSize = que.size(); // number of nodes at current level

            // Process all nodes at the current level
            for (int i = 0 ; i < levelSize; i++) {
                TreeNode node = que.poll();

                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
        }
        return depth;
    }
}
