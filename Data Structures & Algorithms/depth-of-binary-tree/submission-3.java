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

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()) {
            depth++;
            int levelSize = que.size(); // keep track of queue size in order to 

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = que.poll();
                if (node.right != null) que.add(node.right);
                if (node.left != null) que.add(node.left);
                
            }
        }
        return depth;
    }
}
