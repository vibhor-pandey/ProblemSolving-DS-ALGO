/**
 * 63 / 63 test cases passed.
 * Status: Accepted
 * Runtime: 2 ms
 * Memory Usage: 51.6 MB
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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return traverse(root, Integer.MIN_VALUE);
    }

    private int traverse(TreeNode node, int max) {
        if(node == null) return 0;

        int left = traverse(node.left, Math.max(node.val, max));
        int right = traverse(node.right, Math.max(node.val, max));
        int ans = left + right;
        if(node.val >= max) ans++;
        return ans;
    }
}