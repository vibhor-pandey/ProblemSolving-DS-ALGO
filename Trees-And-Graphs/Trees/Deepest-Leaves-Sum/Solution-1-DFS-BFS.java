/**
 * 39 / 39 test cases passed.
 * Status: Accepted
 * Runtime: 8 ms
 * Memory Usage: 45.8 MB
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

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

    public int deepestLeavesSum(TreeNode root) {
        int maxDepth = getMaxDepth(root);
        return getDeepestSum(root, maxDepth);
    }

    private int getDeepestSum(TreeNode node, int depth) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int currentLevel = 1;
        int ans = 0;
        while(!queue.isEmpty()) {
            int nodes = queue.size();
            for(int i = 0; i < nodes; i++) {
                TreeNode current = queue.poll();
                if(currentLevel == depth) {
                    ans += current.val;
                }
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            currentLevel++;
        }
        return ans;
    }

    private int getMaxDepth(TreeNode node) {
        if(node == null) return 0;

        if(node.left == null && node.right == null) return 1;

        return Math.max(getMaxDepth(node.left), getMaxDepth(node.right)) + 1;
    }
}