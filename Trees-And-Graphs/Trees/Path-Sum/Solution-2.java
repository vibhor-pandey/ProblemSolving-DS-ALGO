import common.TreeNode;

/**
 * 117 / 117 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 42.7 MB
 *
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

    int target = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        targetSum -= root.val;

        if(root.left == null && root.right == null) {
            return targetSum == 0;
        }

        boolean left = hasPathSum(root.left, targetSum);
        boolean right = hasPathSum(root.right, targetSum);

        return left || right;
    }
}