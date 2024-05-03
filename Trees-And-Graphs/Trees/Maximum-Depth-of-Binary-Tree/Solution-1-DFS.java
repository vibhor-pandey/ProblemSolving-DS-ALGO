/**
 * 39 / 39 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 41.9 MB
 *
 * Time Complexity: O(n) -> number of nodes
 * Space Complexity: O(1)
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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        //Get Depth of the current node
        // int leftSubtreeDepth = maxDepth(root.left);
        // int rightSubtreeDepth = maxDepth(root.right);

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}